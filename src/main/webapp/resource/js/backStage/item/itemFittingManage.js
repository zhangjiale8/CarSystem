/**
 * 
 */
$(function() {
	
	
	
	$('#add_item').on('click', function() {
		layer.config({
			skin : 'layer-ext-evm'
		});

		layer.open({
			type : 2,
			title : '新增商品',
			shadeClose : false,
			shade : 0.5,
			area : [ '90%', '90%' ],
			content : 'toAddFittingItem'
		});
	});
})