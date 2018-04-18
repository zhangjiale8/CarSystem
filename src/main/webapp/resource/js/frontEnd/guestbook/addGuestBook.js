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
	$(".subbtn").click(function(){
	   	 var text= $(".content").text();
	   	var userName = parent.$("#text").text();
	   	var count=0;
	   	 var time=getCurrentTime();
	   	 if(text==""){
	   	 	alert("您还没有输入任何内容！");
	   	 }
	   	 else{
	   	 	loadmessage(text,userName,time);
	   	 	count++;
		 	console.log('success!');
		 	$(".content").text("");
		 	$(".numofmessage").text("留言("+count+")");
	   	 }
	   })
	   function loadmessage(message,userName,time){
	      	//创建content_index
	      	//包含img.name + mainInfo
	      	//.userId .conInfo .time
		   var guestBook={
				   userName:userName,
				   guestBookDate:time,
				   guestBookContent:message
		   }
		   $.ajax({
				"type" : "POST",
				"url" : path+"guestBook/addGuestBook",
				"dataType" : "json",
				"data" : {
					guestBook:JSON.stringify(guestBook),
					"forward" : "JSON"
				},
				"success" : function(data) {
					if (data) {
						toastr.success("留言成功");
						var contentDiv='<div class="content_1">';
				      	   contentDiv+='<img class="name" src="resource/images/foot03/II101.jpg" alt="photo">';
				      	   contentDiv+='<div class="mainInfo">'
				      	   contentDiv+=' <div class="userId"><a href="#">';
				      	   contentDiv+=userName;
				      	   contentDiv+='</a></div> <div class="conInfo">';
				      	   contentDiv+=message;
				      	   contentDiv+='</div> <div class="time">';
				      	   contentDiv+=time;
				      	   contentDiv+='</div> </div> </div>';
				           $(".msgFrame").prepend(contentDiv);
						toastr.subscribe(function() {  
						});
					} else {
						toastr.error("留言失败");
					}
				},
				"error" : function(data) {
					toastr.warning("error");
				}
			});
	      	
	   }
	   function getCurrentTime(){
	   	   var today=new Date();
	   	   var y=today.getFullYear();
	   	   var mh=today.getMonth();
	   	   mh++;
	   	   var d=today.getDate();
	   	   var h=today.getHours();
	   	   var m=today.getMinutes();
	   	   var s=today.getSeconds();
	   	   m=checkTime(m)
	       s=checkTime(s)
	       var time=y+"-"+mh+"-"+d+"  "+h+":"+m+":"+s;
	       return time;
	   }
	   function checkTime(i){
	       if(i<10)
	         i="0"+i
	       return i
	    }
   
})