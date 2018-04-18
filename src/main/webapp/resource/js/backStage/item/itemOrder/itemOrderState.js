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
	$.post(path+"itemOrderState/getAllItemOrderState",function(data){
		var orderState=$("#orderState").val();
		
		for(var i = 0 ;i < data.length ; i++){
			var itemOrderState = data[i];
			var option = new Option(itemOrderState.value,itemOrderState.nameID);
			
			$("#itemOrderState").append(option);
		}
		$("#itemOrderState").find("option[value='"+orderState+"']").attr("selected",true); 
	});
	
	$("#itemOrderState").blur(function(){
		var itemOrderID=$("#itemOrderID").val();
		
		var orderState=$("#orderState").val();
		
		var itemOrderState=$("#itemOrderState").val();
		
		if(itemOrderState==orderState){
			toastr.error("修改状态与当前状态一样");
			return;
		}
		if(itemOrderState==9){
			toastr.error("订单已取消，禁止操作");
			return;
		}
		layer.confirm("确认要修改状态", {
			title : "修改",
			btn : [ '是', '否' ]
		}, function(index) {
			$.ajax({
				"type" : "POST",
				"url" : path+"itemOrder/updateItemOrderState",
				"dataType" : "json",
				"data" : {
					"itemOrderID" : itemOrderID,
					"itemOrderState" : itemOrderState,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("状态修改成功");
						toastr.subscribe(function() {
							layer.close(index);
							
							// 模拟点击事件
							
							var queryBtn = parent.document.getElementById("itemOrder_select");
							$(queryBtn).trigger("click");
							var index=parent.layer.getFrameIndex(window.name);
							parent.layer.close(index);
						});
					} else {
						toastr.error("状态修改失败");
					}
				},
				"error" : function(data) {
					toastr.warning("error");
				}
			});
		})
		layer.close();
	})
})