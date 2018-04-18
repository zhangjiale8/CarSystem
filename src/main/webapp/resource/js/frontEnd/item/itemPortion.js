/**
 * 
 */
$(function(){
	//pathName:--->   mbuy/user/login.action  
    var pathName = window.location.pathname.substring(1);  
    //webName:--->mbuy  
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
    //return:--->http://localhost:9999/mbuy/  
    var path=window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
  //初始化仓库
	$.post("item/getItemOther",function(data){
		
		for(var i = 0 ;i < 8 ; i++){
			
			var item=data[i];
			
			var li="<li><div class='list-infoBox'><a title='"+item.itemName+"'  class='imgtype' data-item_id='"+item.itemID+"' href='javaScript:void(0)'> <img width='290'+"+
			"height='194' src='"+item.photoResource+"' alt='"+item.itemBrandName+"'></a><p class='infoBox'><a title='"+item.itemName+"' href='javaScript:void(0)'"+
			" class='info-title imgtype'>车系: "+item.itemSeriesName+"</a></p><p class='priType-s'><span> <i class='fc-org priType'>价格: "+item.itemPrice+"</i>" +
			"</span></p></div></li>"
			$("#divs2_0 .carList").prepend(li);
		}
		
	});
	$("#divs2_0 .carList").on('click','.imgtype',function(){
    	var itemID=$(this).attr('data-item_id');
    	
    	
    	window.open("itemInfo?itemID="+itemID+"&classID="+1)
    	
    })
	function getAllItem(url,params){
		$.ajax({
			"type" : "POST",
			"url" : path+"item/getItemAll",
			"dataType" : "json",
			"data" : params,
			"success" : function(data) {
				if (data) {
					for(var i = 0 ;i < data.length ; i++){
						
						var item=data[i];
					
						var li="<li><div class='list-infoBox'><a title='"+item.itemName+"' target='_blank' class='imgtype' data-item_id='"+item.itemID+"' href='itemInfo'> <img width='290'+"+
						"height='194' src='"+item.photoResource+"' alt='"+item.itemBrandName+"'></a><p class='infoBox'><a title='"+item.itemName+"' href='itemInfo'"+
						"target='_blank' class='info-title imgtype'>车系: "+item.itemSeriesName+"</a></p><p class='priType-s'><span> <i class='fc-org priType'>价格: "+item.itemPrice+"</i>" +
						"</span></p></div></li>"
						$("#divs2_0 .carList").prepend(li);
					}
					
				} else {
					toastr.error("商品列表获取失败");
				}
			},
			"error" : function(data) {
				toastr.warning("error");
			}
		});
	}
})