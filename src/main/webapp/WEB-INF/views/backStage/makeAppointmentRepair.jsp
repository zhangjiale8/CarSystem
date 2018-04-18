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
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/backStage/item/itemOrder/makeAppointment.js"></script>
<title>整车出库单页</title>

</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<div class="title_names">搜索查询</div>
					<ul class="search_content clearfix">
						<li>
							<label class="l_f">用户名</label>
							<input name="customerName" type="text" class="text_add" id="customerName" placeholder="输入订单号" style="width: 200px" />
						</li>
						<li>
							<label class="l_f">手机号</label>
							<input name="phoneNum" type="text" class="text_add" id="phoneNum" placeholder="输入创建人姓名" style="width: 200px" />
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
							<button type="button" class=" btn_search" id="lookCarOrder_select">
								<i class="icon-search"></i>查询
							</button>
						</li>
					</ul>
				</div>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <!--  <a href="javascript:void(0)"
						id="add_itemOrder" date-class-id="1" class="btn btn-warning"><i class="icon-plus"></i>新增订单</a>
						<a href="javascript:void(0)" class="itemOrder_delete btn btn-danger"><i
							class="icon-trash"></i>批量删除</a>-->
						<a href="javascript:void(0)"
						 data-state-id="1" class="lookCarOrder_handle btn btn-warning">预约成功</a>
						<a href="javascript:void(0)" data-state-id="2" class="lookCarOrder_handle btn btn-danger">待处理</a>	
						<a href="javascript:void(0)" style="display: none"
						id="classID" date-class-id="1" class="btn btn-warning"></a>
					</span> 
				</div>
				<!---->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th ><label><input type="checkbox" id="lookCarOrder_checkbox"
										class="ace"><span class="lbl"></span></label></th>
								
								<th >商品编号</th>
								<th >商品类型</th>
								<th >商品名称</th>
								<th >商品型号</th>
								<th >商品颜色</th>
								<th >商品单价</th>
								<th>客户名称</th>
								<th>联系方式</th>
								<th >预约日期</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>

					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
