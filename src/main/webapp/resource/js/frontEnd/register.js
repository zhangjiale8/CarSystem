$(function(){
	
	$(".userName").blur(function(){
		var name=$(".userName").val();
		$.post("customer/getCustomerNameByCustomerName", {"customerName": name}, function(result){
			if(result.status == 0){
				toastr.success("用户名不存在可注册");
				
				return;
			}else{
				toastr.error("用户名存在不可注册");
				
				return;
			}
		});
		
	});
	/**
	 * 密码验证提示
	 */
	$(".userPwdAgain").blur(function(){
		
		if($(this).val()!=$(".userPwd").val()){
			toastr.error("密码不一致，请重新输入！");
		}
	});
	
	$("#user_add_form").validate({
		rules: {
			userPasswordAgain: {
		        required: true,
		        equalTo: ".userPwd"
		      }
		},
		 messages: {
			 userPasswordAgain: {
			        required: "请输入密码",
			        equalTo: "密码不一致，请重新输入！"
			      }
		 },
		errorPlacement: function(error, element) {
		    
		},
	    submitHandler: function(form){ 
	    	//将form内容转换为JSON对象
			var customer = $(form).serializeArray();
			
			//请求后台插入数据
			$.ajax({
				"type":"POST",
				"url": "customer/addCustomer",
				"dataType":"json",
				"data":{"customer":arrayToJson(customer), "forward":"JSON"},
				"success":function(data){
					if(data == "1"){
						toastr.success("添加成功");
						userPwdAgainCount=0;
						toastr.subscribe(function(){
							//模拟点击事件
							window.location="login";
							
							var index = parent.layer.getFrameIndex(window.name);
							parent.layer.close(index);
    					});
					}else{
						toastr.error("添加失败");
					}
				},
				"error":function(data){
					toastr.error("系统错误!!");
				}
			});
	    }
	});
	
	//表單數組轉JSON
	function arrayToJson(formArray) {
	    var dataArray = {};
	    $.each(formArray, function () {
	        if (dataArray[this.name]) {
	            if (!dataArray[this.name].push) {
	                dataArray[this.name] = [dataArray[this.name]];
	            }
	            dataArray[this.name].push(this.value || '');
	        } else {
	            dataArray[this.name] = this.value || '';
	        }
	    });
	    return JSON.stringify(dataArray);
	}
	
});