<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css"/>
		
		<script src="<%=request.getContextPath()%>/resource/assets/js/ace-extra.min.js"></script>
		
		<script src="<%=request.getContextPath()%>/resource/js/jquery-1.9.1.min.js"></script>        
        <script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<title>登陆</title>
</head>

<body class="login-layout">
<div class="logintop">    
    <span>欢迎后台管理界面平台</span>    
     
    </div>
    <div class="loginbody">
<div class="login-container">
	<div class="center">
	<h1>
									<i class="icon-leaf green"></i>
									<span class="orange">汽车服务</span>
									<span class="white">后台管理系统</span>
								</h1>
								<h4 class="white">Background Management System</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box widget-box no-border visible">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												管理员登陆
											</h4>

											<div class="login_icon"><img src="<%=request.getContextPath()%>/resource/images/login.png" /></div>

											<form class="">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="登录名"  name="登录名">
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" name="密码">
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace">
															<span class="lbl">保存密码</span>
														</label>

														<button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="login_btn">
															<i class="icon-key"></i>
															登陆
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110">通知</span>
											</div>

											<div class="social-login center">
											本网站系统不再对IE8以下浏览器支持，请见谅。
											</div>
										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											

											
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
                        </div>
</body>
</html>
<script>
$('#login_btn').on('click', function(){
	     var num=0;
		 var str="";
     $("input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
               
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
		  if(num>0){  return false;}	 	
          else{
			  layer.alert('登陆成功！',{
               title: '提示框',				
			   icon:1,		
			  });
	          location.href="index.html";
			   layer.close(index);	
		  }		  		     						
		
	})

</script>