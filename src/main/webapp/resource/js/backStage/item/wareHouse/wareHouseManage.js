/**
 * 
 */
$(function() {
	
	//初始化仓库
	$.post("wareHouse/selectAllwareHouse",function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var wareHouse = data[i];
			var option = new Option(wareHouse.wareHouseName,wareHouse.wareHouseID);
			
			$("#wareHouseName").append(option);
		}
		
	});
	var wareHouseID=$("#wareHouseName").val();
	/**
	 * 进页面品牌查询列表
	 */
	wareHouseListQuery("wareHouse/getItemByItemCodeAndItenNameAndWareHouse", {
		"itemCode" : "",
		"itemName" : "",
		"wareHouseID" : wareHouseID
		
	});
	/**
	 * 全选
	 */
	$("#wareHouse_checkAll").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .wareHouseCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .wareHouseCheckBox").prop("checked", false);
		}
	});
	//新增仓库
	$('#add_wareHouse').on('click', function() {
		layer.config({
			skin : 'layer-ext-evm'
		});

		layer.open({
			type : 2,
			title : '新增仓库',
			shadeClose : false,
			shade : 0.5,
			area : [ '60%', '60%' ],
			content : 'toAddWareHouse'
		});
	});
	$("#lookVehicle").on('click', function() {
		var name = $("#itemName").val().trim();
		var code=$("#itemCode").val().trim();
		var itemClassificationID=$(this).attr("data-class-id");
		var wareHouseID=$("#wareHouseName").val();
		var params = {
			"itemCode":code,
			"itemName" : name,
			"wareHouseID":wareHouseID,
			"itemClassificationID":itemClassificationID
		};
		wareHouseListQuery("wareHouse/getItemByItemCodeAndItenNameAndWareHouse", params);
	})
	$("#lookFitting").on('click', function() {
		var name = $("#itemName").val().trim();
		var code=$("#itemCode").val().trim();
		var itemClassificationID=$(this).val();
		var itemClassificationID=$(this).attr("data-class-id");
		var params = {
			"itemCode":code,
			"itemName" : name,
			"wareHouseID":wareHouseID,
			"itemClassificationID":itemClassificationID
		};
		wareHouseListQuery("wareHouse/getItemByItemCodeAndItenNameAndWareHouse", params);
	})
	/**
	 * 查询
	 */
	$("#wareHouse_select").click(function() {

		var name = $("#itemName").val().trim();
		var code=$("#itemCode").val().trim();
		
		var wareHouseID=$("#wareHouseName").val();
		var params = {
			"itemCode":code,
			"itemName" : name,
			"wareHouseID":wareHouseID
		};
		wareHouseListQuery("wareHouse/getItemByItemCodeAndItenNameAndWareHouse", params);

	});
	function delWareHouse(ids) {
		if ($(".wareHouseCheckBox:checked").length == 0) {
			toastr.warning("请选择要清仓的商品");
			return false;
		}

		layer.confirm("确认清仓此商品？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".wareHouseCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
			
			$.ajax({
				"type" : "POST",
				"url" : "wareHouse/deleteWareHouseItem",
				"dataType" : "json",
				"data" : {
					"itemID" : ids,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("清仓成功");
						toastr.subscribe(function() {
							layer.close(index);
							// 模拟点击事件
							var queryBtn = $("#wareHouse_select");
							$(queryBtn).trigger("click");
						});
					} else {
						toastr.error("清仓失败");
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
	function wareHouseListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"80px","data":"itemID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='wareHouseCheckBox' value='"+sData+"'/>");
				  			}},
				  			{"width":"100px","data":"itemCode","defaultContent":"","name":"item_code"},
				  			{"width":"100px","data":"itemName","defaultContent":"","name":"item_name"},
				  			{"width":"100px","data":"itemColor","defaultContent":"","name":"item_color"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"100px", "data":"itemStockNum","defaultContent":"","name":"item_stock_num"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							
							{"width":"100px", "data":"itemPrice","defaultContent":"","name":"item_price"},
							{"width":"100px","data":"wareHouseName","defaultContent":"","name":"wareHouse_name"},
							{"width":"100px","data":"wareHouseKeeper","defaultContent":"","name":"wareHouse_keeper"},
							{"width":"100px", "class":"state", "data":"itemState","defaultContent":"","name":"item_state","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "上架" : "下架");
							}},
							{"width":"200px", "data":"itemID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html("<a href='javascript:void(0); ' title='状态' data-item-id='"+sData+"' class='state btn btn-xs btn-success'>" +
										"<i class='icon-stop bigger-120'></i></a>&emsp;" +
										"<a href='javascript:void(0);' data-item-id='"+sData+"' title='迁移' class='edit_basic btn btn-xs btn-info'><i class='icon-edit bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-item-id='"+sData+"' title='清空' class='wareHouse_deleteid btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
					  		}} ],
			"checkbox" : 1,
			"iDisplayLength" : 5, // 每页显示记录数，可选
			"sAjaxSource" : url, // 获取数据的url
			"myData" : paramters, // 自定义参数，会被拼接到url参数中,要求数据格式必须为:[{"name":"名称","value":"值"}]
			"order" : [ 5, "asc" ], // 默认排序列
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
					var itemID = $(this).parent().parent().find(
							"input.wareHouseCheckBox").val();
					// alert(userId);
					
					layer.config({
						skin : 'layer-ext-evm'
					});

					layer.open({
						type : 2,
						title : "转移商品 " + "",
						shadeClose : false,
						shade : 0.5,
						area : [ '60%', '70%' ],
						content : [
								"wareHouse/getItemPositionByItemID?itemID="
										+ itemID, 'no' ]
					});
				}
		);
				
		/**
		 * 删除
		 */
		$(".wareHouse_delete").on('click', function() {
				
			var ids = "";
			$("#sample-table .wareHouseCheckBox").each(function() {
				if ($(this).prop("checked")) {
					var id = $(this).val();
					
					ids = ids + id + ",";
					
				}
			});
		
			
			ids = ids.substr(0, ids.length - 1);
			
			delWareHouse(ids);
		});
		/**
		 * 删除
		 */
		$(".wareHouse_deleteid").on('click', function() {
				
			var ids = new Array();
			
			var id = $(this).parent().parent().find(
			"input.wareHouseCheckBox").val();
			
			ids.push(parseInt(id));
			layer.confirm("确认清仓此商品？ ", {
				title : "删除",
				btn : [ '是', '否' ]
			}, function(index) {
				
				$.ajax({
					"type" : "POST",
					"url" : "wareHouse/deleteWareHouseItem",
					"dataType" : "json",
					"data" : {
						"itemID" : ids,
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("清仓成功");
							toastr.subscribe(function() {
								layer.close(index);
								// 模拟点击事件
								var queryBtn = $("#wareHouse_select");
								$(queryBtn).trigger("click");
							});
						} else {
							toastr.error("清仓失败");
						}
					},
					"error" : function(data) {
						toastr.warning("error");
					}
				});
			});
		});
		$(".state").on('click', function() {
			
			var itemId = $(this).parent().parent().find(
					"input.wareHouseCheckBox").val();
			
			
			layer.config({
				skin : 'layer-ext-evm'
			});
			var stateID=null;
			var state=$(this).parent().parent().find(
			".state").text();
			
			if(state=="上架"){
				stateID=2;
			}else{
				stateID=1;
			}
			layer.confirm("确认要修改状态", {
				title : "修改",
				btn : [ '是', '否' ]},function(index){
					$.ajax({
						"type" : "POST",
						"url" : "wareHouse/updateItemStateByItemIdAndItemStateID",
						"dataType" : "json",
						"data" : {
							"itemID" : itemId,
							"itemStateID":stateID,
							"forward" : "JSON"
						},
						"success" : function(data) {
							if (data) {
								toastr.success("状态修改成功");
								toastr.subscribe(function() {
									layer.close(index);
									// 模拟点击事件
									var queryBtn = $("#wareHouse_select");
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