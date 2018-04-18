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
	$.post(path+"itemOrderState/getRepairOrderState",function(data){
		var repairState=$("#repairState").val();
		
		for(var i = 0 ;i < data.length ; i++){
			var repairOrderState = data[i];
			var option = new Option(repairOrderState.value,repairOrderState.nameID);
			
			$("#repairOrderState").append(option);
		}
		$("#repairOrderState").find("option[value='"+repairState+"']").attr("selected",true); 
	});
	
	$("#repairOrderState").blur(function(){
		var repairOrderID=$("#repairOrderID").val();
		
		var repairState=$("#repairState").val();
		
		var repairOrderState=$("#repairOrderState").val();
		
		if(repairOrderState==repairState){
			toastr.error("修改状态与当前状态一样");
			return;
		}
		
		layer.confirm("确认要修改状态", {
			title : "修改",
			btn : [ '是', '否' ]
		}, function(index) {
			$.ajax({
				"type" : "POST",
				"url" : path+"repairOrder/updateRepairOrderState",
				"dataType" : "json",
				"data" : {
					repairOrderID : repairOrderID,
					repairOrderState : repairOrderState,
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("状态修改成功");
						toastr.subscribe(function() {
							layer.close(index);
							
							// 模拟点击事件
							
							var queryBtn = parent.document.getElementById("repairOrder_select");
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