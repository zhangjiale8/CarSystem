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
	fittingListQuery("itemStock/getFittingItemStock", {
		
		"itemCode" : "",
		"itemName" : "",
		"wareHouseID" : wareHouseID
	});
	
	/**
	 * 查询
	 */
	$("#itemStock_select").click(function() {
		
		var name = $("#itemName").val().trim();
		var code=$("#itemCode").val().trim();
		
		var wareHouseID=$("#wareHouseName").val();
		var params = {
			"itemCode":code,
			"itemName" : name,
			"wareHouseID":wareHouseID
		};
		fittingListQuery("itemStock/getFittingItemStock", params);

	});
	
	/**
	 * 用户显示表格
	 */
	function fittingListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"120px","data":"item.itemCode","defaultContent":"","name":"item_code"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"120px", "data":"item.itemClass.itemClassificationName","defaultContent":"","name":"item_classification_name"},
							{"width":"120px","data":"item.itemName","defaultContent":"","name":"item_name"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"120px","data":"item.itemColor","defaultContent":"","name":"item_color"},
							{"width":"120px", "data":"itemEnterNum","defaultContent":"","name":"item_enter_library_num"},
							{"width":"120px","data":"itemOutNum","defaultContent":"","name":"item_out_library_num"},
							{"width":"120px","data":"itemStockNum","defaultContent":"","name":"item_stock_num"},
							{"width":"120px","data":"wareHouse.wareHouseName","defaultContent":"","name":"warehouse_name"},
							],
			"checkbox" : 1,
			"iDisplayLength" : 5, // 每页显示记录数，可选
			"sAjaxSource" : url, // 获取数据的url
			"myData" : paramters, // 自定义参数，会被拼接到url参数中,要求数据格式必须为:[{"name":"名称","value":"值"}]
			"order" : [ 1, "asc" ], // 默认排序列
			
		};

		dataTable = $("#sample-table").table(options);
		return dataTable;
	}
	
})