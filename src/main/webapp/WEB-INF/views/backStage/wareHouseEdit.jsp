<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resource/images/title.jpg" />
<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css" />
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
<script src="<%=request.getContextPath()%>/resource/assets/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/laydate/laydate.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resource/js/backStage/item/wareHouse/wareHouseEdit.js"
	type="text/javascript"></script>
	<style type="text/css">
	
	.form-horizontal {
	margin-top:50px;
	width: 40%;
	text-align: center;
	margin-left: 200px;
}
	</style>
<title>移动仓库商品</title>
</head>
<body>
	
	<div id="wareHouseEdit" class="form-horizontal">
		<div class="form-group">
				<input  name="itemID" style="display:none" id="itemID" value="${itemID}"/>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-lg control-label">仓库名称:</label>
			<div class="col-lg-1 col-sm" style="margin-left: 10px;">
				<select class="form-control" name="wareHouseName"  id="select">
					<option value='-1'>全部</option>
				</select>
			</div>
		</div>
		
		<div class="button_brand" style="margin-bottom: 50px;">
			<input name="" type="button" id="submit" class="btn btn-warning" value="保存" /> <input
				name="" type="reset" id="reset" value="取消" class="btn btn-warning" />
		</div>

	</div>
</body>
</html>