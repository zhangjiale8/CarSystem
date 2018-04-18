<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="<%=request.getContextPath()%>/<%=request.getContextPath()%>/resource/images/title.jpg" />
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
<script src="<%=request.getContextPath()%>/resource/assets/laydate/laydate.js"
	type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/resource/js/backStage/item/guestBook/commentManage.js" type="text/javascript" ></script>   
<title>留言</title>
</head>

<body>
<div class="margin clearfix">
 <div class="Guestbook_style">
 <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">用户名</label><input name="userName" id="userName" type="text" class="text_add" placeholder="输入留言信息" style=" width:200px"></li>
       <li style="width:90px;"><button type="button" id="comment_select" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
    <div class="border clearfix">
       <span class="l_f">
        
        <a href="javascript:void(0)"  data-state="1" class=" browse btn btn-sm btn-primary"><i class="fa fa-check"></i>&nbsp;已浏览</a>
        <a href="javascript:void(0)"  data-state="2" class="browse btn btn-yellow"><i class="fa fa-times"></i>&nbsp;未浏览</a>
       </span>
     </div>
    <!--留言列表-->
    <div class="comment_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="80"><label><input type="checkbox" id="comment_checkAll" class="ace"><span class="lbl"></span></label></th>
          <th >用户名</th>
          <th >评论内容</th>
          <th >评论时间</th>
          <th >评论等级</th>
          <th >状态</th>                
          <th >操作</th>
          </tr>
      </thead>
	
      </table>
    </div>
 </div>
</div>

</body>
</html>
