
$(function(){
	//pathName:--->   mbuy/user/login.action  
    var pathName = window.location.pathname.substring(1);  
    //webName:--->mbuy  
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
    //return:--->http://localhost:9999/mbuy/  
    var path=window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
    var userName = parent.$("#text").text();
//接下来使用数据库储存留言数据
    buildTable(1,5);//初始化 查询
    function buildTable(pageNumber,pageSize) {
    	
    	var reqParams = {'pageNumber':pageNumber,'pageSize':pageSize,"customer":userName,"forward" : "JSON"};//请求数据
    	$.ajax({
 	        type:"POST",
 	        url:path+"guestBook/guestAllBookPage",
 	        data:reqParams,
 	        async:false,
 	        dataType:"json",
 	        success: function(data){
 	            if(data) {
         	           // options.totalPages = data.pages;
         	       var newoptions = {  
         	    		  bootstrapMajorVersion:3, //对应的bootstrap版本
					       currentPage: 1, //当前页数
					       numberOfPages: 5, //每次显示页数
					       totalPages:data.pages==0?1:data.pages, //总页数
					       shouldShowPage:true,//是否显示该按钮
					       useBootstrapTooltip:true,
					       size:"normal",  
					       //点击事件
					       onPageClicked: function (event, originalEvent, type, page) {
					    	   buildTable(page,5);
					       }
					}      
			         $('#page').bootstrapPaginator(newoptions); //重新设置总页面数目
			         var dataList = data.dataList;
			         
			         $(".msgFrame").empty();//清空表格内容
			         if (dataList.length > 0 ) {
			             $(dataList).each(function(){//重新生成
			            	 var contentDiv='<div class="content_1">';
					      	   contentDiv+='<img class="name" src="resource/images/foot03/II101.jpg" alt="photo">';
					      	   contentDiv+='<div class="mainInfo">'
					      	   contentDiv+=' <div class="userId"><a href="#">';
					      	   contentDiv+=this.userName;
					      	   contentDiv+='</a></div> <div class="conInfo">';
					      	   contentDiv+=this.guestBookContent;
					      	   contentDiv+='</div> <div class="time">';
					      	   contentDiv+=this.guestBookDate;
					      	   contentDiv+='</div> </div> </div>';
					           $(".msgFrame").prepend(contentDiv);
			             	    });  
	             	    } else {             	            	
	             	    	$(".msgFrame").prepend("<div class='content_1'><div class='mainInfo'>查无数据</div></div>");
	             	          }
             	    }else{
             	    	toastr.error("留言失败");
             	            }
             	 },
     	        error: function(e){
     	          toastr.warning("error");
     	        }
     	    });
	   
    }
   
 })