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
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
<script src="<%=request.getContextPath()%>/resource/assets/js/jquery.min.js"></script>


<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="<%=request.getContextPath()%>/resource/js/Plugs/datatables/js/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/datatables/js/jquery.dataTables.evm.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/backStage/item/itemOutLibrary/itemOutLibraryOrderManage.js"></script>
<title>配件出库管理</title>

</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<div class="title_names">搜索查询</div>
					<ul class="search_content clearfix">
						<li>
							<label class="l_f">出库单号</label>
							<input name="" type="text" class="text_add" id="outLibraryCode" placeholder="输入出库单号" style="width: 200px" />
						</li>
						
						 <li>
						 	<label class="l_f">开始时间</label>
						 	<input class="inline laydate-icon" id="start" style=" margin-left:10px;">
						 </li>
						 <li>
						 	<label class="l_f">结束时间</label>
						 	<input class="inline laydate-icon" id="end" style=" margin-left:10px;">
						 </li>
						<li style="width: 90px;">
							<button type="button" class="btn_search" id="outLibrary_select">
								<i class="icon-search"></i>查询
							</button>
						</li>
					</ul>
				</div>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <a href="javascript:void(0)"
						id="item_outLibrary" date-class-id="2" class="btn btn-warning"><i class="icon-minus"></i>配件出库</a>
						<a href="javascript:void(0)" class="outLibraryOrder_delete btn btn-danger"><i
							class="icon-trash"></i>批量删除</a>
							<a href="javascript:void(0)" id="outLibrary" data-class-id="2" class="btn btn-info"><i
							class="icon-check"></i>配件出库单</a>
					</span> 
				</div>
				<!---->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th ><label><input type="checkbox" id="outLibrary_checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th >出库单号</th>
								<th >商品类型</th>
								<th >商品名称</th>
								<th >商品编号</th>
								<th >商品颜色</th>
								<th >出库数量</th>
								<!--<th >商品总价</th>-->
								<th>出库原因</th>
								<th>所属区域</th>
								<th >创建人</th>
								<th >创立日期</th>
								<th>状态</th>
								<th >操作</th>
							</tr>
						</thead>

					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
