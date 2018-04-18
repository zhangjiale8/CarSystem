/**
 * 预约看车相关js
 */
$(function() {
	var itemClassificationID=$("#classID").attr("data-class-id");
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
	lookCarOrderListQuery("lookCarOrder/getLookCarOrderPage", {
		"phoneNum" : "",
		"startTime" : "",
		"endTime" : "",
		"customerName":"",
		"itemClassificationID":itemClassificationID
	});
	
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
	 * 查询订单
	 */
	$("#lookCarOrder_select").click(function() {
		
		var customerName = $("#customerName").val().trim();
		var phoneNum = $("#phoneNum").val().trim();
		var startTime=$("#start").val().trim();
		var endTime=$("#end").val().trim();
		var params = {
				"customerName" : customerName,
				"startTime" : startTime,
				"endTime" : endTime,
				"phoneNum":phoneNum,
				"itemClassificationID":itemClassificationID
		};
		lookCarOrderListQuery("lookCarOrder/getLookCarOrderPage", params);

	});
	$(".lookCarOrder_handle").click(function() {
		
		var state=$(this).attr("data-state-id");
		
		var customerName = $("#customerName").val().trim();
		var phoneNum = $("#phoneNum").val().trim();
		var startTime=$("#start").val().trim();
		var endTime=$("#end").val().trim();
		var params = {
				"customerName" : customerName,
				"startTime" : startTime,
				"endTime" : endTime,
				"phoneNum":phoneNum,
				"itemClassificationID":itemClassificationID,
				"state":state
		};
		lookCarOrderListQuery("lookCarOrder/getLookCarOrderPage", params);

	});
	/**
	 * 删除订单
	 */
	function delLookCarOrder(ids) {
		if ($(".lookCarOrderCheckBox:checked").length == 0) {
			toastr.warning("请选择要删除的预约订单");
			return false;
		}

		layer.confirm("确认删除选中的预约订单 ？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".lookCarOrderCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
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
							var queryBtn = $("#lookCarOrder_select");
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
	 * 用户显示表格（订单显示）
	 */
	function lookCarOrderListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"40px","data":"lookCarID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
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
							{"width":"90px","data":"stateName","class":"state","defaultContent":"","name":"stateName"},
							{"width":"200px", "data":"lookCarID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-item-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-outLibrary-id='"+sData+"' title='删除' class='lookCarOrder_deleteid btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
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
	//订单回调
	function tableInit() {
		
				
		/**
		 * 删除
		 */
		$(".lookCarOrder_delete").on('click', function() {
			var ids = "";
			$("#sample-table .lookCarOrderCheckBox").each(function() {
				if ($(this).prop("checked")) {
					var id = $(this).val();
					
					ids = ids + id + ",";
					
				}
			});
			
			
			ids = ids.substr(0, ids.length - 1);
			delLookCarOrder(ids);
		});
		/**
		 * 删除
		 */
		$(".lookCarOrder_deleteid").on('click', function() {
			var ids = new Array();
			
			var id = $(this).parent().parent().find(
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
								var queryBtn = $("#lookCarOrder_select");
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
					var lookCarID  = $(this).parent().parent().find(
							"input.lookCarOrderCheckBox").val();
					
					layer.config({
						skin : 'layer-ext-evm'
					});
					var lookCarState = null;
					var state = $(this).parent().parent().find(".state")
							.text();
					if (state == "预约成功") {
						toastr.error("该订单已转成整车销售订单");
						return;
					} else {
						
							lookCarState = 1;
							layer.confirm("确认要修改状态", {
								title : "修改",
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
											toastr.success("状态修改成功");
											toastr.subscribe(function() {
												layer.close(index);
												// 模拟点击事件
												var queryBtn = $("#lookCarOrder_select");
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
					}
					
				});
	}
	
})