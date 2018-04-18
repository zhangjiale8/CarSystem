<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resource/images/title.jpg" />
<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css" />
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/datatables/css/dataTablePage.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resource/assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.min.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
<script src="<%=request.getContextPath()%>/resource/assets/js/jquery.min.js"></script>
<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=request.getContextPath()%>/resource/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=request.getContextPath()%>/resource/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="<%=request.getContextPath()%>/resource/js/Plugs/datatables/js/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/datatables/js/jquery.dataTables.evm.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.min.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/resource/assets/laydate/laydate.js"
	type="text/javascript"></script>
</head>
<body>
<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<div class="title_names">搜索查询</div>
					<ul class="search_content clearfix">
						<li><label class="l_f">用户名称</label><input name="userName" type="text" id="userName"
							class="text_add" placeholder="输入用户名称" style="width:200px" /></li>
						<li style="width: 90px;"><button type="button" id="userinfo_select"
								class="btn_search">
								<i class="icon-search"></i>查询
							</button></li>
					</ul>
				</div>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <a href="javascript:ovid()"
						id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加用户</a>
						<a href="javascript:ovid()"  class=" userinfo_delete btn btn-danger"><i
							class="icon-trash"></i>批量删除</a>
					</span> 
				</div>
				<!---->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover" style="width: 100%"
						id="sample-table">
						<thead>
							<tr>
								<th ><label><input type="checkbox" id="userinfo_checkAll"
										class="ace"><span class="lbl"></span></label></th>
								<th >登录名</th>
								<th >姓名</th>
								<th >手机</th>
								<th >加入时间</th>
								<th >等级</th>
								<th >状态</th>
								<th >操作</th>
							</tr>
						</thead>

					</table>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript" src="resource/js/backStage/user/userList.js"></script>