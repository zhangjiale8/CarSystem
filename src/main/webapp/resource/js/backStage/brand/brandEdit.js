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
$("#brand_edit_form").ajaxForm(function() {   
	    	
	    	//将form内容转换为JSON对象
			var brandEntity = $('form').serializeArray();
			
			$.ajax({
				"type":"POST",
				"url": path+"brand/updateItemBrand",
				"dataType":"json",
				"data":{"itemBrand":arrayToJson(brandEntity), "forward":"JSON"},
				"success":function(data){
					
					if(data != 0){
						toastr.success("修改成功");
						toastr.subscribe(function(){
							//模拟点击事件
							var queryBtn = parent.document.getElementById("brand_select");
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