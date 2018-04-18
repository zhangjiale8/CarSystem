<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="<%=request.getContextPath()%>/resource/js/Plugs/datatables/js/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/datatables/js/jquery.dataTables.evm.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/backStage/item/itemStock/vehicleItemStockManage.js"></script>
<title>整车库存</title>
</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<div class="title_names">搜索查询</div>
					<ul class="search_content clearfix">
						<li><label class="l_f">商品条形码</label><input name="itemCoed" type="text"
							class="text_add" id="itemCode" placeholder="输入商品条形码" style="width: 200px" /></li>
						<li><label class="l_f">商品名称</label><input name="itemName" type="text"
							class="text_add" id="itemName" placeholder="输入商品名称" style="width: 200px" /></li>
						<li><label class="l_f">仓库名称</label>&nbsp;&nbsp;
							<select name="wareHouseName" style="width: 200px" id="wareHouseName" class="text_add">
							<option  value="-1">全部</option>
							</select></li>
						<li style="width: 90px;"><button type="button"
								class="btn_search" id="itemStock_select">
								<i class="icon-search"></i>查询
							</button></li>
					</ul>
				</div>
				<!--
				<div class="border clearfix">
					<span class="l_f"> <a href="javascript:ovid()"
						id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加出库单</a>
						<a href="javascript:ovid()" class="btn btn-danger"><i
							class="icon-trash"></i>批量删除</a>
					</span> <span class="r_f">共：<b>2345</b>条
					</span>
				</div>-->
				<!---->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th >商品编码</th>
								<th >商品类型</th>
								<th >商品名称</th>
								<th >商品颜色</th>
								<!--<th >商品价格</th>-->
								<!-- <th >出入库前数量</th> -->
								<th >入库量</th>
								<th >出库量</th>
								<th >库存量</th>
								<th>所属区域</th>
							</tr>
						</thead>

					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
