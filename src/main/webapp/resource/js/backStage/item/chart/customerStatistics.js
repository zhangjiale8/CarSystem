$(document).ready(
		function() {
			$(".t_Record").width($(window).width()-320);
			  //当文档窗口发生改变时 触发  
			$(window).resize(function(){
			 $(".t_Record").width($(window).width()-320);
			});
			$.getJSON("chart/getItemOrderStateAndCustomerCount",
					function(result) {
						for (var i = 0; i < result.length; i++) {
							var name = result[i]["name"];
							var value = result[i][result[i]["name"]];
							$('#name').find('h1').eq(i).html(value);
							$('#name').find('p').eq(i).html(name);
						}
					})
			require.config({
				paths : {
					echarts : 'resource/assets/dist'
				}
			});
			require([ 'echarts', 'echarts/theme/macarons',
					'echarts/chart/line', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
					'echarts/chart/bar' ], 
					
					drawOption
					)
			function drawOption(ec, theme) {
				var myChart = ec.init(document.getElementById('main'), theme);
				$.getJSON("chart/getItemEnterAndOutAndStock", function(result) {
					var x = [];
					var a = [];
					var b = [];
					var c = [];
					for (var i = 0; i < result.length; i++) {
						a.push(result[i]["itemOutLibraryNum"]);
						b.push(result[i]["itemEnterLibraryNum"]);
						x.push(result[i]["wareHouseName"]);
						c.push(result[i]["itemStockNum"]);
					}
				option = {
					title : {
						text : '商品出入库统计',
						subtext : '实时获取出入库记录'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '出库', '入库', '库存']
					},
					toolbox : {
						show : true,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'line', 'bar' ]
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					calculable : true,
					xAxis : [ {
						type : 'category',
						data : x
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [
							{
								name : '出库',
								type : 'bar',
								data : a,
								markPoint : {
									data : [ {
										type : 'max',
										name : '最大值'
									}, {
										type : 'min',
										name : '最小值'
									} ]
								}
							},
							{
								name : '入库',
								type : 'bar',
								data : b,
								markPoint : {
									data : [ {
										type : 'max',
										name : '最大值'
									}, {
										type : 'min',
										name : '最小值'
									}  ]
								},

							},
							{
								name : '库存',
								type : 'bar',
								data : c,
								markPoint : {
									data : [{
										type : 'max',
										name : '最大值'
									}, {
										type : 'min',
										name : '最小值'
									} ]
								},

							} ]
				};

				myChart.setOption(option);
			
			})
		};
		})