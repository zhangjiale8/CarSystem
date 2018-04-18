$(function(){
	var itemClassificationID=parent.$("#item_enterLibrary").attr("data-class-id");
	//初始化仓库
	$.post("wareHouse/selectAllwareHouse",function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var wareHouse = data[i];
			var option = new Option(wareHouse.wareHouseName,wareHouse.wareHouseID);
			
			$("#wareHouse").append(option);
		}
		
	});
	//初始化销售类型
	$.post("itemOrderState/gettAllItemHot",function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var hot = data[i];
			var option = new Option(hot.value,hot.nameID);
			
			$("#hot").append(option);
		}
		
	});
	
	//初始化品牌（全部）
	$.post("brand/getAllBrandName",function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var brand = data[i];
			var brandName=brand.itemBrandName;
			var brandID=brand.itemBrandID;
			var option = new Option(brandName,brandID);
			$("#brand").append(option);
		}
	})
	$("#series").on('click',function(){
		var brandID=$("#brand").val();
		$("#series").empty();
		if(brandID==-1){
			toastr.error("请先选择品牌");
		}
		//初始化品牌系列（品牌系列）
		$.post("itemSeries/getItemSeriesByItemBrandID",{"itemBrandID":brandID},function(data){
			
			for(var i = 0 ;i < data.length ; i++){
				var series= data[i];
				
				var option = new Option(series.itemSeriesName,series.itemSeriesID);
				$("#series").append(option);
			}
			
		});
	})
	$("#itemprice").blur(function(){
		var price=$(this).val();
		 var reg = /^[0-9]+.?[0-9]*$/;
		if(!reg.test(price)){
			
			toastr.error("请输入数字");
		}
	});
	$("#itemCode").blur(function(){
		var itemCode=$(this).val();
		 
		if(itemCode==null){
			
			toastr.error("请输入商品编号");
		}
	});
	$("#itemNum").blur(function(){
		var itemNum=$(this).val();
		 var reg = /^[0-9]*[1-9][0-9]*$/;
		if(!reg.test(itemNum)){
			
			toastr.error("请输入正整数");
		}
			
		
	});
	$("#itemCode").blur(function(){
		var itemCode=$(this).val();
		
		if(itemCode==null||itemCode==''||itemCode.length==0){
			
			toastr.error("商品编码不能为空");
		}
			
		
	});
	$.post("itemAttribute/itemAttributeByItemTypeID",{"itemTypeID":itemClassificationID},function(data){
		if(data['attrTypes']){
			$("#attrs").empty();
			$.each(data['attrTypes'], function(index, item){
				var attrInfo = "<div data-type='" + item.attribute_type_name + "' data-attr-type-id='" + item.attribute_type_id + "'>"
					+ "<div class='caption'>" + item.attribute_type_show_name + "</div>"
					+ "<dl class='attributes'></dl>"
					+ "</div>";
				
				$("#attrs").append(attrInfo);
			});
		}
		//属性信息
		if(data['attrs']){
			$.each(data['attrs'], function(index, item){
				var type = item.attribute_type_name;
				var $attr = $("#attrs").find("div[data-type='" + type + "']").find(".attributes");
				if($attr.length > 0){
					var dt = window.attrElement(item);
					dt && ($attr.append(dt));
				}
			});
		}
		$("#assetMaintanence_save").click(function(){
			var wareHouseID=$("#wareHouse").val();
			
			var itemName=$("#itemName").val();
			if(itemName==null||itemName==''||itemName.length==0){
				toastr.error("商品名称不能为空");
				return;
			}
			var itemPrice=$("#itemprice").val();
			if(itemPrice==null||itemPrice==''){
				toastr.error("商品价格不能为空");
				return;
			}
			var itemNum=$("#itemNum").val();
			if(itemNum==null||itemNum==''){
				toastr.error("商品数量不能为空");
				return;
			}
			var itemColor=$("#itemColor").val();
			if(itemColor==null||itemColor==''){
				toastr.error("商品颜色不能为空");
				return;
			}
			var itemCode=$("#itemCode").val().trim();
			if(itemCode==null||itemCode==''||itemCode.length==0){
				toastr.error("商品编码不能为空");
				return;
			}
			var itemModel=$("#itemModel").val();
			if(itemModel==null||itemModel==''||itemCode.length==0){
				toastr.error("商品型号不能为空");
				return;
			}
			var createPerson=$("#createPerson").val();
			var hot=$("#hot").val();
			var itemBrandName=$("#brand option:selected").text();
			if(itemBrandName=='全部'||itemBrandName==''||itemBrandName==null){
				toastr.error("商品品牌不能为空");
				return;
			}
			var itemSeriesName=$("#series option:selected").text();
			if(itemSeriesName=='全部'||itemSeriesName==''||itemSeriesName==null){
				toastr.error("商品系列不能为空");
				return;
			}
			var item = {
					wareHouseID:wareHouseID,
					itemName:itemName,
					itemPrice:itemPrice,
					itemStockNum:itemNum,
					itemColor:itemColor,
					itemCode:itemCode,
					itemModel:itemModel,
					itemHot:hot,
					itemClassificationID:itemClassificationID,
					createPerson:createPerson,
					itemBrandName:itemBrandName,
					itemSeriesName:itemSeriesName
			};
			
			
			var itemAttribute = [];
			
			//属性信息
			$.each($("#attrs").find(".attributes").find(".attribute"), function(index, item){
				
				var attr = {
					
					attributeID: $(item).find(".attr").attr("data-attr-id"),
					attributeValue: $(item).find(".attr").val(),
					attributeTypeID: $(item).parent(".attributes").parent().attr("data-attr-type-id")
					
				};
				itemAttribute.push(attr);
			});
			
			itemAttribute && itemAttribute.length > 0 && (item['itemAttribute']=itemAttribute);
			
			$.post("item/addItem", {"item": JSON.stringify(item), "forward": "JSON"}, function(newItem){
				
				
				
				if(newItem){
					var data = eval("(" + newItem + ")");
					toastr.success("商品新增成功,请绑定图片");
					
					parent.$("#table").find("#itemName").html(data.itemName);
					parent.$("#table").find("#itemID").html(data.itemID);
					parent.$("#table").find("#itemCode").html(data.itemCode);
					parent.$("#table").find("#itemColor").html(data.itemColor);
					parent.$("#table").find("#itemPrice").html(data.itemPrice);
					parent.$("#table").find("#itemModel").html(data.itemModel);
					parent.$("#table").find("#itemShelfTime").html(data.itemShelfTime);
					parent.$("#table").find("#class").html(data.itemClassificationName);
					var index = parent.layer.getFrameIndex(window.name);  
				   
				    setTimeout(function(){parent.layer.close(index)}, 1000);    
					return;
				}else{
					toastr.error("商品新增失败");
					var index = parent.layer.getFrameIndex(window.name);  
					   
				    setTimeout(function(){parent.layer.close(index)}, 1000);    
					return;
				}
			});
		});
	});
	
});