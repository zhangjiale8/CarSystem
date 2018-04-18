<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>4S店汽车销售以及服务管理系统</title>
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/resource/images/title.jpg"/>
		<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css"/>
		<script src="<%=request.getContextPath()%>/resource/js/jquery-1.9.1.min.js"></script>  
		<script src="<%=request.getContextPath()%>/resource/assets/js/ace-extra.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/js/typeahead-bs2.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/js/ace-elements.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/js/ace.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resource/js/page/index.js" type="text/javascript"></script>
		
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try {
					ace.settings.check('navbar', 'fixed')
				} catch(e) {}
			</script>
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>					
							<img src="resource/images/logos.png">
							</small>
					</a>
					<!-- /.brand -->
				</div>
				<!-- /.navbar-header -->
				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="time"><em id="time"></em></span><span class="user-info"><small>欢迎光临,</small><small id="text">${userName}</small>	</span>
								<i class="icon-caret-down"></i>
							</a>
							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								
								<li>
									<a href="javascript:ovid(0)" id="admin_info"><i class="icon-user"></i>个人资料</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="javascript:ovid(0)" id="Exit_system"><i class="icon-off"></i>退出</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try {
					ace.settings.check('main-container', 'fixed')
				} catch(e) {}
			</script>
			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="javascript:ovid(0)">
					<span class="menu-text"></span>
				</a>
				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try {
							ace.settings.check('sidebar', 'fixed')
						} catch(e) {}
					</script>
					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							汽车销售网站后台管理系统
						</div>
						
					</div>
					<!-- javascript:ovid(0)sidebar-shortcuts -->
					<ul class="nav nav-list" id="nav_list">
						<li class="home">
							<a href="javascript:void(0)" name="home" class="iframeurl" title=""><i class="icon-dashboard"></i><span class="menu-text"> 系统首页 </span></a>
						</li>
						<li>
							<a href="javascript:ovid(0)" class="dropdown-toggle"><i class="icon-desktop"></i><span class="menu-text"> 产品管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<!-- <li class="home">
									<a href="javascript:void(0)" name="categoryManage" title="产品类表" class="iframeurl"><i class="icon-double-angle-right"></i>分类管理</a>
								</li> -->
								<li class="home">
									<a href="javascript:void(0)" name="brandManage" title="品牌管理" class="iframeurl"><i class="icon-double-angle-right"></i>品牌管理</a>
								</li>
								
							</ul>
						</li>
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle"><i class="icon-plane"></i><span class="menu-text"> 销售管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<li class="home">
									<a href="javascript:void(0)" name="vehicleSale" title="整车销售"  data-class-id="1" class="iframeurl itemOrder"><i class="icon-double-angle-right"></i>整车销售</a>
								</li>
								<li class="home">
									<a href="javascript:void(0)" name="fittingSale" title="配件销售" data-class-id="2"  class="iframeurl itemOrder"><i class="icon-double-angle-right"></i>配件销售</a>
								</li>
								<li class="home">
									<a href="javascript:void(0)" name="lookCarManage" title="销售预约" data-class-id="1"  class="iframeurl itemOrder"><i class="icon-double-angle-right"></i>销售预约</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle"><i class="icon-download"></i><span class="menu-text"> 进库管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<li class="home">
									<a href="javascript:void(0)" name="vehicleIntoLibrary" title="整车进库" class="iframeurl"><i class="icon-double-angle-right"></i>整车进库</a>
								</li>
								<li class="home">
									<a href="javascript:void(0)" name="fittingIntoLibrary" title="配件进库" class="iframeurl"><i class="icon-double-angle-right"></i>配件进库</a>
								</li>
								
							</ul>
						</li>
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle"><i class="icon-upload"></i><span class="menu-text"> 出库管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<li class="home">
									<a href="javascript:void(0)" name="vehicleOutLibrary"  data-class-id="1" title="整车出库" class="iframeurl outLibrary"><i class="icon-double-angle-right"></i>整车出库</a>
								</li>
								<li class="home">
									<a href="javascript:void(0)" name="fittingOutLibrary"  data-class-id="2" title="配件出库" class="iframeurl outLibrary"><i class="icon-double-angle-right"></i>配件出库</a>
								</li>
								
							</ul>
						</li>
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle"><i class="icon-shopping-cart"></i><span class="menu-text"> 库存管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<li class="home">
									<a href="javascript:void(0)" name="vehicleStock" title="整车库存" class="iframeurl"><i class="icon-double-angle-right"></i>整车库存</a>
								</li>
								<li class="home">
									<a href="javascript:void(0)" name="fittingStock" title="配件库存" class="iframeurl"><i class="icon-double-angle-right"></i>配件库存</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle"><i class="icon-cloud"></i><span class="menu-text"> 仓库管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<li class="home">
									<a href="javascript:void(0)" name="wareHouseManage" title="仓库商品" class="iframeurl"><i class="icon-double-angle-right"></i>仓库信息</a>
								</li>

							</ul>
						</li>
						<li>
							<a href="#" class="dropdown-toggle"><i class="icon-wrench"></i><span class="menu-text"> 维修管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<li class="home">
									<a href="javascript:void(0)" name="repairOrderManage" title="维修订单管理" class="iframeurl"><i class="icon-double-angle-right"></i>维修订单管理</a>
								</li>
								<!--  <li class="home">
									<a href="javascript:void(0)" name="addRepairOrder" title="预约维修" class="iframeurl"><i class="icon-double-angle-right"></i>预约维修</a>
								</li>-->
							</ul>
						</li>
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle"><i class="icon-edit"></i><span class="menu-text"> 留言管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<li class="home">
									<a href="javascript:void(0)" name="guestBook" title="留言列表" class="iframeurl"><i class="icon-double-angle-right"></i>留言列表</a>
								</li>
								<!-- <li class="home">
									<a href="javascript:void(0)" name="feedBack" title="评论列表" class="iframeurl"><i class="icon-double-angle-right"></i>评论列表</a>
								</li> -->
							</ul>
						</li>
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle"><i class="icon-user"></i><span class="menu-text"> 客户管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
								<li class="home">
									<a href="javascript:void(0)" name="customerInfo" title="用户信息管理" class="iframeurl"><i class="icon-double-angle-right"></i>用户信息管理</a>
								</li>
								<li class="home">
									<a href="javascript:void(0)" name="customerStatistics" title="用户统计分析" class="iframeurl"><i class="icon-double-angle-right"></i>用户统计分析</a>
								</li>
							</ul>
						</li>
						
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle"><i class="icon-group"></i><span class="menu-text"> 系统管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">

								
								<li class="home">
									<a href="javascript:void(0)" name="administrators" title="管理员列表" class="iframeurl"><i class="icon-double-angle-right"></i>管理员列表</a>
								</li>
								
							</ul>
						</li>
					</ul>
					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>
					<script type="text/javascript">
						try {
							ace.settings.check('sidebar', 'collapsed')
						} catch(e) {}
					</script>
				</div>
				<div class="main-content">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch(e) {}
					</script>
					<div class="breadcrumbs" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="backStage">首页</a>
							</li>
							<li class="active"><span class="Current_page iframeurl"></span></li>
							<li class="active" id="parentIframe"><span class="parentIframe iframeurl"></span></li>
							<li class="active" id="parentIfour"><span class="parentIfour iframeurl"></span></li>
						</ul>
					</div>

					<iframe id="iframe" style="border:0; width:100%; background-color:#FFF;" name="iframe" frameborder="0" src="home">  </iframe>

					<!-- /.page-content -->
				</div>
				<!-- /.main-content -->

				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
						<i class="icon-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box" id="ace-settings-box">
						<div>
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
							javascript:ovid(0)	<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; 选择皮肤</span>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
							<label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
							<label class="lbl" for="ace-settings-rtl">切换到左边</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
							<label class="lbl" for="ace-settings-add-container">
	                                  切换窄屏
	                                  <b></b>
	                              </label>
						</div>
					</div>
				</div>
				<!-- /#ace-settings-container -->
			</div>
			<!-- /.main-container-inner -->

		</div>
	</body>

</html>