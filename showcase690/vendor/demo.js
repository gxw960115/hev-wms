$(function() {
	var randomScalingFactor = function() {
		return Math.round(Math.random() * 100)
	};
	var colors = Highcharts.getOptions().colors;
	$('#container').highcharts({
		chart: {
			type: 'column',
			reflow: true
		},
		title: {
			text: ''
		},
		subtitle: {

		},
		legend: {
			enabled: false
		},
		credits: {
			enabled: false
		},
		xAxis: {
			categories: [
				'Jan'
			],
			crosshair: true
		},
		yAxis: {
			min: 0,
			title: {
				text: ''
			}
		},
		tooltip: {
			headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
				'<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
			footerFormat: '</table>',
			shared: true,
			useHTML: true
		},
		plotOptions: {
			column: {
				pointPadding: 0.2,
				borderWidth: 0
			}
		},

		series: [{
			name: 'one',
			data: [randomScalingFactor()],
			color: '#4D90FD'

		}, {
			name: 'two',
			data: [randomScalingFactor()],
			color: colors[3]
		}, {
			name: 'three',
			data: [randomScalingFactor()],
			color: '#4D9000'

		}, {
			name: 'four',
			data: [randomScalingFactor()],
			color: '#41A63A'

		}]
	});

	$('#container1').highcharts({
		chart: {
			plotBackgroundColor: null,
			plotBorderWidth: null,
			plotShadow: false
		},
		title: {
			text: ''
		},
		legend: {
			enabled: false
		},
		credits: {
			enabled: false
		},
		series: [{
			type: 'pie',
			name: 'Browser share',
			data: [ {
					name: 'Firefox',
					y: 26.8,
					color:colors[3] 
				},  {
					name: 'IE',
					y: 42.8,
					color:colors[9] 
				}, {
					name: 'Chrome',
					y: 32.8,
					color:colors[6],
					sliced: true,
					selected: true
				},{
					name: 'Safari',
					y: 12.8,
					color:colors[7] 
				},{
					name: 'Opera',
					y: 12.8,
					color:colors[8] 
				},{
					name: 'Others',
					y: 12.8,
					color:colors[3] 
				} 
			]
		}]
	});

	$('#container2').highcharts({
		chart: {
			type: 'line'
		},
		title: {
			text: ''
		},
		subtitle: {
			text: ''
		},
		xAxis: {
			categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep']
		},
		yAxis: {
			title: {
				text: ''
			}
		},
		legend: {
			enabled: false
		},
		credits: {
			enabled: false
		},
		tooltip: {
			enabled: false,
			formatter: function() {
				return '<b>' + this.series.name + '</b><br>' + this.x + ': ' + this.y + '°C';
			}
		},
		plotOptions: {
			line: {
				dataLabels: {
					enabled: true
				},
				enableMouseTracking: false
			}
		},
		series: [{
			name: 'Tokyo',
			data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3],
			color: colors[2]
		}, {
			name: 'London',
			data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2]
		}]
	});


	$('#container3').highcharts({
		chart: {
			type: 'area'
		},
		title: {
			text: ''
		},
		subtitle: {
			text: ''
		},
		legend: {
			enabled: false
		},
		credits: {
			enabled: false
		},
		xAxis: {
			categories: ['1750', '1800', '1850', '1900', '1950', '1999', '2050'],
			tickmarkPlacement: 'on',
			title: {
				enabled: false
			}
		},
		yAxis: {
			title: {
				text: ''
			},
			labels: {
				formatter: function() {
					return this.value / 1000;
				}
			}
		},
		tooltip: {
			shared: true,
			valueSuffix: ' millions'
		},
		plotOptions: {
			area: {
				stacking: 'normal',
				lineColor: '#666666',
				lineWidth: 1,
				marker: {
					lineWidth: 1,
					lineColor: '#666666'
				}
			}
		},
		series: [{
			name: 'Asia',
			data: [502, 635, 809, 947, 1402, 3634, 5268],
			color:colors[4]
		}, {
			name: 'Africa',
			data: [106, 107, 111, 133, 221, 767, 1766],
			color:colors[4]
		}, {
			name: 'Europe',
			data: [163, 203, 276, 408, 547, 729, 628],
			color:colors[6]
		}, {
			name: 'America',
			data: [18, 31, 54, 156, 339, 818, 1201],
			color:colors[12]
		}, {
			name: 'Oceania',
			data: [2, 2, 2, 6, 13, 30, 46],
			color:colors[22]
		}]
	});

	$('#container4').highcharts({
		chart: {
			type: 'column'
		},
		title: {
			text: ''
		},
		legend: {
			enabled: false
		},
		credits: {
			enabled: false
		},
		xAxis: {
			categories: ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas']
		},
		credits: {
			enabled: false
		},
		series: [{
			name: 'John',
			data: [5, 3, 4, 7, 2],
			color:colors[9]
		}, {
			name: 'Jane',
			data: [2, -2, -3, 2, 1],
			color:colors[6]
		}, {
			name: 'Joe',
			data: [3, 4, 4, -2, 5],
			color:colors[8]
		}]
	});



	$('#down').AutoComplete({
		'data': ['基础服务', '用户服务', '部门服务', '数据字典服务', '客户管理服务', '信用管理服务', '项目管理服务', '项目信息管理服务', '执行计划管理服务', '实际执行情况管理服务', '质保金计划管理服务', '质保金计划管理服务'],
		'itemHeight': 20,
		'width': 180
	}).AutoComplete('show');

});