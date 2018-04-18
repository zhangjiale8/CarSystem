
$(function(){
	
	
	
	//初始化品牌系列（品牌系列）
	$.post("itemSeries/getAllItemSeries",function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var seriesName = data[i];
			
			var li="<a class='brandName' href='javaScript:void(0)'>"+seriesName.itemSeriesName+"</a>";
			
			$("#carSeries dd").append(li);
		}
		
	});
	//初始化品牌（全部）
	$.post("brand/getAllBrandName",function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var brandName = data[i];
			
			var li="<a class='brandName' data-brand-name='"+brandName.itemBrandName+"' href='javaScript:void(0)'>"+brandName.itemBrandName+"</a>";
			
			$("#brand span").before(li);
		}
	})
	
		//自动生成品牌全部菜单
		$.post("brand/getAllBrandLetter",function(result){
			
			for(var i = 0; i < result.length; i++){
				var letter=result[i]['letter'];
				var li="<li class='clearfix'><span>"+letter+"</span><div class='"+letter+"'></div></li>";
				
				$('#brand #ul').append(li);
				
				var obj="'."+letter+"'";
				var brandList=result[i][letter];
				
				for(var j = 0; j < brandList.length; j++){
					var brand=brandList[j];
					var a="<a href='javaScript:void(0)' class='brandName' title='"+brand+"'>"+brand+"</a>";
					$('#brand #ul li div').eq(i).append(a);
				}
				
			}
		});
})