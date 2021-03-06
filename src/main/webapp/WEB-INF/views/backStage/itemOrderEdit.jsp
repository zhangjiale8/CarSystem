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
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/backStage/item/itemOrder/itemOrderEdit.js"></script>
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
				<input type="text" class="form-control" name="itemOrderID" id="itemOrderID" value="${itemOrder.itemOrderID}" placeholder="请输入ID">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">订单单号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" name="itemOrderCode" id="itemOrderCode" value="${itemOrder.itemOrderCode}" placeholder="请输入ID">
			</div>
		</div>
		<div class="form-group" >
			<label for="firstname" class="col-sm-2 control-label">商品编号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" name="itemCode" id="itemCode" value="${itemOrder.item.itemCode}" placeholder="请输入ID">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">商品名称:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" id="itemName" name="itemName" value="${itemOrder.item.itemName}">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">商品颜色:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="itemColor" readonly="readonly" name="itemColor" value="${itemOrder.item.itemColor }" placeholder="请输入出库量">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">商品数量:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="itemNum" readonly="readonly" name="itemNum" value="${itemOrder.itemNum }" placeholder="请输入出库量">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">商品总价:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="totalPrice"  name="totalPrice" value="${itemOrder.totalPrice }" placeholder="请输入出库量">
			</div>
		</div>
		<div class="form-group" style="display: none">
			<label for="firstname" class="col-sm-2 control-label">付款方式:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="oldPayMethod"  name="oldPayMethod" value="${itemOrder.payMethod }" placeholder="请输入出库量">
			</div>
		</div>
		
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">付款方式:</label>
			<div class="col-sm-4" style="margin-left: 10px;">
				<select class="form-control" name="payMethod" id="payMethod">
					
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">客户地址:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="address"  name="address" value="${itemOrder.address }" placeholder="请输入出库量">
			</div>
		</div>
		<div class="button_brand" style="margin-left:135px;">
			<input name="" type="button" id="submit" class="btn btn-warning" value="保存" /> <input
				name="" type="reset" id="reset" value="取消" class="btn btn-warning" />
		</div>

	</div>

</body>
</html>