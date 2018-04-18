$(function() {
	//pathName:--->   mbuy/user/login.action  
    var pathName = window.location.pathname.substring(1);  
    //webName:--->mbuy  
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
    //return:--->http://localhost:9999/mbuy/  
    var path=window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
	
	$("#submit").on('click',function(){
		
		var itemBrandName=$("#itemBrandName").val();
		var itemSeriesName=$("#seriesName").val();
		var createTime=$("#time").val();
		var itemBrandCity=$("#address").val();
		var itemBrand={
				itemBrandName:itemBrandName,
				itemSeriesName:itemSeriesName,
				createTime:createTime,
				itemBrandCity:itemBrandCity
		}
		$.ajax({
			"type":"POST",
			"url": path+"brand/addItemBrand",
			"dataType":"json",
			"data":{"itemBrand":JSON.stringify(itemBrand), "forward":"JSON"},
			"success":function(data){
				
				if(data != 0){
					toastr.success("新增品牌成功");
					toastr.subscribe(function(){
						//模拟点击事件
						var queryBtn = parent.document.getElementById("brand_select");
						$(queryBtn).trigger("click");
						//关闭iframe
						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
					});
				}else{
					toastr.error("该品牌与车系都已存在");
				}
			},
			"error":function(data){
				toastr.error("error");
			}
		});
	})
});