/**
 * 
 */
$(function() {

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
	repairOrderListQuery("repairOrder/getRepairOrderPage", {
		
		"repairOrderCode" : "",
		"startTime" : "",
		"endTime" : "",
		"carCode":""
	});
	$('#add_repairOrder').on('click', function() {
		layer.config({
			skin : 'layer-ext-evm'
		});
		
		layer.open({
			type : 2,
			title : "新增订单 " + "",
			shadeClose : false,
			shade : 0.5,
			area : [ '75%', '90%' ],
			content : 'toAddRepairOrder'
		});
		
		
	});
	/**
	 * 全选
	 */
	$("#repairOrder_checkbox").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .repairOrderCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .repairOrderCheckBox").prop("checked", false);
		}
	});
	
	/**
	 * 查询
	 */
	$("#repairOrder_select").click(function() {
		var repairOrderCode = $("#repairOrderCode").val().trim();
		var startTime=$("#start").val().trim();
		var endTime=$("#end").val().trim();
		var carCode=$("#carCode").val().trim();
		var params = {
				"repairOrderCode" : repairOrderCode,
				"startTime" : startTime,
				"endTime" : endTime,
				"carCode":carCode
		};
		repairOrderListQuery("repairOrder/getRepairOrderPage", params);

	});
	/**
	 * 删除
	 */
	function deleterepairOrder(ids) {

		layer.confirm("确认删除选中的订单 ？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".repairOrderCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
			$.ajax({
				"type" : "POST",
				"url" : "repairOrder/deleteRepairOrder",
				"dataType" : "json",
				"data" : {
					"repairOrderID" : ids,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("删除成功");
						toastr.subscribe(function() {
							layer.close(index);
							// 模拟点击事件
							var queryBtn = $("#repairOrder_select");
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
	function repairOrderListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"40px","data":"repairOrderID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='repairOrderCheckBox' value='"+sData+"'/>");
				  			}},
			               {"width":"140px","data":"repairOrderCode","defaultContent":"","name":"repair_code"},
			               {"width":"90px", "data":"itemModelNum","defaultContent":"","name":"item_model_num"},
			               {"width":"140px","data":"carCode","defaultContent":"","name":"car_code"},
							{"width":"90px","data":"repairPosition","defaultContent":"","name":"repair_position"},
							
							{"width":"90px", "data":"repairOrderType","defaultContent":"","name":"repair_type"},
							{"width":"90px","data":"repairCost","defaultContent":"","name":"repair_cost"},
							{"width":"90px","data":"customerName","defaultContent":"","name":"customer_name"},
							{"width":"90px","data":"phone","defaultContent":"","name":"phone"},
							{"width":"90px","data":"repairOrderDate","defaultContent":"","name":"repair_date"},
							{"width":"90px","data":"repairStateName","class":"state","defaultContent":"","name":"repair_state_name"},
							{"width":"200px", "data":"repairOrderID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-item-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" +
										"<a href='javascript:void(0);' data-outLibrary-id='"+sData+"' title='修改' class='edit_basic btn btn-xs btn-info'><i class='icon-edit bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-outLibrary-id='"+sData+"' title='删除' class='repairOrder_deleteid btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
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
					var repairOrderID = $(this).parent().parent().find(
							"input.repairOrderCheckBox").val();
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
								"repairOrder/getRepairOrderByRepairOrderID?repairOrderID="
										+ repairOrderID, 'no' ]
					});
				}
		);
				
		/**
		 * 删除
		 */
		$(".repairOrder_delete").on('click', function() {
			var ids = "";
			$("#sample-table .repairOrderCheckBox").each(function() {
				if ($(this).prop("checked")) {
					var id = $(this).val();
					
					ids = ids + id + ",";
					
				}
			});
			if (ids == "") {
				toastr.error("请至少选择一个维修订单!");
				return false;
			}
			
			ids = ids.substr(0, ids.length - 1);
			deleterepairOrder(ids);
		});
		/**
		 * 删除
		 */
		$(".repairOrder_deleteid").on('click', function() {
			var ids = new Array();
			
			var id = $(this).parent().parent().find(
			"input.repairOrderCheckBox").val();
			
			ids.push(parseInt(id));
			layer.confirm("确认删除选中的订单 ？ ", {
				title : "删除",
				btn : [ '是', '否' ]
			}, function(index) {
				
				$.ajax({
					"type" : "POST",
					"url" : "repairOrder/deleteRepairOrder",
					"dataType" : "json",
					"data" : {
						"repairOrderID" : ids,
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("删除成功");
							toastr.subscribe(function() {
								layer.close(index);
								// 模拟点击事件
								var queryBtn = $("#repairOrder_select");
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
					var repairOrderID  = $(this).parent().parent().find(
							"input.repairOrderCheckBox").val();
					
					layer.config({
						skin : 'layer-ext-evm'
					});
					var orderState = null;
					var state = $(this).parent().parent().find(".state")
							.text();
					if (state == "客户提车") {
						toastr.error("该车已取走，不能修改");
						return;
					} else {
						layer.open({
							type : 2,
							title : "选择状态" + "",
							shadeClose : false,
							shade : 0.5,
							area : [ '30%', '40%' ],
							content : [
									"repairOrder/getRepairOrderStateByRepairOrderID?repairOrderID="+repairOrderID, 'no' ]
						});
					}
					
				});
	}
	
})