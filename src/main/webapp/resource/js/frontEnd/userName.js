/**
 * 
 */

$(function(){
		var userName = $("#text").text();
		if(userName==null||userName==''){
			$('#leftsead #guestbook').css("display", "none");
		}
		var roleId = $("#role").text();
		if (roleId == 1) {
			$("#b-back").css("display", "block");
		}
		if (!userName) {
			return;
		} else {
			$("#b-cancel").css("display", "block");
			$("#b-name").css("display", "block");
			$("#b-login").css("display", "none");
		}
		$("#guestbook").on('click',function(){
			
			layer.open({
				type : 2,
				title : '留言板',
				shadeClose : false,
				shade : 0.5,
				area : [ '80%', '80%' ],
				content : 'toAddGuestBook'
			});
		})
})