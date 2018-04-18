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
    var itemClassificationID=$('#itemList').attr('data-item-id');
    
    buildTable(1,12,'',itemClassificationID);
    
    $("#brand").on('click','a',function(){
    	var text=$(this).text();
    	
    	buildTable(1,12,text,itemClassificationID);
    })
	$("#carSeries dd").on('click','.brandName',function(){
    	var text=$(this).text();
    	
    	buildTable(1,12,text,itemClassificationID);
    })
    $(".carList").on('click','.imgtype',function(){
    	var itemID=$(this).attr('data-item_id');
    	
    	
    	window.open("itemInfo?itemID="+itemID+"&classID="+itemClassificationID)
    	
    })
    
    $(".sea .search-btn").on('click',function(){
    	var name=$(".sea .sea-ipt-txt").val();
    	buildTable(1,12,name,itemClassificationID);
    })
    $(".seas .search-btn").on('click',function(){
    	var name=$(".seas .sea-ipt-txt").val();
    	buildTable(1,12,name,itemClassificationID);
    })
	function buildTable(pageNumber,pageSize,name,itemClassificationID) {
    	
    	var reqParams = {'pageNumber':pageNumber,'pageSize':pageSize,'name':name,'itemClassificationID':itemClassificationID,"forward" : "JSON"};//请求数据
    	$.ajax({
 	        type:"POST",
 	        url:path+"item/getItemAll",
 	        data:reqParams,
 	        async:false,
 	        dataType:"json",
 	        success: function(data){
 	            if(data) {
         	           // options.totalPages = data.pages;
         	       var newoptions = {  
         	    		  bootstrapMajorVersion:3, //对应的bootstrap版本
					       currentPage: 1, //当前页数
					       numberOfPages: pageSize, //每次显示页数
					       totalPages:data.pages==0?1:data.pages, //总页数
					       shouldShowPage:true,//是否显示该按钮
					       useBootstrapTooltip:true,
					         
					       //点击事件
					       onPageClicked: function (event, originalEvent, type, page) {
					    	   buildTable(page,pageSize,name,itemClassificationID);
					       }
					}      
			         $('#page').bootstrapPaginator(newoptions); //重新设置总页面数目
			         var dataList = data.dataList;
			         
			         $(".carList").empty();//清空表格内容
			         if (dataList.length > 0 ) {
			             $(dataList).each(function(){//重新生成
			            	 var li="<li><div class='list-infoBox'><a title='"+this.itemName+"'  class='imgtype' data-item_id='"+this.itemID+"' href='javaScript:void(0)'> <img width='290'+"+
								"height='194' src='"+this.photoResource+"' alt='"+this.itemBrandName+"'></a><p class='infoBox'><a title='"+this.itemName+"' href='javaScript:void(0)'"+
								"target='_blank' class='info-title imgtype'>车系: "+this.itemSeriesName+"</a></p><p class='priType-s'><span> <i class='fc-org priType'>价格: "+this.itemPrice+"</i>" +
								"</span></p></div></li>"
								$(".carList").prepend(li);
			             	    });  
	             	    } else {             	            	
	             	    	$(".carList").prepend("<div class='content_1' style='text-align: center;'><div class='mainInfo'>查无数据</div></div>");
	             	          }
             	    }else{
             	    	toastr.error("数据获取失败");
             	            }
             	 },
     	        error: function(e){
     	          toastr.warning("error");
     	        }
     	    });
	   
    }
})