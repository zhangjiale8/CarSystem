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
    var itemClassificationID=parent.$("#outLibrary").attr("data-class-id");
	//初始化原因
	$.post(path+"itemOrderState/outLibraryState",function(data){
		var outLibraryReason=$("#outLibraryReason").val();
		
		for(var i = 0 ;i < data.length ; i++){
			var outLibraryState = data[i];
			var option = new Option(outLibraryState.value,outLibraryState.nameID);
			
			$("#outLibraryReason").append(option);
		}
		$("#outLibraryReason").find("option[value='"+outLibraryReason+"']").attr("selected",true); 
	});
	//初始化商品条形码
	$.post(path+"itemOutLibraryOrder/getAllItemCode",{itemClassificationID:itemClassificationID},function(data){
		var itemID=$("#itemCode").val();
		
		for(var i = 0 ;i < data.length ; i++){
			var itemCode = data[i];
			var option = new Option(itemCode.itemCode,itemCode.itemID);
			
			$("#itemCode").append(option);
		}
		$("#itemCode").find("option[value='"+itemID+"']").attr("selected",true); 
	});
	$("#itemCode").blur(function(){
		var itemID=$("#itemCode").val();
		layer.alert('确定修改为此商品', {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {	
				$.ajax({
					"type" : "POST",
					"url" : path+"itemOutLibraryOrder/getItemByItemID",
					"dataType" : "json",
					"data" : {
						itemID:itemID,"forward" : "JSON"
					},
					"success" : function(item) {
						if (item) {
							toastr.success("选则商品成功");
							$(".item").css({"display":"block"});
							$("#itemID").attr("value",item.itemID);
							$("#wareHouseID").attr("value",item.wareHouseID);
							$("#itemStockNum").attr("value",item.itemStockNum);
							$("#outLibraryNum").attr("value","");
							$("#outLibraryReason").attr("value","");
							$("#createPerson").attr("value","");
							$("#itemName").attr("value",item.itemName);
							$("#itemColor").attr("value",item.itemColor);
							$("#itemPrice").attr("value",item.itemPrice);
							$("#itemModel").attr("value",item.itemModel);
							layer.close(index)
						} else {
							toastr.error("选择商品失败");
						}
					},
					"error" : function(data) {
						toastr.warning("error");
						
					}
					
				});
			}
		});
	})
	$("#outLibaryNum").blur(function(){
		var outLibraryNum=$("#outLibraryNum").val();
		var itemStockNum=$("#itemStockNum").val();
		if(parseInt(outLibraryNum)==0||outLibraryNum==null||parseInt(outLibraryNum)<parseInt(0)){
			toastr.error("请输入大于1的数");
		}
		if(parseInt(itemOutLibraryNum)>parseInt(itemStockNum)){
			toastr.error("库存不足");
		}
		
	})

	$("#submit").on('click', function(){
		var outLibraryCode=$("#outLibraryCode").val();
		var itemID=$("#itemID").val();
		var oldItemID=$("#oldItemID").val();
		var itemCode=$("#itemCode").find("option:selected").text();
		var itemStockNum=$("#itemStockNum").val();
		var outLibraryNum=$("#outLibraryNum").val();
		var oldOutLibraryNum=$("#oldOutLibraryNum").val();
		if(outLibraryNum==null){
			toastr.error("出库量不能为空");
		}
		var outLibraryReason=$("#outLibraryReason").val();
		var createPerson=$("#createPerson").val();
		var wareHouseID=$("#wareHouseID").val();
	
		var itemOutLibrary={
				itemID:itemID,
				oldItemID:oldItemID,
				itemStockNum:itemStockNum,
				outLibraryNum:outLibraryNum,
				outLibraryReason:outLibraryReason,
				createPerson:createPerson,
				wareHouseID:wareHouseID,
				oldOutLibraryNum:oldOutLibraryNum,
				outLibraryCode:outLibraryCode
		}
		
		layer.alert('确定条形码为'+itemCode+'的商品出库 出库量='+outLibraryNum, {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				
				
				$.ajax({
					"type" : "POST",
					"url" : path+"itemOutLibraryOrder/updateItemOutLibraryOrder",
					"dataType" : "json",
					"data" : {
						itemOutLibrary:JSON.stringify(itemOutLibrary),"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("修改成功");
							toastr.subscribe(function() {
								// 模拟点击事件
								var queryBtn = parent.document.getElementById("outLibrary_select");
								$(queryBtn).trigger("click");
								layer.close(layer.index);
								var index=parent.layer.getFrameIndex(window.name);

								parent.layer.close(index);
							});
						} else {
							toastr.error("修改失败");
						}
					},
					"error" : function(data) {
						toastr.warning("error");
						
					}
					
				});
				
			}
		
		});	
		
	})
	$("#reset").on('click',function(){
		layer.alert('确定取消修改？', {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		})
	})
});