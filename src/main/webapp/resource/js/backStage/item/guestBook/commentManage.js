/**
 * 
 */
$(function() {
	
	/**
	 * 进页面品牌查询列表
	 */
	brandListQuery("comment/commentPage", {
		"userName" : "",
		"handleState":0
	});
	/**
	 * 全选
	 */
	$("#comment_checkAll").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .commentCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .commentCheckBox").prop("checked", false);
		}
	});
	//新增留言
	
	$('#add_comment').on('click', function() {
		layer.config({
			skin : 'layer-ext-evm'
		});

		layer.open({
			type : 2,
			title : '新增',
			shadeClose : false,
			shade : 0.5,
			area : [ '60%', '90%' ],
			content : 'toAddcomment'
		});
	});
	/**
	 * 查询
	 */
	$("#comment_select").click(function() {
		
		var name = $("#userName").val().trim();
		
		var handleState=$(this).attr("data-state");
		
		var params = {
			"userName" : name,
			"handleState":handleState
		};
		brandListQuery("comment/commentPage", params);

	});
	//根据状态查
	$(".browse").unbind("click").bind(
			"click",
			function() {
		
		var name="";
		var handleState=$(this).attr("data-state");
		
		var params = {
			"userName" : name,
			"handleState":handleState
		};
		brandListQuery("comment/commentPage", params);

	});
	function delGuestBook(ids) {
		if ($(".commentCheckBox:checked").length == 0) {
			toastr.warning("请选择要删除的品牌");
			return false;
		}

		layer.confirm("确认删除选中的留言 ？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".commentCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
			$.ajax({
				"type" : "POST",
				"url" : "comment/deletecomment",
				"dataType" : "json",
				"data" : {
					"guestBookID" : ids,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("删除成功");
						toastr.subscribe(function() {
							layer.close(index);
							// 模拟点击事件
							var queryBtn = $("#comment_select");
							$(queryBtn).trigger("click");
						});
					} else {
						toastr.error("删除失败");
					}
				},
				"error" : function(data) {
					toastr.warning("error");
				}
			});
		});

	}
	;
	/**
	 * 用户显示表格
	 */
	function brandListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"80px","data":"commentID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='commentCheckBox' value='"+sData+"'/>");
				  			}},
							{"width":"200px","data":"userName","defaultContent":"","name":"user_name"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"200px","data":"commentContent","defaultContent":"","name":"comment_content"},
							{"width":"200px","data":"commentDate","defaultContent":"","name":"comment_date"},
							{"width":"150px","class":"handleState","data":"handleState","defaultContent":"","name":"handle_state","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "已浏览" : "未浏览");
							}},
							{"width":"150px","class":"commentLevel","data":"handleState","defaultContent":"","name":"comment_level","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "好评" : "差评");
							}},
							{"width":"150px", "data":"commentID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-comment-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" +
										"<a href='javascript:void(0);' data-comment-id='"+sData+"' title='回复' class='edit_basic btn btn-xs btn-info'><i class='icon-edit bigger-120'></i></a>");
					  		}} ],
			"checkbox" : 1,
			"iDisplayLength" : 5, // 每页显示记录数，可选
			"sAjaxSource" : url, // 获取数据的url
			"myData" : paramters, // 自定义参数，会被拼接到url参数中,要求数据格式必须为:[{"name":"名称","value":"值"}]
			"order" : [ 1, "asc" ], // 默认排序列
			"after" : tableInit, // 表格初始化完毕后的回调函数
		};

		dataTable = $("#sample-table").table(options);
		return dataTable;
	}
	;
	function tableInit() {
		$(".edit_basic").unbind("click").bind(
				"click",
				function() {
					var commentID = $(this).parent().parent().find(
							"input.commentCheckBox").val();
					// alert(userId);
					
					layer.config({
						skin : 'layer-ext-evm'
					});

					layer.open({
						type : 2,
						title : "回复评论 " + "",
						shadeClose : false,
						shade : 0.5,
						area : [ '60%', '70%' ],
						content : [
								"comment/getCommentByCommentID?commentID="
										+ commentID, 'no' ]
					});
				});
		
		$(".state").on('click', function() {
			
			var commentID = $(this).parent().parent().find(
					"input.commentCheckBox").val();
			
			layer.config({
				skin : 'layer-ext-evm'
			});
			var handleState=null;
			var state=$(this).parent().parent().find(
			"td:eq(4)").text();
			if(state=="已浏览"){
				toastr.success("该信息已被浏览，不需要修改");
				return;
			}else{
				handleState=1;
			}
			layer.confirm("确认要修改状态", {
				title : "修改",
				btn : [ '是', '否' ]},function(index){
					$.ajax({
						"type" : "POST",
						"url" : "comment/updateCommentState",
						"dataType" : "json",
						"data" : {
							"commentID" : commentID,
							"handleState":handleState,
							"forward" : "JSON"
						},
						"success" : function(data) {
							if (data) {
								toastr.success("状态修改成功");
								toastr.subscribe(function() {
									layer.close(index);
									// 模拟点击事件
									var queryBtn = $("#comment_select");
									$(queryBtn).trigger("click");
								});
							} else {
								toastr.error("状态修改失败");
							}
						},
						"error" : function(data) {
							toastr.warning("error");
						}
					});
				}
			)
			

});
	}
})