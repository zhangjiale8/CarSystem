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
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/backStage/item/itemOutLibrary/itemOutLibraryOrderEdit.js"></script>
<style type="text/css">
.form-horizontal {
	margin-top:5px;
	margin-left: 200px;
}
.item{display: none }
</style>
<title>新建出库单</title>
</head>
<body>

	<div id="itemOutLibraryOrder" class="form-horizontal">
		<div class="form-group" style="display: none">
			<label for="firstname" class="col-sm-2 control-label">商品ID:</label><!-- 用于撤销出库单 -->
			<div class="col-sm-4">
				<input type="text" class="form-control" name="oldItemID" id="oldItemID" value="${itemOutLibrary.item.itemID}" placeholder="请输入ID">
			</div>
		</div>
		<div class="form-group" style="display: none">
			<label for="firstname" class="col-sm-2 control-label">商品ID:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="itemID" id="itemID" value="${itemOutLibrary.item.itemID }" placeholder="请输入ID">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">商品编号:</label>
			<div class="col-sm-4" style="margin-left: 10px;">
				<select class="form-control" name="itemCode" id="itemCode">
					<option value="${itemOutLibrary.itemID}" style="display: none"></option>
				</select>
			</div>
		</div>
		<!--<div class="form-group" style="display: none">
			<label for="firstname" class="col-sm-2 control-label">出库单号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" name="outLibraryCode" id="outLibraryCode" value="ItemOutLibrary.outLibraryCode" placeholder="请输入库存单号">
				
			</div>
			
		</div>-->
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">库存数量:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" id="itemStockNum" name="itemStockNum" value="${itemOutLibrary.itemStockNum}">
			</div>
		</div>
		<div class="form-group" style="display: none">
			<label for="firstname" class="col-sm-2 control-label">出库数量:</label><!-- 用于撤销之前的出库数量 -->
			<div class="col-sm-4">
				<input type="text" class="form-control" id="oldOutLibraryNum" name="oldOutLibraryNum" value="${itemOutLibrary.outLibraryNum}" placeholder="请输入出库量">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">出库数量:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="outLibraryNum" name="outLibraryNum" value="${itemOutLibrary.outLibraryNum}" placeholder="请输入出库量">
			</div>
		</div>
		
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">出库原因:</label>
			<div class="col-sm-4" style="margin-left: 10px;">
				<select class="form-control" name="outLibraryReason" id="outLibraryReason">
					<option value="${itemOutLibrary.outLibraryReason}" style="display: none"></option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">办理人:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="createPerson" name="createPerson" value="${ itemOutLibrary.createPerson}"
					placeholder="请输入办理人">
					
			</div>
		</div>
		<div class="form-group item">
			<label for="firstname" class="col-sm-2 control-label">商品名称:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" id="itemName" name="itemName" value="${itemOutLibrary.item.itemName}">
			</div>
		</div>
		<div class="form-group item">
			<label for="firstname" class="col-sm-2 control-label">商品颜色:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="itemColor" readonly="readonly" name="itemColor" value="${item.itemColor }" placeholder="请输入出库量">
			</div>
		</div>
		<div class="form-group item">
			<label for="firstname" class="col-sm-2 control-label">商品价格:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="itemPrice" readonly="readonly" name="itemPrice" value="${item.itemPrice }" placeholder="请输入出库量">
			</div>
		</div>
		<div class="form-group item">
			<label for="firstname" class="col-sm-2 control-label">商品型号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="itemModel" readonly="readonly" name="itemModel" value="${item.itemModel }" placeholder="请输入出库量">
			</div>
		</div>
		<div class="button_brand" style="margin-left:135px;">
			<input name="" type="button" id="submit" class="btn btn-warning" value="保存" /> <input
				name="" type="reset" id="reset" value="取消" class="btn btn-warning" />
		</div>

	</div>

</body>
</html>