/**
 * 
 */
$(function() {
	var itemClassificationID=$("#item_enterLibrary").attr("data-class-id");
	$('#start').on('focus', function(e){ //假设 test1 是一个按钮
		  var endTime=$('#end').val();
		  laydate({
		    elem: '#start',
		    max:endTime
		  });
	});
	$('#end').on('focus', function(e){ //假设 test1 是一个按钮
		var startTime=$('#start').val();
		laydate({
		    elem: '#end',
		    min:startTime
		  });
	});
	/**
	 * 进页面品牌查询列表
	 */
	enterLibraryListQuery("itemEnterLibraryOrder/itemEnterLibraryPage", {
		
		"enterLibraryCode" : "",
		"startTime" : "",
		"endTime" : "",
		"itemClassificationID":itemClassificationID
	});
	$('#item_enterLibrary').on('click', function() {
		
		$(".item").css("display","block");
		$(".enter").css("display","none");
		layer.config({
			skin : 'layer-ext-evm'
		});
		
		
		layer.open({
			type : 2,
			title : '新增入库商品自动生成入库单',
			shadeClose : false,
			shade : 0.5,
			area : [ '90%', '90%' ],
			content : 'toAddVehicleItem'
		});
		
		
	});
	/**
	 * 全选
	 */
	$("#enterLibrary_checkbox").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .enterLibraryCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .enterLibraryCheckBox").prop("checked", false);
		}
	});
	
	/**
	 * 查询
	 */
	$("#enterLibrary_select").click(function() {
		
		$(".enter").css("display","block");
		$(".item").css("display","none");
		var enterLibraryCode = $("#enterLibraryCode").val().trim();
		var startTime=$("#start").val().trim();
		var endTime=$("#end").val().trim();
		var params = {
				"enterLibraryCode" : enterLibraryCode,
				"startTime" : startTime,
				"endTime" : endTime,
				"itemClassificationID":itemClassificationID
		};
		enterLibraryListQuery("itemEnterLibraryOrder/itemEnterLibraryPage", params);

	});
	
	/**
	 * 删除
	 */
	function delEnterLibraryOrder(ids) {
		

		layer.confirm("确认删除选中的入库单 ？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".enterLibraryCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
			$.ajax({
				"type" : "POST",
				"url" : "itemEnterLibraryOrder/deleteItemEnterLibraryOrder",
				"dataType" : "json",
				"data" : {
					"enterLibraryID" : ids,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("删除成功");
						toastr.subscribe(function() {
							layer.close(index);
							// 模拟点击事件
							var queryBtn = $("#enterLibrary_select");
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
	function enterLibraryListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"40px","data":"enterLibraryID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='enterLibraryCheckBox' value='"+sData+"'/>");
				  			}},
			               {"width":"110px","data":"enterLibraryCode","defaultContent":"","name":"enter_library_code"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"90px", "data":"item.itemClass.itemClassificationName","defaultContent":"","name":"item_classification_name"},
							{"width":"90px","data":"item.itemName","defaultContent":"","name":"item_name"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"90px","data":"item.itemCode","defaultContent":"","name":"item_code"},
							{"width":"90px","data":"item.itemColor","defaultContent":"","name":"item_color"},
							{"width":"90px", "data":"enterLibraryNum","defaultContent":"","name":"enter_library_num"},
							{"width":"90px", "data":"item.itemPrice","defaultContent":"","name":"item_price"},
							{"width":"90px","data":"enterLibraryReason","defaultContent":"","name":"enter_library_reason","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "销售" : "-----");
							}},
							{"width":"90px","data":"wareHouse.wareHouseName","defaultContent":"","name":"warehouse_name"},
							{"width":"90px","data":"createPerson","defaultContent":"","name":"create_person"},
							{"width":"90px","data":"enterLibraryDate","defaultContent":"","name":"enter_library_date"},
							
							{"width":"200px", "data":"enterLibraryID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html(
										"<a href='javascript:void(0);' data-enterLibrary-id='"+sData+"' title='修改' class='edit_basic btn btn-xs btn-info'><i class='icon-edit bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-enterLibrary-id='"+sData+"' title='删除' class='enterLibraryOrder_deleteid btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
					  		}}
							],
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
	
	function tableInit() {
		
		$(".edit_basic").unbind("click").bind(
				"click",
				function() {
					var itemEnterLibraryID = $(this).parent().parent().find(
							"input.enterLibraryCheckBox").val();
					// alert(userId);
					
					layer.config({
						skin : 'layer-ext-evm'
					});

					layer.open({
						type : 2,
						title : "修改入库单 " + "",
						shadeClose : false,
						shade : 0.5,
						area : [ '65%', '65%' ],
						content : [
								"itemEnterLibraryOrder/getItemEnterLibraryOrderByEnterLibraryID?itemEnterLibraryID="
										+ itemEnterLibraryID, 'no' ]
					});
				}
		);
				
		/**
		 * 删除
		 */
		$(".enterLibraryOrder_delete").on('click', function() {
			var ids = "";
			$("#sample-table .enterLibraryCheckBox").each(function() {
				if ($(this).prop("checked")) {
					var id = $(this).val();
					
					ids = ids + id + ",";
					
				}
			});
			if (ids == "") {
				toastr.error("请至少选择一个入库单!");
				return false;
			}
			
			ids = ids.substr(0, ids.length - 1);
			delEnterLibraryOrder(ids);
		});
		$(".enterLibraryOrder_deleteid").on('click', function() {
			var ids = new Array();
			
			var itemEnterLibraryID = $(this).parent().parent().find(
			"input.enterLibraryCheckBox").val();
			
			ids.push(parseInt(itemEnterLibraryID));
			layer.confirm("确认删除选中的入库单 ？ ", {
				title : "删除",
				btn : [ '是', '否' ]
			}, function(index) {
				$.ajax({
					"type" : "POST",
					"url" : "itemEnterLibraryOrder/deleteItemEnterLibraryOrder",
					"dataType" : "json",
					"data" : {
						"enterLibraryID" : ids,
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("删除成功");
							toastr.subscribe(function() {
								layer.close(index);
								// 模拟点击事件
								var queryBtn = document.getElementById("enterLibrary_select");
								
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
	}
	
	$("#photo").on('click',function(){
		var itemID=$("#itemID").text();
		if(itemID==""||itemID==null||itemID=="undefind"){
			toastr.error("请先添加商品!");
			return;
		}
		layer.config({
			skin : 'layer-ext-evm'
		});
		
		layer.open({
			type : 2,
			title : '绑定商品图片',
			shadeClose : false,
			shade : 0.5, 
			area : [ '85%', '85%' ],
			content : ['photo/addPhoto?itemID='+ itemID]
		});
		
	})
})