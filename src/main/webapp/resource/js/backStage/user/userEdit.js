$(function(){
	
	
	
	
	
	$("#user_edit_form").validate({
		errorPlacement: function(error, element) {
		    error.appendTo(element.parent("div").next("div"));
		},
	    submitHandler: function(form){ 
	    	
	    	//将form内容转换为JSON对象
			var userEntity = $(form).serializeArray();
			$.ajax({
				"type":"POST",
				"url": "updateUser",
				"dataType":"json",
				"data":{"user":arrayToJson(userEntity), "forward":"JSON"},
				"success":function(data){
					if(data != 0){
						toastr.success("修改成功");
						toastr.subscribe(function(){
							//模拟点击事件
							var queryBtn = parent.document.getElementById("userinfo_select");
							$(queryBtn).trigger("click");
							//关闭iframe
							var index = parent.layer.getFrameIndex(window.name);
							parent.layer.close(index);
						});
					}else{
						toastr.error("修改失败");
					}
				},
				"error":function(data){
					toastr.error("error");
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