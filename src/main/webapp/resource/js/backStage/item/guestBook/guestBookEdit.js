/**
 * 
 */
$(function() {
	function checkLength(which) {
		var maxChars = 200; //
		if(which.value.length > maxChars){
		   layer.open({
		   icon:2,
		   title:'提示框',
		   content:'您输入的字数超过限制!',	
	    });
			// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
			which.value = which.value.substring(0,maxChars);
			return false;
		}else{
			var curr = maxChars - which.value.length; //250 减去 当前输入的
			document.getElementById("sy").innerHTML = curr.toString();
			return true;
		}
	};
	$('#checkbox').on('click', function() {
		if($('input[name="checkbox"]').prop("checked")) {
			$('.Reply_style').css('display', 'block');
		} else {

			$('.Reply_style').css('display', 'none');
		}
	})
	$("#submit").on('click', function(){
		var guestBookID=$("#guestBookID").val();
		var replyContent=JSON.stringify($("#form_textarea").val());
		
		
		if($('input[name="checkbox"]').prop("checked")) {
			if($('.form-control').val() == "") {
				layer.alert('回复内容不能为空！', {
					title: '提示框',
					icon: 0,
				})
			} else {
				layer.alert('确定回复该内容？', {
					title: '提示框',
					icon: 0,
					btn: ['确定', '取消'],
					yes: function(index) {
						$.ajax({
							"type" : "POST",
							"url" : "updateGuestBook",
							"dataType" : "json",
							"data" : {
								"replyContent":replyContent,
								"guestBookID" : guestBookID,
								
								"forward" : "JSON"
							},
							"success" : function(data) {
								if (data) {
									toastr.success("回复成功");
									toastr.subscribe(function() {
										layer.close(index);
										// 模拟点击事件
										var queryBtn = $("#guestBook_select");
										$(queryBtn).trigger("click");
										var index = parent.layer.getFrameIndex(window.name);
										parent.layer.close(index);
									});
								} else {
									toastr.error("回复失败");
								}
							},
							"error" : function(data) {
								toastr.warning("error");
								
							}
						});
						
					}
				});
			}
		} else {
			layer.alert('请勾选回复框！', {
				title: '提示框',
				icon: 0,
			}
			);
			
		}
		
	})
	$("#rest").on('click',function(){
		layer.alert('确定取消回复？', {
			title: '提示框',
			icon: 0,
			btn: ['确定', '取消'],
			yes: function(index) {
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		})
	})
})