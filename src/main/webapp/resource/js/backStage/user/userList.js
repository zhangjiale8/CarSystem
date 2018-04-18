/**
 * 
 */
$(function() {

	/**
	 * 进页面查用户列表
	 */
	userListQuery("user/getUserByUserName", {
		"userName" : ""
	});
	
	var dataTable = null;
	/**
	 * 全选
	 */
	$("#userinfo_checkAll").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .userCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .userCheckBox").prop("checked", false);
		}
	});
	
	
	function delUsers(ids) {
		if ($(".userCheckBox:checked").length == 0) {
			toastr.warning("请选择要删除的用户");
			return false;
		}

		layer.confirm("确认删除选中的用户 ？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".userCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
			$.ajax({
				"type" : "POST",
				"url" : "user/deleteUser",
				"dataType" : "json",
				"data" : {
					"userIDs" : ids,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("删除成功");
						toastr.subscribe(function() {
							layer.close(index);
							// 模拟点击事件
							var queryBtn = $("#userinfo_select");
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
	 * 添加
	 */
	$("#member_add").on('click', function() {
		layer.config({
			skin : 'layer-ext-evm'
		});

		layer.open({
			type : 2,
			title : '新增管理员',
			shadeClose : false,
			shade : 0.5,
			scrollbar : false,
			area : [ '70%', '70%' ],
			content : 'toAddUser'
		});
	});

	/**
	 * 查询
	 */
	$("#userinfo_select").click(function() {

		var name = $("#userName").val().trim();
		var params = {
			"userName" : name
		};
		userListQuery("user/getUserByUserName", params);

	});
	

	/**
	 * 用户显示表格
	 */
	function userListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"80px","data":"user.userID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='userCheckBox' value='"+sData+"'/>");
				  			}},
							{"width":"150px","data":"user.userName","defaultContent":"","name":"user_name"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"150px","data":"user.userShowName","defaultContent":"","name":"user_show_name"},
							{"width":"200px", "data":"user.userPhone","defaultContent":"","name":"user_phone"},
							{"width":"200px","data":"user.userJoinDate","defaultContent":"","name":"user_join_date"},
							{"width":"150px", "data":"role.roleId","defaultContent":"","name":"role_id","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "管理员" : "客户");
							}},
							{"width":"150px","class":"state","data":"user.state","defaultContent":"","name":"state","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "已启用" : "已停用");
							}},
							{"width":"300px", "data":"user.userID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-customer-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" +
										"<a href='javascript:void(0);' data-user-id='"+sData+"' title='编辑' class='edit_basic btn btn-xs btn-info'><i class='icon-edit bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-user-id='"+sData+"' title='删除' class='userinfo_deleteid btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
					  		}} ],
			"checkbox" : 1,
			"iDisplayLength" : 5, // 每页显示记录数，可选
			"sAjaxSource" : url, // 获取数据的url
			"myData" : paramters, // 自定义参数，会被拼接到url参数中,要求数据格式必须为:[{"name":"名称","value":"值"}]
			"order" : [ 4, "asc" ], // 默认排序列
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
					var userId = $(this).parent().parent().find(
							"input.userCheckBox").val();
					// alert(userId);
					if (parseInt(userId) === 1) {
						toastr.error("该用户不可编辑!!");
						return false;
					}
					layer.config({
						skin : 'layer-ext-evm'
					});

					layer.open({
						type : 2,
						title : "编辑用户 " + "",
						shadeClose : false,
						shade : 0.5,
						area : [ '70%', '80%' ],
						content : [
								"user/getUserByUserID?userID="
										+ userId, 'no' ]
					});
				});
		/**
		 * 删除
		 */
		$(".userinfo_deleteid").on('click', function() {
				
			var ids = "";
			var b = false;
			$("#sample-table .userCheckBox").each(function() {
				if ($(this).prop("checked")) {
					var id = $(this).val();
					ids = ids + id + ",";
					if (parseInt(id) === 1) {
						b = true;
					}
				}
			});
			
			if (b) {
				toastr.error("用户[sysadmin]不可删除！！");
				return false;
			}
			ids = ids.substr(0, ids.length - 1);
			delUsers(ids);
		});
		/**
		 * 删除
		 */
		$(".userinfo_delete").on('click', function() {
				
			var ids = new Array();
			var b = false;
			var id = $(this).parent().parent().find(
			"input .userCheckBox").val();
			if (parseInt(id) === 1) {
				b = true;
			}
			if (b) {
				toastr.error("用户[sysadmin]不可删除！！");
				return false;
			}
			ids.push(parseInt(id));
			layer.confirm("确认删除选中的用户 ？ ", {
				title : "删除",
				btn : [ '是', '否' ]
			}, function(index) {
				var ids = new Array();
				$(".userCheckBox:checked").each(function(index, item) {
					ids.push(parseInt($(item).val()));
				});
				$.ajax({
					"type" : "POST",
					"url" : "user/deleteUser",
					"dataType" : "json",
					"data" : {
						"userIDs" : ids,
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("删除成功");
							toastr.subscribe(function() {
								layer.close(index);
								// 模拟点击事件
								var queryBtn = $("#userinfo_select");
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
		});
		$(".state").on('click', function() {
			
					var userId = $(this).parent().parent().find(
							"input.userCheckBox").val();
					// alert(userId);
					if (parseInt(userId) === 1) {
						toastr.error("该用户状态不可更改!!");
						return false;
					}
					layer.config({
						skin : 'layer-ext-evm'
					});
					var stateID=null;
					var state=$(this).parent().parent().find(
					"td:eq(6)").text();
					
					if(state=="已启用"){
						stateID=2;
					}else{
						stateID=1
					}
					layer.confirm("确认要修改状态", {
						title : "修改",
						btn : [ '是', '否' ]},function(index){
							$.ajax({
								"type" : "POST",
								"url" : "user/updateState",
								"dataType" : "json",
								"data" : {
									"userID" : userId,
									"state":stateID,
									"forward" : "JSON"
								},
								"success" : function(data) {
									if (data) {
										toastr.success("状态修改成功");
										toastr.subscribe(function() {
											layer.close(index);
											// 模拟点击事件
											var queryBtn = $("#userinfo_select");
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
