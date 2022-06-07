
$(document).on("click",".subnavi-search-btn",function(){

	$.ajax({
		url:'js/libs/easyui/data/datagrid_data.json',
		dataType:"JSON",
		data:{
			pageIndex:0 // 第一页
		},
		success:function(data){
			// 数据中需要带上总条数，便于分页设置
			createDataGrid('#datagrid',data);
			new Pagination('#datagrid',data);
		}
	});
	
	// 因为是异步，所以先等一会去取数据；
	setTimeout(function(){
		var widget = $('#datagrid .datatable');
		console.log("获取数据是",widget.datagrid("getData")); 
	},1000);
});

$(document).on("click",".subnavi-supersearch",function(){
	var supersearchPanel = $(".subpop-panel");
	if(supersearchPanel.is(":visible")){
		supersearchPanel.fadeOut();
	}else{
		supersearchPanel.fadeIn();
	}
});
