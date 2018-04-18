/**
 * 
 */
//pathName:--->   mbuy/user/login.action  

$(function(){
	
	var pathName = window.location.pathname.substring(1); 
	var parm = window.location.search.substring(1); 
	
	var parms=parm.split("&") ;
	
	var itemID=parms[0].substring(parms[0].indexOf('=')+1).toUpperCase();
	var classID=parms[1].substring(parms[1].indexOf('=')+1).toUpperCase();
	
	//webName:--->mbuy  
	var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
	//return:--->http://localhost:9999/mbuy/  
	var path=window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
	if(classID==1){
		var div="<div class='order_button'> <a class='wanttoprice orderbut' href='javaScript:void(0)' id='sendMESS'>车辆预定</a> </div>";
		$(".row .tel-box").before(div)
	}else{
		var div="<div class='order_button'> <a class='wanttoprice orderbut' href='javaScript:void(0)' id='sendMESSs'>配件预定</a> </div>";
		$(".row .tel-box").before(div)
	}
	$.ajax({
	        type:"POST",
	        url:path+"item/itemInfo",
	        data: {"itemID":itemID,"forward" : "JSON"},
	        async:false,
	        dataType:"json",
	        success: function(item){
	            if(item) {
	            	$(".mainpic").append("<img src='"+item.photoResource+"' height='390'><a href=''#picture' class='showpic'>查看图集</a>")
	            	$(".price-box .nowprice").html(item.itemPrice+"元");
	            	$(".item-box #brand").html(item.itemBrandName);
	            	$(".item-box #series").html(item.itemSeriesName);
	            	var attitemAttr=item.map;
	            	var attrType=attitemAttr["attr"]["attrTypes"];
	            	var attr=attitemAttr["attr"]["attrs"];
	            	var photo=attitemAttr["photo"];
	            	var x=[];
	            	var y=[];
	            	var count=0;
	            	for(var i = 0 ;i < attrType.length ; i++){
	            		var name=attrType[i]["attribute_type_show_name"];
	            		var tr="<tr><th>"+name+"</th></tr>";
	            		
	            		$("#base .ca-table table").append(tr);
	            		for(var j = 0 ;j < attr.length ; j++){
	            			var names=attr[j]["attribute_type_show_name"];
	            			
	            			
	            			if(name==names){
	            				
	        					var attrName=attr[j]["item_attr_name"];
	            				
	            				var value=attr[j]["item_attr_value"];
	            				
		            			x.push(attrName);
		            			y.push(value);
	            				var c=++count;
	            				
		            			if(c==4){
		            				
		            				var td="<tr><td class='ca-td1'>"+x[0]+":</td><td>"+y[0]+"</td>"+
									"<td class='ca-td1'>"+x[1]+":</td><td>"+y[1]+"</td>"+
									"<td class='ca-td1'>"+x[2]+":</td><td>"+y[2]+"</td>"+
									"<td class='ca-td1'>"+x[3]+":</td><td>"+y[3]+"</td></tr>";
		            				$("#base .ca-table table").append(td);
		            				x=[];
			            			y=[];
			            			count=0;
		            			}
		            			
	            				
	            			}
	            			
	            		}
	            	}
	            	for(var k = 0 ;k < photo.length ; k++){
	            		var photoResource=photo[k]["photo_resource"];
	            		
	            		var picture="<li class='fl'><img src='"+photoResource+"' width='590' height='500' /></li>";
	            		$("#picture .carpiclist").append(picture);
	            	}
	            }else{
         	    	toastr.error("数据获取失败");
         	            }
         	 },
 	        error: function(e){
 	          toastr.warning("error");
 	        }
 	    });
		$("#sendMESS").on('click',function(){
			var userName = $("#text").text();
			var lookCarOrder={
					customerName:userName,
					itemID:itemID
			}
			layer.alert('确定预定此车', {
				title: '提示框',
				icon: 0,
				btn: ['确定', '取消'],
				yes: function(index) {
					
					$.ajax({
						"type" : "POST",
						"url" : path+"lookCarOrder/addLookCarOrder",
						"dataType" : "json",
						"data" : {
							lookCarOrder:JSON.stringify(lookCarOrder),"forward" : "JSON"
						},
						"success" : function(data) {
							if (data) {
								toastr.success("预定成功");
								toastr.subscribe(function() {
									// 模拟点击事件
									var queryBtn = document.getElementById("memberCenter");
									$(queryBtn).trigger("click");
									layer.close(layer.index);
									var index=parent.layer.getFrameIndex(window.name);

									parent.layer.close(index);
								});
							} else {
								toastr.error("预定失败");
							}
						},
						"error" : function(data) {
							toastr.warning("error");
							
						}
						
					});
					
				}
			
			});	
		})
		$("#sendMESSs").on('click',function(){
			var userName = $("#text").text();
			var lookCarOrder={
					customerName:userName,
					itemID:itemID
			}
			layer.alert('确定预约购买此零件', {
				title: '提示框',
				icon: 0,
				btn: ['确定', '取消'],
				yes: function(index) {
					
					$.ajax({
						"type" : "POST",
						"url" : path+"lookCarOrder/addLookCarOrder",
						"dataType" : "json",
						"data" : {
							lookCarOrder:JSON.stringify(lookCarOrder),"forward" : "JSON"
						},
						"success" : function(data) {
							if (data) {
								toastr.success("预定成功");
								toastr.subscribe(function() {
									// 模拟点击事件
									var queryBtn = document.getElementById("memberCenter");
									$(queryBtn).trigger("click");
									layer.close(layer.index);
									var index=parent.layer.getFrameIndex(window.name);

									parent.layer.close(index);
								});
							} else {
								toastr.error("预定失败");
							}
						},
						"error" : function(data) {
							toastr.warning("error");
							
						}
						
					});
					
				}
			
			});	
		})
});

	
