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
<script
	src="<%=request.getContextPath()%>/resource/js/backStage/item/itemOutLibrary/addItemOutLibraryOrder.js"
	type="text/javascript"></script>
<style type="text/css">
.form-horizontal {
	margin-top: 40px;
	margin-left: 200px;
}
</style>
<title>新建出库单</title>
</head>
<body>

	<div id="itemOutLibraryOrder" class="form-horizontal">
		<div class="form-group" style="display: none">
			<label for="firstname" class="col-sm-2 control-label">商品编号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="itemID" id="itemID" value="${itemExistWareHouse.itemID }" placeholder="请输入ID">
			</div>
		</div>
		<div class="form-group" style="display: none">
			<label for="firstname" class="col-sm-2 control-label">仓库位置编号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="wareHouseID" id="wareHouseID" value="${itemExistWareHouse.wareHouseID}" placeholder="请输入ID">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">出库单号:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" name="outLibraryCode" id="outLibraryCode" value="" placeholder="请输入库存单号">
				
			</div>
			<label for="firstname" class="col-sm-1 control-label"><a href="javascript:void(0)"
						id="outLibrary" style="margin-top: -5px;" title="自动生成单号" class="btn btn-warning"><i class="icon-plus"></i></a></label>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">库存数量:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" readonly="readonly" id="itemStockNum" name="itemStockNum" value="${itemExistWareHouse.itemStockNum}">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">出库数量:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="outLibraryNum" name="outLibraryNum" value="" placeholder="请输入出库量">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">出库原因:</label>
			<div class="col-sm-4" style="margin-left: 10px;">
				<select class="form-control" name="outLibraryReason" id="outLibraryReason">
					<option value="-1">全部</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">办理人:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="createPerson" name="createPerson" value=""
					placeholder="请输入办理人">
					
			</div>
		</div>

		<div class="button_brand" style="margin-left:135px;">
			<input name="" type="button" id="submit" class="btn btn-warning" value="保存" /> <input
				name="" type="reset" id="reset" value="取消" class="btn btn-warning" />
		</div>

	</div>

</body>
</html>