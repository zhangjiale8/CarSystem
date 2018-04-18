<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<link href="${pageContext.request.contextPath}/resource/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/fileinput/fileinput.css" />  
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/fileinput/fileinput.min.css" />  
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/Plugs/toastr/toastr.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/layer/skin/layer.css" />
<script src="${pageContext.request.contextPath}/resource/assets/js/jquery-2.0.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/assets/layer/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/Plugs/bootstrap/3.3.6/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/Plugs/fileinput/fileinput.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/Plugs/fileinput/fileinput.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/Plugs/fileinput/fileinput_locale_zh.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/Plugs/toastr/toastr.min.js" type="text/javascript"></script>


<style>
        body {
            font-family: "Arial", "Microsoft YaHei", "黑体", "宋体", sans-serif;
            background-color: #EBF5F3;
        }
        * {
            margin: 0;
        }
        html, body {
            height: 100%;
        }
        .navbar-custom {
            /*color: #FFFFFF;*/
            background-color: #56b9ab;
        }
        .navbar-brand,
        .navbar-nav li a {
            line-height: 55px;
            height: 55px;
            padding-top: 0px;
            font-family: "Arial", "Microsoft YaHei", "黑体", "宋体", sans-serif;
        }
        .navbar-default .navbar-nav > li > a {
            color: #ffffff;
        }
        .navbar-default .navbar-nav > li > a:hover {
            color: #175A94;
        }
        .page-header {
            font-family: "Arial", "Microsoft YaHei", "黑体", "宋体", sans-serif;
            /* border-bottom: 1px solid #bbb;*/
        }
        hr {
            border-bottom: 1px solid #bbb;
        }
        .img_border {
            border: 1px solid #bbb;
        }
        @media screen and (min-width: 800px) {
            .container {
                width: 800px;
            }
        }
        @media screen and (min-width: 800px) {
            .center_toaster {
                right: 35%;
                width: 30%;
            }
        }
        @media screen and (min-width: 400px) and (max-width: 799px) {
            .center_toaster {
                right: 25%;
                width: 50%;
            }
        }
        @media screen and (min-width: 200px ) and (max-width: 399px) {
            .center_toaster {
                right: 10%;
                width: 80%;
            }
        }
        .row a {
            text-decoration: none;
        }
        .row a:hover {
            text-decoration: none;
        }
        .addMaigin {
            margin-bottom: 30px;
        }
        .change_font {
            font-size: 1.5em;
        }
        .button_width {
            width: 4em;
        }
        .button_width2 {
            width: 4em;
        }
        .wrapper {
            min-height: 50;
            height: auto !important;
            height: 500px;
            margin: 0 auto -6em;
        }
        .push {
            height: 6em;
        }
        .footer, {
            height: 4em;
        }
        .color_white{
            background: #ffffff;
        }
    </style>


</head>

<body>

<div class="wrapper">
    
	<input  id="itemID" style="display: none" value=${itemID }>
    <div class="container kv-main">
    	
        <div class="row title">
        <div class="row">商品标题照片</div>
            <div style="padding:10px; ">
                <form enctype="multipart/form-data">
                    <input  class="file" name="file"  type="file" multiple data-max-file-count="1">
                    
                    <br>
                </form>
            </div>
        </div>
		<div class="row list" style="display: none">
			<div class="row">商品详情照片</div>
            <div style="padding:10px; ">
                <form enctype="multipart/form-data">
                    <input  class="files" name="file"  type="file" multiple data-min-file-count="1">
                    <br>
                </form>
            </div>
        </div>

    </div>
    <div class="push"></div>
</div>
</body>

<script type="text/javascript">
var itemID=$("#itemID").val();
$('.file').fileinput({
    language: 'zh',
    uploadUrl: '${pageContext.request.contextPath}/photo/uploadMultipleFile',
    allowedPreviewTypes : ['image', 'html', 'text', 'video', 'audio', 'flash'],
    showUpload : true,
    autoReplace : true,
    uploadExtraData : {'itemID':itemID,'purposeID':1},
    showCaption : true,
    msgNoFilesSelected : '没有可以上传的文件'
});

$('.file').on('fileerror', function(event, data) {
    if(data.response.status=='ERROR'){
    	
    	toastr.success("图片上传失败");
    }
});
$('.file').on('fileuploaded', function(event, data, previewId, index) {
	if(data.response.status=='SUCCESS'){
		$(".title").hide();
		$(".list").show();
    	toastr.success("图片上传成功,请继续上传商品详情图片");
    }
  });
$('.files').fileinput({
    language: 'zh',
    uploadUrl: '${pageContext.request.contextPath}/photo/uploadMultipleFile',
    allowedPreviewTypes : ['image', 'html', 'text', 'video', 'audio', 'flash'],
    showUpload : true,
    autoReplace : true,
    uploadExtraData : {'itemID':itemID,'purposeID':2},
    showCaption : true,
    msgNoFilesSelected : '没有可以上传的文件'
});

$('.files').on('fileerror', function(event, data) {
    if(data.response.status=='ERROR'){
    	
    	toastr.success("图片上传失败");
    }
});
$('.files').on('fileuploaded', function(event, data, previewId, index) {
	if(data.response.status=='SUCCESS'){
		$(".list").hide();
		$(".title").show();
    	toastr.success("图片上传成功");
    	var queryBtn = parent.document.getElementById("enterLibrary_select");
		
		$(queryBtn).trigger("click");
    	var index=parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
		
    }
  });
</script>

</html>