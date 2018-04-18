/*var $ = require('jquery');
var ajaxRequest = require('ajaxRequest');
require('dataTables');
require('plugins/datatables/css/jquery.dataTables.css');
*/

$.fn.table = function(options){
	
	//如果没有参数则返回
	if(options == null || options == undefined){
		return false;
		
	}
	
	/*
	options = {
		"aoColumns":[],//显示的列,必填
		"iDisplayLength": 10,//每页显示记录数，可选
        "sAjaxSource": url,//获取数据的url
        "myData":{},//自定义参数，会被拼接到url参数中
        "order":[1,"asc"],//默认排序列
        "before":undefined,//请求数据前自定义回调函数
        "after":undefined,//表格初始化完毕后的回调函数
        "error":undefined //请求失败的回调函数
	};
	*/
	
	var settings_default = {
            "bAutoWidth": false,                    //不自动计算列宽度
            "bProcessing": true,                    //加载数据时显示正在加载信息   
            "bServerSide": true,                    //指定从服务器端获取数据   
            "bFilter": false,                       //不使用过滤功能   
            "bLengthChange": false,                 //用户不可改变每页显示数量   
            "fnServerData": retrieveData,           //获取数据的处理函数
            "sPaginationType": "full_numbers",      //翻页界面类型   
            "iDisplayLength": 5,//每页显示的记录数
            "bDestroy":true,//是否每次都清空表重新生成
            "bSortabled":true,//是否开启排序功能
            "deferRender": true,//当处理大数据时，延迟渲染数据，有效提高Datatables处理能力
            "bScrollCollapse" : false, 
            "oLanguage": {//foot信息显示
            	"sUrl": "resource/dataShow.txt",
            }
		};
	
	
	var settings = $.extend(true,{},settings_default,options);
	
	function retrieveData(sSource, aoData, fnCallback) {
		
		if(settings.before){
			settings.before(settings,sSource, aoData);
		}
		
	    //将自定义参数添加到url请求中
		if(settings.myData != null && settings.myData != undefined){
			aoData.push({"name": "parameters", "value": JSON.stringify(settings.myData)});
		}
		
		$.ajax({
			url: sSource,
			data: aoData, //以json格式传递 
			dataType: "json",
			success: function(resp) {
	        	fnCallback(resp);
	        	if(settings.after){
	        		settings.after(sSource, aoData ,resp);
	        	}
	        },
		});
	}
	
	return $(this).dataTable(settings);
};