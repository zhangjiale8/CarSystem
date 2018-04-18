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
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
<script src="<%=request.getContextPath()%>/resource/assets/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/jqueryform/jquery.form.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/laydate/laydate.js"
	type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/backStage/item/repair/repairOrderEdit.js"></script>
<style type="text/css">
.form-horizontal {
	margin-top:5px;
	margin-left: 200px;
}
.item{display: none }
</style>
<title>订单修改</title>
</head>
<body>

	<div id="itemOutLibraryOrder" class="form-horizontal">
		
		<div class="form-group" style="display: none">
			<label for="firstname" class="col-sm-2 control-label">订单ID:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control"  name="repairOrderID" id="repairOrderID" value="${repairOrder.repairOrderID }" placeholder="请输入ID">
			</div>
			
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">订单单号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" name="repairOrderCode" id="repairOrderCode" value="${repairOrder.repairOrderCode }" placeholder="请输入ID">
			</div>
			
		</div>
		
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">车辆型号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="itemModelNum"  name="itemModelNum" value="${repairOrder.itemModelNum }" placeholder="请输入车辆型号">
			</div>
		</div>
		
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">车辆牌照:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="carCode"  name="carCode" value="${repairOrder.carCode }" placeholder="请输入车辆牌照">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">维修部位:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control"  id="repairPosition" name="repairPosition" value="${repairOrder.repairPosition}">
			</div>
		</div>
		
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">维修类型:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="repairOrderType"  name="repairOrderType" value="${repairOrder.repairOrderType }" placeholder="请输入维修类型">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">维修费用:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="repairCost"  name="repairCost" value="${repairOrder.repairCost }" placeholder="请输入维修费用">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">客户姓名:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="customerName"  name="customerName" value="${ repairOrder.customerName}" placeholder="请输入客户姓名">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">联系方式:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="phone"  name="phone" value="${repairOrder.phone }" placeholder="请输入手机号">
			</div>
		</div>
		
		<div class="button_brand" style="margin-left:135px;">
			<input name="" type="button" id="submit" class="btn btn-warning" value="保存" /> <input
				name="" type="reset" id="reset" value="取消" class="btn btn-warning" />
		</div>

	</div>

</body>
</html>