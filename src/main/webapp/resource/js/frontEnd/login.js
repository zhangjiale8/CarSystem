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
    
	$("#pass").on('click',function(){

		layer.config({
			skin : 'layer-ext-evm'
		});

		layer.open({
			type : 2,
			title : '管理员信息',
			shadeClose : false,
			shade : 0.5,
			area : [ '50%', '50%' ],
			content : 'getUserInfoPass'
		});
	})
	$("#userName").blur(function(){
		var userName=$("#userName").val();
		$.post("customer/getCustomerNameByCustomerName", {"customerName": userName}, function(result){
			if(result.status == 0){
				toastr.success("用户名不存在不能修改密码");
				
				return;
			}
		});
	})
	$("#submit").on('click',function(){
		var userName=$("#userName").val();
		var passWord=$("#passWord").val();
		var user={
				userName:userName,
				userPassWord:passWord
		}
		$.ajax({
					"type" : "POST",
					"url" : path+"customer/updatePassWord",
					"dataType" : "json",
					"data" : {
						customer:JSON.stringify(user),"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("密码修改成功");
							toastr.subscribe(function() {
								
								
								var index=parent.layer.getFrameIndex(window.name);

								parent.layer.close(index);
							});
						} else {
							toastr.error("密码修改失败");
						}
					},
					"error" : function(data) {
						toastr.warning("error");
						
					}
					
				});
	})
})