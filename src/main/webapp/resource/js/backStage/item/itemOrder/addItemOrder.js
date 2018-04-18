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
    var itemClassificationID=parent.$("#itemOrder").attr("data-class-id");
   
	//初始化原因
    $.post(path+"itemOrderState/getItemOrderPayMethod",function(data){
		
		
		for(var i = 0 ;i < data.length ; i++){
			var payMethod = data[i];
			var option = new Option(payMethod.value,payMethod.nameID);
			
			$("#payMethod").append(option);
		}
		
	});
	//初始化商品条形码
	$.post(path+"itemOutLibraryOrder/getAllItemCode",{itemClassificationID:itemClassificationID},function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var itemCode = data[i];
			var option = new Option(itemCode.itemCode,itemCode.itemID);
			
			$("#itemCode").append(option);
		}
		
	});
	$("#itemOrderNum").on('click',function(){
		var value=$("#itemOrderCode").val();
		if(!value){
			$("#itemOrderCode").attr("value","");	
		}
		$.ajax({
			"type" : "POST",
			"url" : path+"createNum/itemOrderCode",
			"dataType" : "json",
			"data" : {},
			"success" : function(data) {
				if (data) {
					$("#itemOrderCode").attr("value",data);	
					toastr.success("自动生成成功");
					
				} else {
					toastr.error("自动生成失败");
				}
			},
			"error" : function(data) {
				toastr.warning("error");
				
			}
			
		});

	})
	$("#itemCode").blur(function(){
		var itemID=$("#itemCode").val();
		layer.alert('确定选择此商品', {
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
	$("#itemNum").blur(function(){
		var itemNum=$("#itemNum").val();
		var itemID=$("#itemCode").find("option:selected").val();
		if(itemID==-1){
			toastr.error("请选择商品");
			return;
		}
		if(parseInt(itemNum)==0||itemNum==null){
			toastr.error("请输入大于1的数");
			return;
		}
		
		$.ajax({
			"type" : "POST",
			"url" : path+"itemStock/getItemStockByItemID",
			"dataType" : "json",
			"data" : {
				itemID:itemID,
				"forward" : "JSON"
			},
			"success" : function(data) {
				var num=data.itemStockNum;
				
				if (num>0) {
					
					toastr.success("库存充足");
					
				} else {
					toastr.error("库存不足");
				}
			},
			"error" : function(data) {
				toastr.warning("error");
				
			}
			
		});
		
	})
	$("#phone").blur(function(){
		var phone=$("#phone").val();
		if(phone.length==0){
			toastr.error("手机号不能为空");
			return;
		}
		var pattern = /^1[34578]\d{9}$/; 
		var result=pattern.test(phone);
		if(result==false){
			toastr.error("手机号不正确，请重新输入");
			return;
		}
	})

	$("#submit").on('click', function(){
		var itemID=$("#itemCode").val();
		var itemOrderCode=$("#itemOrderCode").val();
		if(itemOrderCode==null){
			toastr.error("订单号不能为空");
		}
		var itemNum=$("#itemNum").val();
		
		if(itemNum==null){
			toastr.error("数量不能为空");
		}
		var payMethod=$("#payMethod").val();
		var address=$("#address").val();
		var phone=$("#phone").val();
		
		var customerName=$("#customerName").val();
		
		var itemOrder={
				itemID:itemID,
				itemOrderCode:itemOrderCode,
				itemNum:itemNum,
				payMethod:payMethod,
				address:address,
				customerName:customerName,
				phone:phone
		}
		
		layer.alert('确定生成订单', {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				
				
				$.ajax({
					"type" : "POST",
					"url" : path+"itemOrder/addItemOrder",
					"dataType" : "json",
					"data" : {
						itemOrder:JSON.stringify(itemOrder),"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("生成订单成功");
							toastr.subscribe(function() {
								// 模拟点击事件
								var queryBtn = parent.document.getElementById("itemOrder_select");
								$(queryBtn).trigger("click");
								layer.close(layer.index);
								var index=parent.layer.getFrameIndex(window.name);

								parent.layer.close(index);
							});
						} else {
							toastr.error("生成订单失败");
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
		layer.alert('确定取消出库？', {
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