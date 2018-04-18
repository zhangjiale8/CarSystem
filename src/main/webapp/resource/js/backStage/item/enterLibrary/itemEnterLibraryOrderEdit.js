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
    
	
	
	
	$("#enterLibraryNum").blur(function(){
		var enterLibraryNum=$("#enterLibraryNum").val();
		
		if(parseInt(enterLibraryNum)==0||enterLibraryNum==null||parseInt(enterLibraryNum)<parseInt(0)){
			toastr.error("请输入大于1的数");
		}
		
		
	})

	$("#submit").on('click', function(){
		
		var itemID=$("#itemID").val();
		
		var enterLibraryCode=$("#enterLibraryCode").val();
		var enterLibraryID=$("#enterLibraryID").val();
		var enterLibraryNum=$("#enterLibraryNum").val();
		var oldEnterLibraryNum=$("#oldEnterLibraryNum").val();
		if(oldEnterLibraryNum==null){
			toastr.error("入库量不能为空");
		}
		
		var createPerson=$("#createPerson").val();
		
	
		var itemEnterLibrary={
				itemID:itemID,
				enterLibraryID:enterLibraryID,
				enterLibraryNum:enterLibraryNum,
				createPerson:createPerson,
				oldEnterLibraryNum:oldEnterLibraryNum,
				enterLibraryCode:enterLibraryCode
		}
		
		layer.alert('确定修改入库单', {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				
				
				$.ajax({
					"type" : "POST",
					"url" : path+"itemEnterLibraryOrder/updateItemEnterLibraryOrder",
					"dataType" : "json",
					"data" : {
						itemEnterLibrary:JSON.stringify(itemEnterLibrary),"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("修改成功");
							toastr.subscribe(function() {
								// 模拟点击事件
								var queryBtn = parent.document.getElementById("enterLibrary_select");
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