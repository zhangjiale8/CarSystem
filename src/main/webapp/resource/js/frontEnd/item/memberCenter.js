/**
 * 
 */
$(function(){
	var userName = $("#text").text().trim();
	var paramters={"customerName":userName}
	itemOrderListQuery("itemOrder/getItemOrderByCustomerName", paramters);
	$("#orders").on('click',function(){
		$("#look").hide();
		$("#order").show();
		var paramters={"customerName":userName};
		itemOrderListQuery("itemOrder/getItemOrderByCustomerName", paramters);
	})
	
	$("#lookOrder").on('click',function(){
		$("#order").hide();
		$("#look").show();
		var paramters={"customerName":userName};
		lookCarOrderListQuery("lookCarOrder/getLookCarOrderByCustomerName", paramters);

	})
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

	function itemOrderListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"40px","data":"itemOrderID","class":"td","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='itemOrderCheckBox' value='"+sData+"'/>");
				  			}},
			               {"width":"140px","data":"itemOrderCode","defaultContent":"","name":"order_code"},
			               {"width":"140px","data":"item.itemCode","defaultContent":"","name":"item_code"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"90px", "data":"item.itemClass.itemClassificationName","defaultContent":"","name":"item_classification_name"},
							{"width":"90px","data":"item.itemName","defaultContent":"","name":"item_name"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							
							
							{"width":"90px", "data":"itemNum","defaultContent":"","name":"item_num"},
							{"width":"90px","data":"totalPrice","defaultContent":"","name":"total_price"},
							
							
							{"width":"90px","data":"customer.userName","defaultContent":"","name":"user_name"},
						
							{"width":"90px","data":"createDate","defaultContent":"","name":"create_date"},
							{"width":"90px","data":"orderState","class":"states","defaultContent":"","name":"order_state"},
							{"width":"200px", "data":"itemOrderID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-item-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-outLibrary-id='"+sData+"' title='删除' class='itemOrder_delete btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
					  		}}
							],
			"checkbox" : 1,
			"iDisplayLength" : 5, // 每页显示记录数，可选
			"sAjaxSource" : url, // 获取数据的url
			"myData" : paramters, // 自定义参数，会被拼接到url参数中,要求数据格式必须为:[{"name":"名称","value":"值"}]
			"order" : [ 1, "asc" ], // 默认排序列
			"after" : tableOrderInit, // 表格初始化完毕后的回调函数
		};

		dataTable = $("#sample-table").table(options);
		return dataTable;
	}
	function tableOrderInit() {
		$(".td").css("display","none");
		//修改状态
		$(".state").on('click', function() {
					var itemOrderID  = $(this).parent().parent().find(
							"input.itemOrderCheckBox").val();
					
					layer.config({
						skin : 'layer-ext-evm'
					});
					var orderState = null;
					var state = $(this).parent().parent().find(".states")
							.text();
					
					if (state == "取消订单") {
						toastr.error("该订单已取消");
						return;
					}	
					orderState =9;
					layer.confirm("确认要取消订单", {
						title : "取消订单",
						btn : [ '是', '否' ]
					}, function(index) {
						
						$.ajax({
							"type" : "POST",
							"url" : "itemOrder/updateItemOrderState",
							"dataType" : "json",
							"data" : {
								"itemOrderID" : itemOrderID,
								"itemOrderState" : orderState,
								"forward" : "JSON"
							},
							"success" : function(data) {
								if (data) {
									toastr.success("订单取消成功");
									toastr.subscribe(function() {
										layer.close(index);
										// 模拟点击事件
										var queryBtn = $("#orders");
										$(queryBtn).trigger("click");
									});
								} else {
									toastr.error("订单取消失败");
								}
							},
							"error" : function(data) {
								toastr.warning("error");
							}
						});
					})
					
					
				});
				
		/**
		 * 删除
		 */
		$(".itemOrder_delete").on('click', function() {
			var ids = new Array();
			
			var id  = $(this).parent().parent().find(
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
								var queryBtn = document.getElementById("orders");
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
	/**
	 * 全选订单
	 */
	$("#lookCarOrder_checkbox").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .lookCarOrderCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .lookCarOrderCheckBox").prop("checked", false);
		}
	});
	
	/**
	 * 用户显示表格（订单显示）
	 */
	function lookCarOrderListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"40px","data":"lookCarID","class":"td","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='lookCarOrderCheckBox' value='"+sData+"'/>");
				  			}},
			               {"width":"140px","data":"item.itemCode","defaultContent":"","name":"item_code"},
							
							{"width":"90px", "data":"item.itemClass.itemClassificationName","defaultContent":"","name":"item_classification_name"},
							{"width":"90px","data":"item.itemName","defaultContent":"","name":"item_name"},
							
							{"width":"90px","data":"item.itemPrice","defaultContent":"","name":"item_price"},
							{"width":"90px","data":"item.itemModel","defaultContent":"","name":"item_model"},
							{"width":"90px","data":"item.itemColor","defaultContent":"","name":"item_color"},
							{"width":"90px","data":"customer.userName","defaultContent":"","name":"user_name"},
							{"width":"90px","data":"phoneNum","defaultContent":"","name":"phone_num"},
							{"width":"90px","data":"lookCarDate","defaultContent":"","name":"look_car_date"},
							{"width":"90px","data":"stateName","class":"states","defaultContent":"","name":"stateName"},
							{"width":"200px", "data":"lookCarID","class":"p","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-item-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" );
					  		}}
							],
			"checkbox" : 1,
			"iDisplayLength" : 5, // 每页显示记录数，可选
			"sAjaxSource" : url, // 获取数据的url
			"myData" : paramters, // 自定义参数，会被拼接到url参数中,要求数据格式必须为:[{"name":"名称","value":"值"}]
			"order" : [ 1, "asc" ],// 默认排序列
			"after" : tableLookInit, // 表格初始化完毕后的回调函数
		};

		dataTable = $("#sample-tables").table(options);
		return dataTable;
	}
	function tableLookInit() {
		//修改状态
		//修改状态
		$(".td").css("display","none");
		$("#sample-tables tr").find("td:eq(10)").each(function(){
			var state=$(this).text();
			
			if (state == "取消订单") {
				
				$(this).parent().find("td:eq(11)").append("<a href='javascript:void(0);'  title='删除' class='lookCarOrder_delete btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");

			}	
		});
		
		$(".state").on('click', function() {
					var lookCarID  = $(this).parent().parent().find(
							"input.lookCarOrderCheckBox").val();
					
					layer.config({
						skin : 'layer-ext-evm'
					});
					var lookCarState = null;
					var state = $(this).parent().parent().find(".states")
							.text();
					
					if (state == "取消订单") {
						
						toastr.error("该订单已取消");
						
						return;
					}	
					lookCarState =9;
					layer.confirm("确认要取消订单", {
						title : "取消订单",
						btn : [ '是', '否' ]
					}, function(index) {
						
						$.ajax({
							"type" : "POST",
							"url" : "lookCarOrder/updateLookCarOrderState",
							"dataType" : "json",
							"data" : {
								"lookCarID" : lookCarID,
								"state" : lookCarState,
								"forward" : "JSON"
							},
							"success" : function(data) {
								if (data) {
									toastr.success("订单取消成功");
									toastr.subscribe(function() {
										layer.close(index);
										// 模拟点击事件
										var queryBtn = $("#lookOrder");
										$(queryBtn).trigger("click");
									});
								} else {
									toastr.error("订单取消失败");
								}
							},
							"error" : function(data) {
								toastr.warning("error");
							}
						});
					})
					
					
				});
				
		/**
		 * 删除
		 */
		$(".lookCarOrder_delete").on('click', function() {
			var ids = new Array();
			
			var id  = $(this).parent().parent().find(
			"input.lookCarOrderCheckBox").val();
			
			ids.push(parseInt(id));
			layer.confirm("确认删除选中的预约订单 ？ ", {
				title : "删除",
				btn : [ '是', '否' ]
			}, function(index) {
				
				$.ajax({
					"type" : "POST",
					"url" : "lookCarOrder/deleteLookCarOrder",
					"dataType" : "json",
					"data" : {
						"lookCarID" : ids,
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("删除成功");
							toastr.subscribe(function() {
								layer.close(index);
								// 模拟点击事件
								var queryBtn = document.getElementById("lookOrder");
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
	//管理员信息
	$('#user').on('click', function() {
		var userName=$("#text").text();
		
		layer.config({
			skin : 'layer-ext-evm'
		});

		layer.open({
			type : 2,
			title : '个人信息',
			shadeClose : false,
			shade : 0.5,
			area : [ '50%', '50%' ],
			content : 'user/getUserInfo?userName='+userName
		});
	});
	//管理员信息
	$('#userInfo').on('click', function() {
		var userName=$("#text").text();
		
		layer.config({
			skin : 'layer-ext-evm'
		});

		layer.open({
			type : 2,
			title : '个人信息',
			shadeClose : false,
			shade : 0.5,
			area : [ '50%', '50%' ],
			content : 'user/getUserInfoEdit?userName='+userName
		});
	});
})

