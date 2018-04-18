/**
 * 
 */
$(function() {
	var itemClassificationID=$("#itemOrder").attr("data-class-id");
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
	outOrderListQuery("itemOrder/getItemOrderPage", {
		
		"itemOrderCode" : "",
		"startTime" : "",
		"endTime" : "",
		"itemClassificationID":itemClassificationID
	});
	$('#add_itemOrder').on('click', function() {
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
				content : 'toAddItemOrder'
			});
		}else{
			layer.open({
				type : 2,
				title : '新增',
				shadeClose : false,
				shade : 0.5,
				area : [ '95%', '95%' ],
				content : 'toAddItemOrder'
			});
		}
		
	});
	/**
	 * 全选
	 */
	$("#itemOrder_checkbox").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .itemOrderCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .itemOrderCheckBox").prop("checked", false);
		}
	});
	
	/**
	 * 查询
	 */
	$("#itemOrder_select").click(function() {
		var itemOrderCode = $("#itemOrderCode").val().trim();
		var startTime=$("#start").val().trim();
		var endTime=$("#end").val().trim();
		var params = {
				"itemOrderCode" : itemOrderCode,
				"startTime" : startTime,
				"endTime" : endTime,
				"itemClassificationID":itemClassificationID
		};
		outOrderListQuery("itemOrder/getItemOrderPage", params);

	});
	/**
	 * 删除
	 */
	function deleteItemOrder(ids) {
		if ($(".itemOrderCheckBox:checked").length == 0) {
			toastr.warning("请选择要删除的订单");
			return false;
		}

		layer.confirm("确认删除选中的订单 ？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".itemOrderCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
			$.ajax({
				"type" : "POST",
				"url" : "itemOrder/deleteItemOrder",
				"dataType" : "json",
				"data" : {
					"itemOrderID" : ids,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("删除成功");
						toastr.subscribe(function() {
							layer.close(index);
							// 模拟点击事件
							var queryBtn = $("#itemOrder_select");
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
	function outOrderListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"40px","data":"itemOrderID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='itemOrderCheckBox' value='"+sData+"'/>");
				  			}},
			               {"width":"140px","data":"itemOrderCode","defaultContent":"","name":"order_code"},
			               {"width":"140px","data":"item.itemCode","defaultContent":"","name":"item_code"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"90px", "data":"item.itemClass.itemClassificationName","defaultContent":"","name":"item_classification_name"},
							{"width":"90px","data":"item.itemName","defaultContent":"","name":"item_name"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"90px","data":"item.itemColor","defaultContent":"","name":"item_color"},
							
							{"width":"90px", "data":"itemNum","defaultContent":"","name":"item_num"},
							{"width":"90px","data":"totalPrice","defaultContent":"","name":"total_price"},
							
							{"width":"90px","data":"payMethod","defaultContent":"","name":"pay_method","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "线上支付" : "线下支付");
							}},
							{"width":"90px","data":"customer.userName","defaultContent":"","name":"user_name"},
							/*{"width":"90px","data":"address","sClass":"wrap","defaultContent":"","name":"address","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								if (sData.length > 10) {
					                $(nTd).html( sData.substr(0, 9));
					                $(nTd).attr("title",sData)
					            }
								
							}},*/
							{"width":"90px","data":"createDate","defaultContent":"","name":"create_date"},
							{"width":"90px","data":"orderState","class":"state","defaultContent":"","name":"order_state"},
							{"width":"200px", "data":"itemOrderID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-item-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" +
										"<a href='javascript:void(0);' data-outLibrary-id='"+sData+"' title='修改' class='edit_basic btn btn-xs btn-info'><i class='icon-edit bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-outLibrary-id='"+sData+"' title='删除' class='itemOrder_deleteid btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
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
					var itemOrderID = $(this).parent().parent().find(
							"input.itemOrderCheckBox").val();
					// alert(userId);
					
					layer.config({
						skin : 'layer-ext-evm'
					});

					layer.open({
						type : 2,
						title : "修改订单 " + "",
						shadeClose : false,
						shade : 0.5,
						area : [ '75%', '95%' ],
						content : [
								"itemOrder/getItemOrderByItemOrderID?itemOrderID="
										+ itemOrderID, 'no' ]
					});
				}
		);
				
		/**
		 * 删除
		 */
		$(".itemOrder_delete").on('click', function() {
			var ids = "";
			$("#sample-table .itemOrderCheckBox").each(function() {
				if ($(this).prop("checked")) {
					var id = $(this).val();
					
					ids = ids + id + ",";
					
				}
			});
			
			
			ids = ids.substr(0, ids.length - 1);
			deleteItemOrder(ids);
		});
		/**
		 * 删除
		 */
		$(".itemOrder_deleteid").on('click', function() {
			var ids = new Array();
			
			var id = $(this).parent().parent().find(
			"input.itemOrderCheckBox").val();
			
			ids.push(parseInt(id));
			layer.confirm("确认删除选中的订单 ？ ", {
				title : "删除",
				btn : [ '是', '否' ]
			}, function(index) {
				
				$.ajax({
					"type" : "POST",
					"url" : "itemOrder/deleteItemOrder",
					"dataType" : "json",
					"data" : {
						"itemOrderID" : ids,
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("删除成功");
							toastr.subscribe(function() {
								layer.close(index);
								// 模拟点击事件
								var queryBtn = $("#itemOrder_select");
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
					var itemOrderID  = $(this).parent().parent().find(
							"input.itemOrderCheckBox").val();
					
					layer.config({
						skin : 'layer-ext-evm'
					});
					var orderState = null;
					var state = $(this).parent().parent().find(".state")
							.text();
					if (state == "已出库") {
						toastr.error("该商品已出库，不能修改");
						return;
					} else {
						layer.open({
							type : 2,
							title : "选择状态" + "",
							shadeClose : false,
							shade : 0.5,
							area : [ '30%', '40%' ],
							content : [
									"itemOrder/getItemOrderStateByItemOrderID?itemOrderID="+itemOrderID, 'no' ]
						});
					}
					
				});
	}
	
})