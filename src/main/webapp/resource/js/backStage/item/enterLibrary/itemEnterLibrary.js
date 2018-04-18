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
	var itemClassificationID=parent.$("#outLibrary").attr("data-class-id");
	
	/**
	 * 进页面品牌查询列表
	 */
	outLibraryListQuery("itemOutLibrary/getAllItemOutLibrary", {
		"itemCode" : "",
		"itemName" : "",
		"wareHouseID" : wareHouseID,
		"itemClassificationID":itemClassificationID
	});
	
	
	/**
	 * 查询
	 */
	$("#outLibrary_select").click(function() {

		var name = $("#itemName").val().trim();
		var code=$("#itemCode").val().trim();
		
		var wareHouseID=$("#wareHouseName").val();
		var params = {
			"itemCode":code,
			"itemName" : name,
			"wareHouseID":wareHouseID,
			"itemClassificationID":itemClassificationID
		};
		outLibraryListQuery("itemOutLibrary/getAllItemOutLibrary", params);

	});
	
	$("#outLibrary").on('click', function() {
		var name = $("#itemName").val().trim();
		var code=$("#itemCode").val().trim();
		var wareHouseID=$("#wareHouseName").val();
		
		var params = {
			"itemCode":code,
			"itemName" : name,
			"wareHouseID":wareHouseID,
			"itemClassificationID":itemClassificationID
		};
		outLibraryListQuery("itemOutLibrary/getAllItemOutLibrary", params);
	})
	/**
	 * 用户显示表格
	 */
	function outLibraryListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"80px","data":"itemID","sClass":"itemID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox'  class='wareHouseCheckBox' value='"+sData+"'/>");
				  			}},
				  			{"width":"100px","data":"itemCode","defaultContent":"","name":"item_code"},
				  			{"width":"100px","data":"itemName","defaultContent":"","name":"item_name"},
				  			{"width":"100px","data":"itemColor","defaultContent":"","name":"item_color"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"100px", "data":"itemStockNum","sClass":"itemStockNum","defaultContent":"","name":"item_stock_num"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"100px", "data":"itemPrice","defaultContent":"","name":"item_price"},
							{"width":"100px","data":"wareHouseName","defaultContent":"","name":"wareHouse_name"},
							{"width":"100px","data":"wareHouseKeeper","defaultContent":"","name":"wareHouse_keeper"},
							{"width":"100px", "class":"state", "data":"itemState","defaultContent":"","name":"item_state","fnCreatedCell" : function(nTd, sData, oData, iRow,
									iCol) {
								// alert(sData);
								$(nTd).html(sData == 1 ? "上架" : "下架");
							}},
							{"width":"100px", "data":"itemID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html(
								"<a href='javascript:void(0);' data-item-id='"+sData+"' title='出库' class='edit_basic btn btn-xs btn-info'><i class='icon-share-alt bigger-120'></i></a>");
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
					var state=$(this).parent().parent().find(
					".state").text();
					var itemStockNum=$(this).parent().parent().find(
					".itemStockNum").text();
					
					if(state==null){
						toastr.error("该商品已下架，无法出库");
					}
					if(itemStockNum==0){
						toastr.error("该商品库存为零，无法出库");
					}
					else{
						layer.open({
							type : 2,
							title : "商品出库 " + "",
							shadeClose : false,
							shade : 0.5,
							area : [ '70%', '90%' ],
							content : [
									"itemOutLibrary/getItemOutLibraryByItemID?itemID="
											+ itemID, 'no' ]
						});
						
					}
					
				}
		);
				
		
		
	}
	
})