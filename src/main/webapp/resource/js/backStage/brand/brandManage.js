/**
 * 
 */
$(function() {
	
	/**
	 * 进页面品牌查询列表
	 */
	brandListQuery("brand/getItemBrandByBrandName", {
		"brandName" : ""
	});
	
	//新增品牌
	//管理员信息
	$('#add_brand').on('click', function() {
		layer.config({
			skin : 'layer-ext-evm'
		});

		layer.open({
			type : 2,
			title : '新增品牌',
			shadeClose : false,
			shade : 0.5,
			area : [ '60%', '66%' ],
			content : 'toAddBrand'
		});
	});
	/**
	 * 查询
	 */
	$("#brand_select").click(function() {

		var name = $("#brandName").val().trim();
		
		var params = {
			"brandName" : name
		};
		brandListQuery("brand/getItemBrandByBrandName", params);

	});
	/**
	 * 全选
	 */
	$("#checkAll").on('click', function() {
		
		if ($(this).data("f") == undefined || $(this).data("f") == 0) {
			$(this).data("f", 1);
			$("#sample-table .brandCheckBox").prop("checked", true);
		} else {
			$(this).data("f", 0);
			$("#sample-table .brandCheckBox").prop("checked", false);
		}
	});
	function delBrand(ids) {
		if ($(".brandCheckBox:checked").length == 0) {
			toastr.warning("请选择要删除的品牌");
			return false;
		}

		layer.confirm("确认删除选中的品牌 ？ ", {
			title : "删除",
			btn : [ '是', '否' ]
		}, function(index) {
			var ids = new Array();
			$(".brandCheckBox:checked").each(function(index, item) {
				ids.push(parseInt($(item).val()));
			});
			$.ajax({
				"type" : "POST",
				"url" : "brand/deleteItemBrand",
				"dataType" : "json",
				"data" : {
					"itemBrandIDs" : ids,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("删除成功");
						toastr.subscribe(function() {
							layer.close(index);
							// 模拟点击事件
							var queryBtn = $("#brand_select");
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
	function brandListQuery(url, paramters) {

		var options = {
			"aoColumns" : [// 显示的列
			               {"width":"80px","data":"itemSeriesID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
				  				$(nTd).html("<input type='checkbox' class='brandCheckBox' value='"+sData+"'/>");
				  			}},
							{"width":"200px","data":"itemBrand.itemBrandName","defaultContent":"","name":"item_brand_name"},
							/*{"width":"250px", "data":"monitorItem.monitorItemName","defaultContent":"","name":"monitor_item_name"},*/
							{"width":"200px","data":"itemBrand.itemBrandCity","defaultContent":"","name":"item_brand_city"},
							{"width":"200px", "data":"itemSeriesName","defaultContent":"","name":"item_series_name"},
							{"width":"200px","data":"itemBrand.createTime","defaultContent":"","name":"create_time"},
							{"width":"150px", "data":"itemSeriesID","orderable":false,"fnCreatedCell":function(nTd, sData, oData, iRow, iCol){
								$(nTd).html(
										"<a href='javascript:void(0);' data-brand-id='"+sData+"' title='编辑' class='edit_basic btn btn-xs btn-info'><i class='icon-edit bigger-120'></i></a>&emsp;" +
								"<a href='javascript:void(0);' data-brand-id='"+sData+"' title='删除' class='brand_deleteid btn btn-xs btn-warning'><i class='icon-trash bigger-120'></i></a>");
					  		}} ],
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
	;
	function tableInit() {
		$(".edit_basic").unbind("click").bind(
				"click",
				function() {
					var itemBrandID = $(this).parent().parent().find(
							"input.brandCheckBox").val();
					// alert(userId);
					
					layer.config({
						skin : 'layer-ext-evm'
					});

					layer.open({
						type : 2,
						title : "编辑品牌 " + "",
						shadeClose : false,
						shade : 0.5,
						area : [ '60%', '70%' ],
						content : [
								"brand/getItemBrandNameByBrandID?itemBrandID="
										+ itemBrandID, 'no' ]
					});
				});
		/**
		 * 删除
		 */
		$(".brand_deleteid").on('click', function() {
				
			var ids = new Array();
			
			var itemSeriesID = $(this).parent().parent().find(
			"input .brandCheckBox").val();
			
			ids.push(parseInt(itemSeriesID));
			layer.confirm("确认删除选中的品牌 ？ ", {
				title : "删除",
				btn : [ '是', '否' ]
			}, function(index) {
			
				$.ajax({
					"type" : "POST",
					"url" : "brand/deleteItemBrand",
					"dataType" : "json",
					"data" : {
						"itemBrandIDs" : ids,
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("删除成功");
							toastr.subscribe(function() {
								layer.close(index);
								// 模拟点击事件
								var queryBtn = $("#brand_select");
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
		/**
		 * 删除
		 */
		$(".brand_delete").on('click', function() {
				
			var ids = "";
			$("#sample-table .brandCheckBox").each(function() {
				if ($(this).prop("checked")) {
					var id = $(this).val();
					
					ids = ids + id + ",";
					
				}
			});
		
			
			ids = ids.substr(0, ids.length - 1);
			delBrand(ids) 
		});
	}
})