/**
 * 
 */
$(function(){
	//初始化仓库
	$.post("selectAllwareHouse",function(data){
		
		for(var i = 0 ;i < data.length ; i++){
			var wareHouse = data[i];
			var option = new Option(wareHouse.wareHouseName,wareHouse.wareHouseID);
			
			$("#select").append(option);
		}
		
	});
	$("#submit").on('click', function(){
		var itemID=$("#itemID").val();
		
		var wareHouseID=$("#select").val();
		
		layer.alert('确定将此商品搬迁至此仓库？', {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				$.ajax({
					"type" : "POST",
					"url" : "updateItemWareHousePosition",
					"dataType" : "json",
					"data" : {
						"itemID":itemID,
						"wareHouseID" : wareHouseID,
						
						"forward" : "JSON"
					},
					"success" : function(data) {
						if (data) {
							toastr.success("搬迁成功");
							toastr.subscribe(function() {
								// 模拟点击事件
								var queryBtn = parent.document.getElementById("wareHouse_select");
								$(queryBtn).trigger("click");
								var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
							});
						} else {
							toastr.error("搬迁失败");
						}
					},
					"error" : function(data) {
						toastr.warning("error");
						
					}
					
				});
				
			}
		});	
	})
	$("#rest").on('click',function(){
		layer.alert('确定取消搬迁？', {
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