<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css"/>       
        <link href="<%=request.getContextPath()%>/resource/assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/Widget/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
      
			<script src="<%=request.getContextPath()%>/resource/assets/js/jquery.min.js"></script>
		
		<script type="text/javascript">
			window.jQuery || document.write("<script src='resource/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		
        <script src="<%=request.getContextPath()%>/resource/assets/js/ace-elements.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/js/ace.min.js"></script>
        <script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/js/typeahead-bs2.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resource/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script> 
        <script src="<%=request.getContextPath()%>/resource/js/lrtk.js" type="text/javascript" ></script>
<title>分类管理</title>
</head>

<body>
<div class=" clearfix">
 <div id="category">
    <div id="scrollsidebar" class="left_Treeview">
    <div class="show_btn" id="rightArrow"><span></span></div>
    <div class="widget-box side_content" >
    <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
     <div class="side_list">
      <div class="widget-header header-color-green2">
          <h4 class="lighter smaller">产品类型列表</h4>
      </div>
      <div class="widget-body">
          <div class="widget-main padding-8">
              <div  id="treeDemo" class="ztree"></div>
          </div>
  </div>
  </div>
  </div>  
  </div>
<!---->
 <iframe ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO  SRC="productCategoryAdd" class="page_right_style"></iframe>
 </div>
</div>
</body>
</html>
<script type="text/javascript"> 
$(function() { 
	$("#category").fix({
		float : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false
	});
});
</script>
<script type="text/javascript">
//初始化宽度、高度  
 $(".widget-box").height($(window).height()); 
 $(".page_right_style").width($(window).width()-220);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height());
	 $(".page_right_style").width($(window).width()-220);
	})
 
/**************/
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				demoIframe.attr("src",treeNode.file + ".html");
				return true;
			}
		}
	}
};

var zNodes =[
	{ id:1, pId:0, name:"商城分类列表", open:true},
	{ id:11, pId:1, name:"蔬菜水果"},
	{ id:111, pId:11, name:"蔬菜"},
	{ id:112, pId:11, name:"苹果"},
	{ id:113, pId:11, name:"大蒜"},
	{ id:114, pId:11, name:"白菜"},
	{ id:115, pId:11, name:"青菜"},
	{ id:12, pId:1, name:"手机数码"},
	{ id:121, pId:12, name:"手机 "},
	{ id:122, pId:12, name:"照相机 "},
	{ id:13, pId:1, name:"电脑配件"},
	{ id:131, pId:13, name:"手机 "},
	{ id:122, pId:13, name:"照相机 "},
	{ id:14, pId:1, name:"服装鞋帽"},
	{ id:141, pId:14, name:"手机 "},
	{ id:42, pId:14, name:"照相机 "},
];
		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
		
$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	demoIframe.bind("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(zTree.getNodeByParam("id",'11'));
});	
</script>