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
	$.post(path+"itemOrderState/outLibraryState",function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var outLibraryState = data[i];
			var option = new Option(outLibraryState.value,outLibraryState.nameID);
			
			$("#outLibraryReason").append(option);
		}
		
	});
	$("#outLibrary").on('click',function(){
		var value=$("#outLibraryCode").val();
		if(!value){
			$("#outLibraryCode").attr("value","");	
		}
		$.ajax({
			"type" : "POST",
			"url" : path+"createNum/number",
			"dataType" : "json",
			"data" : {},
			"success" : function(data) {
				if (data) {
					$("#outLibraryCode").attr("value",data);	
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
	$("#outLibaryNum").blur(function(){
		var itemOutLibraryNum=$("#outLibraryNum").val();
		var itemStockNum=$("#itemStockNum").val();
		if(parseInt(itemOutLibraryNum)==0||itemOutLibraryNum==null||parseInt(itemOutLibraryNum)<parseInt(0)){
			toastr.error("请输入大于1的数");
		}
		if(parseInt(itemOutLibraryNum)>parseInt(itemStockNum)){
			toastr.error("库存不足");
		}
		
	})

	$("#submit").on('click', function(){
		var itemID=$("#itemID").val();
		var outLibraryCode=$("#outLibraryCode").val();
		if(outLibraryCode==null){
			toastr.error("出库单号不能为空");
		}
		var itemStockNum=$("#itemStockNum").val();
		var outLibraryNum=$("#outLibraryNum").val();
		if(outLibraryNum==null){
			toastr.error("出库量不能为空");
		}
		var outLibraryReason=$("#outLibraryReason").val();
		var createPerson=$("#createPerson").val();
		var wareHouseID=$("#wareHouseID").val();
	
		var itemOutLibrary={
				itemID:itemID,
				outLibraryCode:outLibraryCode,
				itemStockNum:itemStockNum,
				outLibraryNum:outLibraryNum,
				outLibraryReason:outLibraryReason,
				createPerson:createPerson,
				wareHouseID:wareHouseID
		}
		
		layer.alert('确定出库量为 出库量='+outLibraryNum, {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				
				
				$.ajax({
					"type" : "POST",
					"url" : path+"itemOutLibraryOrder/addItemOutLibraryOrder",
					"dataType" : "json",
					"data" : {
						itemOutLibrary:JSON.stringify(itemOutLibrary),"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("出库成功");
							toastr.subscribe(function() {
								// 模拟点击事件
								var queryBtn = parent.document.getElementById("outLibrary_select");
								$(queryBtn).trigger("click");
								layer.close(layer.index);
								var index=parent.layer.getFrameIndex(window.name);

								parent.layer.close(index);
							});
						} else {
							toastr.error("出库失败");
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