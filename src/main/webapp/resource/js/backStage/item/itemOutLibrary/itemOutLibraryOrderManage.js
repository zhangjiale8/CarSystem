/**
 * 
 */
$(function() {
	var itemClassificationID=$("#outLibrary").attr("data-class-id");
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
	outLibraryListQuery("itemOutLibraryOrder/itemOutLibraryPage", {
		
		"outLibraryCode" : "",
		"startTime" : "",
		"endTime" : "",
		"itemClassificationID":itemClassificationID
	});
	$('#item_outLibrary').on('click', function() {
		layer.config({
			skin : 'layer-ext-evm'
		});
		var classID=$(this).attr("date-class-id");
		if(classID==1){
			layer.open({
				type : 2,
				title : '新增',
				shadeClose : false,
				shade : 0.5,
				area : [ '90%', '90%' ],
				content : 'toVehicleOutLibrary'
			});
		}else{
			layer.open({
				type : 2,
				title : '新增',
				shadeClose : false,
				shade : 0.5,
				area : [ '95%', '95%' ],
				content : 'toFittingOutLibrary'
			});
		}
		
	});
	/**
	 * 全选
	 */
	$("#outLibrary_checkbox").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .outLibraryCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .outLibraryCheckBox").prop("checked", false);
		}
	});
	$("#outLibrary").on('click', function() {
		var outLibraryCode = $("#outLibraryCode").val().trim();
		var startTime=$("#start").val().trim();
		var endTime=$("#end").val().trim();
		var itemClassificationIDss=$(this).attr("data-class-id");
	
		var params = {
				"outLibraryCode" : outLibraryCode,
				"startTime" : startTime,
				"endTime" : endTime,
				"itemClassificationID":itemClassificationIDss
		};
		outLibraryListQuery("itemOutLibraryOrder/itemOutLibraryPage", params);
	})
	/**
	 * 查询
	 */
	$("#outLibrary_select").click(function() {
		var itemClassificationIDs=$("#outLibrary").attr("data-class-id");
		var outLibraryCode = $("#outLibraryCode").val().trim();
		var startTime=$("#start").val().trim();
		var endTime=$("#end").val().trim();
		var params = {
				"outLibraryCode" : outLibraryCode,
				"startTime" : startTime,
				"endTime" : endTime,
				"itemClassificationID":itemClassificationIDs
		};
		outLibraryListQuery("itemOutLibraryOrder/itemOutLibraryPage", params);

	});
	/**
	 * 删除
	 */
	function deloutLibraryOrder(ids) {
		if ($(".outLibraryCheckBox:checked").length == 0) {
			toastr.warning("请选择要删除的出库单");
			return false;
		}

		layer.confirm("确认删除选中的出库单 ？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".outLibraryCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
			$.ajax({
				"type" : "POST",
				"url" : "itemOutLibraryOrder/deleteItemOutLibraryOrder",
				"dataType" : "json",
				"data" : {
					"outLibraryID" : ids,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("删除成功");
						toastr.subscribe(function() {
							layer.close(index);
							// 模拟点击事件
							var queryBtn = $("#outLibrary_select");
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
	function outLibraryListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"40px","data":"outLibraryID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='outLibraryCheckBox' value='"+sData+"'/>");
				  			}},
			               {"width":"110px","data":"outLibraryCode","defaultContent":"","name":"out_library_code"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"90px", "data":"item.itemClass.itemClassificationName","defaultContent":"","name":"item_classification_name"},
							{"width":"90px","data":"item.itemName","defaultContent":"","name":"item_name"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"90px","data":"item.itemCode","defaultContent":"","name":"item_code"},
							{"width":"90px","data":"item.itemColor","defaultContent":"","name":"item_color"},
							{"width":"90px", "data":"outLibraryNum","defaultContent":"","name":"out_library_num"},
							{"width":"90px","data":"outLibraryReason","defaultContent":"","name":"out_library_reason"},
							{"width":"90px","data":"wareHouse.wareHouseName","defaultContent":"","name":"warehouse_name"},
							{"width":"90px","data":"createPerson","defaultContent":"","name":"create_person"},
							{"width":"90px","data":"outLibraryDate","defaultContent":"","name":"out_library_date"},
							{"width":"90px","data":"outLibraryState","class":"state","defaultContent":"","name":"out_library_state","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "待出库" : "已出库");
							}},
							{"width":"200px", "data":"outLibraryID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-item-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" +
										"<a href='javascript:void(0);' data-outLibrary-id='"+sData+"' title='修改' class='edit_basic btn btn-xs btn-info'><i class='icon-edit bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-outLibrary-id='"+sData+"' title='删除' class='outLibraryOrder_deleteid btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
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
					var itemOutLibraryID = $(this).parent().parent().find(
							"input.outLibraryCheckBox").val();
					// alert(userId);
					
					layer.config({
						skin : 'layer-ext-evm'
					});

					layer.open({
						type : 2,
						title : "修改出库单 " + "",
						shadeClose : false,
						shade : 0.5,
						area : [ '75%', '95%' ],
						content : [
								"itemOutLibraryOrder/getItemOutLibraryOrderByOutLibraryID?itemOutLibraryID="
										+ itemOutLibraryID, 'no' ]
					});
				}
		);
				
		/**
		 * 删除
		 */
		$(".outLibraryOrder_delete").on('click', function() {
			var ids = "";
			$("#sample-table .outLibraryCheckBox").each(function() {
				if ($(this).prop("checked")) {
					var id = $(this).val();
					
					ids = ids + id + ",";
					
				}
			});
			
			
			ids = ids.substr(0, ids.length - 1);
			deloutLibraryOrder(ids);
		});
		/**
		 * 删除
		 */
		$(".outLibraryOrder_deleteid").on('click', function() {
			var ids = new Array();
			
			var id = $(this).parent().parent().find(
			"input.guestBookCheckBox").val();
			
			ids.push(parseInt(id));
			layer.confirm("确认删除选中的出库单 ？ ", {
				title : "删除",
				btn : [ '是', '否' ]
			}, function(index) {
				
				$.ajax({
					"type" : "POST",
					"url" : "itemOutLibraryOrder/deleteItemOutLibraryOrder",
					"dataType" : "json",
					"data" : {
						"outLibraryID" : ids,
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("删除成功");
							toastr.subscribe(function() {
								layer.close(index);
								// 模拟点击事件
								var queryBtn = $("#outLibrary_select");
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
		//修改状态
		$(".state").on('click', function() {
					var outLibraryID = $(this).parent().parent().find(
							"input.outLibraryCheckBox").val();

					layer.config({
						skin : 'layer-ext-evm'
					});
					var outLibraryState = null;
					var state = $(this).parent().parent().find(".state")
							.text();
					if (state == "已出库") {
						toastr.error("该商品已出库，不需要修改");
						return;
					} else {
						outLibraryState = 2;
					}
					layer.confirm("确认要修改状态", {
						title : "修改",
						btn : [ '是', '否' ]
					}, function(index) {
						$.ajax({
							"type" : "POST",
							"url" : "itemOutLibraryOrder/updateOutLibraryOrderState",
							"dataType" : "json",
							"data" : {
								"outLibraryID" : outLibraryID,
								"outLibraryState" : outLibraryState,
								"forward" : "JSON"
							},
							"success" : function(data) {
								if (data) {
									toastr.success("状态修改成功");
									toastr.subscribe(function() {
										layer.close(index);
										// 模拟点击事件
										var queryBtn = $("#outLibrary_select");
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
					})
				});
	}
	
})