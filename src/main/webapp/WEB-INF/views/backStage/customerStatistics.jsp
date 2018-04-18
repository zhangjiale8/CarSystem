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
<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="resource/css/style.css" />
<link rel="stylesheet" href="resource/assets/css/font-awesome.min.css" />
<link href="resource/assets/css/codemirror.css" rel="stylesheet">

<script src="resource/assets/js/jquery.min.js"></script>
<!-- <![endif]-->
<script src="resource/assets/dist/echarts.js"></script>
<script src="resource/assets/js/bootstrap.min.js"></script>
<script src="resource/js/backStage/item/chart/customerStatistics.js"></script>


<title>无标题文档</title>
</head>

<body>
	<div class="page-content clearfix">

		<div class="state-overview clearfix" id="name">
			<div class="col-lg-3 col-sm-6">
				<section class="panel">
					<a href="javascript:ovid(0)" title="商城会员">
						<div class="symbol terques">
							<i class="icon-user"></i>
						</div>
						<div class="value">
							<h1></h1>
							<p></p>
						</div>
					</a>
				</section>
			</div>
			<div class="col-lg-3 col-sm-6">
				<section class="panel">
					<div class="symbol red">
						<i class="icon-play"></i>
					</div>
					<div class="value">
						<h1></h1>
						<p></p>
					</div>
				</section>
			</div>
			<div class="col-lg-3 col-sm-6">
				<section class="panel">
					<div class="symbol yellow">
						<i class="icon-ok"></i>
					</div>
					<div class="value">
						<h1></h1>
						<p></p>
					</div>
				</section>
			</div>
			<div class="col-lg-3 col-sm-6">
				<section class="panel">
					<div class="symbol blue">
						<i class="icon-stop"></i>
					</div>
					<div class="value">
						<h1></h1>
						<p></p>
					</div>
				</section>
			</div>
		</div>
		<!--实时交易记录-->
		<div class="clearfix">
			<div class="t_Record">
				<div id="main"
					style="height: 300px; overflow: hidden; width: 100%; overflow: auto"></div>
			</div>
			
		</div>
	</div>
</body>
</html>