$(function(){
    var grid = $('#dg').datagrid({
        rownumbers:true,
        scrollbarSize : 0,
        singleSelect:false,
        pagination:true,
        url:'/plant/list',
        method:'post'
    });

    var pager = grid.datagrid('getPager');	// get the pager of datagrid
    pager.pagination({
        showPageList:false,
        showRefresh:false,
        layout:['first','prev','links','next','last'],
        displayMsg : ""
    });
	
	
    //查询列表
    $("#search-btn").click(function(){
		grid.datagrid("reload",getQueryParam());
    });

    //组织查询参数
    function getQueryParam(){
		var data = {};
		var plantCode = $("#plantCode").val();
		if(plantCode != ""){
			data.plantCode = plantCode;
		}
		var plantName = $("#plantName").val();
		if(plantName != ""){
			data.plantName = plantName;
		}
		return data;
    }

    //重置表单
    $(".bigBtn").click(function(){
        $("#search-form")[0].reset();
    });
	
    //删除国家数据
    $("#list-delete-btn").click(function(){
        var selRows = grid.datagrid('getChecked');
        if(selRows == 0){
			$.messager.alert(I18n.t("codeInfomanage-tips"),I18n.t("codeInfomanage-selectData"),'warning');
            return;
        }
        $.messager.confirm(I18n.t("codeInfomanage-conf"), I18n.t("codeInfomanage-whetherDeleteProject"), function(r){
            if (r){
                var code = "";
                for(var i=0;i<selRows.length;i++){
                    code += selRows[i].countryCode + ",";
                }
				$.ajax({
					type : "post",  
					url : "/country/delete",
					data : {code:code},
					success : function(data){
						if(data == "success"){
							$.messager.alert(I18n.t("codeInfomanage-remind"),I18n.t("codeInfomanage-deleteSuccess"));
							grid.datagrid("reload");
						}else{
							$.messager.alert(I18n.t("codeInfomanage-tips"),I18n.t("codeInfomanage-deleteFailTryAgain"),'warning');
						}
					}
				});
            }});
    });
	
})

//列表操作
var applyFormatter = function(value,row){
    return '<a href=\'/country/'+row.countryCode+'\'><img src=\'/assets/images/project.png\'></a>';
}