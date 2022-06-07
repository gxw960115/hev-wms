$(function(){
    var grid = $('#adminUser-manage-list').datagrid({
        rownumbers:true,
        scrollbarSize : 0,
        singleSelect:true,
        pageNumber : 1,
        pagination:true,
        url:'/user/searchUserExtList',
        method:'post'
    });

    var pager = grid.datagrid('getPager');	// get the pager of datagrid
    pager.pagination({
        showPageList:false,
        showRefresh:false,
        layout:['first','prev','links','next','last'],
        displayMsg : ""
    });
})

//列表操作
var applyFormatter = function(value,row){
    return "<a onclick=\'deleteUser("+row.id+")\'><img src=\'/assets/images/delete.png\'></a>"+"  "+"<a href= \'/adminUserManage/passwordView/"+row.id+"\'><img src=\'/assets/images/user.png\'></a>";
}

var statusFormatter = function(value,row){
    var status =value;
    if("1"==value)
    {
        status="正常"
    }else if("0"==value){
        status="锁定"
    }else
    {
        status="过期"
    }
    return status;
}

var timeFormatter = function(value, rec, index){
    if (value == undefined) {
        return "";
    }
    if (value == ""||null ==value ) {
        return "";
    }
    var date = new Date(value);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    var dateStr = year + '-' + month + '-' + day+' '+hour+':'+minute+':'+second;
    return dateStr;;

}

//查询列表
$("#search-btn").click(function(){
    var params = {name:$("#search-userName").val(),nickName:$("#search-nickName").val(),email:$("#search-email").val()};

    $('#adminUser-manage-list').datagrid({url:'/user/searchUserExtList',pageNumber : 1,queryParams : params});

    var pager=$('#adminUser-manage-list').datagrid('getPager');
    pager.pagination({
        showPageList:false,
        showRefresh:false,
        layout:['first','prev','links','next','last'],
        displayMsg : ""
    });
});

//组织查询参数
function getQueryParam(){
    var data = {};
    var userName = $("#search-userName").val();
    if(userName != ""){
        data.userName = userName;
    }
    var nickName = $("#search-nickName").val();
    if(nickName != ""){
        data.continent = nickName;
    }
    var email = $("#search-email").val();
    if(email != ""){
        data.email = email;
    }
    return data;
}

//重置表单
$("#reset-btn").click(function(){
    $("#search-form")[0].reset();
});

function exportUser(){
    var userName =$("#search-userName").val();
    var nickName = $("#search-nickName").val();
    var email = $("#search-email").val();
    window.location.href='/adminUserManage/exportUserList?userName='+userName+"&nickName="+nickName+"&email="+email;

}

function deleteUser(userId){
    if(confirm("确认要删除数据吗?")){
    var userId =userId;
    $.ajax({
        type : "post",
        url : "/adminUserManage/doDel",
        data :{userId: userId},
        success: function (data){
            var returnData = JSON.parse(data);
            alert(returnData.info);
            window.location.href='/adminUserManage/view';

        },
        error: function(data){
            var returnData = JSON.parse(data);
            alert(returnData.info);
        }
    });
    }
}

var nameFormatter = function(value,row){
    return '<a href=\'/adminUserManage/updateView/'+row.id+'\'>'+value+'</a>';
}