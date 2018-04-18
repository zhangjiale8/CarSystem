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
	
	$("#repairCost").blur(function(){
		var repairCost=$("#repairCost").val();
		if(parseInt(repairCost)<parseInt(0)){
			toastr.error("请输入大于1的数");
		}
		
	})

	$("#submit").on('click', function(){
		var repairOrderID=$("#repairOrderID").val();
		var repairOrderCode=$("#repairOrderCode").val();
		var itemModelNum=$("#itemModelNum").val();
		var carCode=$("#carCode").val();
		var repairPosition=$("#repairPosition").val();
		var repairOrderType=$("#repairOrderType").val();
		var repairCost=$("#repairCost").val();
		var customerName=$("#customerName").val();
		var phone=$("#phone").val();
		if(repairOrderCode==null){
			toastr.error("订单号不能为空");
		}
		
		var repairOrder={
				repairOrderID:repairOrderID,
				repairOrderCode:repairOrderCode,
				itemModelNum:itemModelNum,
				carCode:carCode,
				repairPosition:repairPosition,
				repairOrderType:repairOrderType,
				repairCost:repairCost,
				customerName:customerName,
				phone:phone
		}
		
		layer.alert('确定修改', {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				
				$.ajax({
					"type" : "POST",
					"url" : path+"repairOrder/updateRepairOrder",
					"dataType" : "json",
					"data" : {
						repairOrder:JSON.stringify(repairOrder),"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("修改成功");
							toastr.subscribe(function() {
								// 模拟点击事件
								var queryBtn = parent.document.getElementById("repairOrder_select");
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