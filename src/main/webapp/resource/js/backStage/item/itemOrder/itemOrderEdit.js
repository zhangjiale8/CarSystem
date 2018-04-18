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
	//初始化原因
	$.post(path+"itemOrderState/getItemOrderPayMethod",function(data){
		var oldPayMethod=$("#oldPayMethod").val();
		
		for(var i = 0 ;i < data.length ; i++){
			var payMethod = data[i];
			var option = new Option(payMethod.value,payMethod.nameID);
			
			$("#payMethod").append(option);
		}
		$("#payMethod").find("option[value='"+payMethod+"']").attr("selected",true); 
	});
	$("#totalPrice").blur(function(){
		var totalPrice=$("#totalPrice").val();
		if(parseInt(totalPrice)<parseInt(0)){
			toastr.error("请输入大于1的数");
		}
		
	})

	$("#submit").on('click', function(){
		
		var totalPrice=$("#totalPrice").val();
		var payMethod=$("#payMethod").val();
		var address=$("#address").val();
		var itemOrderID=$("#itemOrderID").val();
		
		var itemOrder={
				itemOrderID:itemOrderID,
				payMethod:payMethod,
				address:address,
				totalPrice:totalPrice
		}
		
		layer.alert('确定修改', {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				
				$.ajax({
					"type" : "POST",
					"url" : path+"itemOrder/updateItemOrder",
					"dataType" : "json",
					"data" : {
						itemOrder:JSON.stringify(itemOrder),"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("修改成功");
							toastr.subscribe(function() {
								// 模拟点击事件
								var queryBtn = parent.document.getElementById("itemOrder_select");
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