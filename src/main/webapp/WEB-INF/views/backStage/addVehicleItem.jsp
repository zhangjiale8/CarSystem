<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/evm_frame.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/evm_elements.css" />
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resource/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/utils.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script src="resource/js/Plugs/datatables/js/jquery.dataTables.min.js"></script>
<script src="resource/js/Plugs/datatables/js/jquery.dataTables.evm.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/backStage/item/itemAdd.js"></script>
<title>添加商品</title>
</head>
<body>
	
	<div class='asset_infos'>
		<input style="display: none" id='createPerson' value='${userName}'>
		<form id="assetInput_form" method="post">
			<div id="itemInfo">
				<div class='caption'>商品信息:</div>
				<dl class="attributes">
					<dt class="attribute">
						<div class="name">入库位置:</div>
						<div class="value">
							<select id = "wareHouse" name="wareHouse" >
						 		
							</select>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">商品名称:</div>
						<div class="value">
							<input class="attr" type="text" id="itemName" value=""/>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">商品价格:</div>
						<div class="value">
							<input class="attr" type="text" id="itemprice" value=""/>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">商品数量:</div>
						<div class="value">
							<input class="attr" type="text" id="itemNum" value=""/>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">商品颜色:</div>
						<div class="value">
							<input class="attr" type="text" id="itemColor" value=""/>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">商品编码:</div>
						<div class="value">
							<input class="attr" type="text" id="itemCode" value=""/>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">商品型号:</div>
						<div class="value">
							<input class="attr" type="text" id="itemModel" value=""/>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">热销类型:</div>
						<div class="value">
							<select id = "hot" name="hot" >
						 		
							</select>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">品牌:</div>
						<div class="value">
							<select id = "brand" name="itemBrandName" >
						 		<option value="-1">全部</option>
							</select>
						</div>
					</dt>
					<dt class="attribute">
						<div class="name">车系:</div>
						<div class="value">
							<select id = "series" name="itemSeriesName" >
						 		<option value="-1">全部</option>
							</select>
						</div>
					</dt>
				</dl>
			</div>
			<div id="attrs"></div>
			<dl id="saveBtn" style='text-align: right;'>
				<dt class='name'>
					<button type="button" id="assetMaintanence_save" style="margin-right:140px;">保存</button>
				</dt>
			</dl>
		</form>
	</div>
</body>
</html>