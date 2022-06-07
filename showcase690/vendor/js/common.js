/**
 * 公共js
 * author liyun
 */
$(function() {
	// 初始化下拉后赋汉字
	Date.prototype.format = function(format) {
		var o = {
			"M+" : this.getMonth() + 1, // month
			"d+" : this.getDate(), // day
			"h+" : this.getHours(), // hour
			"m+" : this.getMinutes(), // minute
			"s+" : this.getSeconds(), // second
			"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
			"S" : this.getMilliseconds()
		// millisecond
		}
		if (/(y+)/.test(format))
			format = format.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(format))
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
						: ("00" + o[k]).substr(("" + o[k]).length));
		return format;
	}
})
/**
 * 格式化日期为 年-月-日
 * @param value
 * @returns
 */
function formatY_M_D(value) {
	if (value == null || value == '') {
		return '';
	}
	var dt;
	if (value instanceof Date) {
		dt = value;
	} else {
		dt = new Date(value);
	}
	return dt.format("yyyy-MM-dd"); // 扩展的Date的format方法(上述插件实现)
}
/**
 * 格式化日期为 年月日
 * @param value
 * @returns
 */
function formatYMD(value) {
    if (value == null || value == '') {
        return '';
    }
    var dt;
    if (value instanceof Date) {
        dt = value;
    } else {
        dt = new Date(value);

    }
    return dt.format("yyyyMMdd"); // 扩展的Date的format方法(上述插件实现)
}
/**
 * 格式化日期为 年月日 时分秒
 * @param value
 * @returns
 */
function formatYMDHMS(value) {
	if (value == null || value == '') {
		return '';
	}
	var dt;
	if (value instanceof Date) {
		dt = value;
	} else {
		dt = new Date(value);

	}
	return dt.format("yyyy-MM-dd hh:mm:ss"); // 扩展的Date的format方法(上述插件实现)
}
/**
 * 初始化分页
 * @param grid
 * @param pageSize
 */
function initPagination(grid){
    var pager = grid.datagrid('getPager');
    var options = pager.data("pagination").options;
    pager.pagination({
        showPageList:true,
        showRefresh:true,
        pageSize:options.pageSize,
        pageList : [ 10, 20, 50, 100, 200 ],
        layout:['list','first','prev','links','next','last'],
        displayMsg : ""
    });
}
/**
 * 初始化分页
 * @param grid
 * @param pageSize
 */
function initPaginationForDialog(grid){
    var pager = grid.datagrid('getPager');
    var options = pager.data("pagination").options;
    pager.pagination({
        showPageList:true,
        showRefresh:true,
        pageSize:options.pageSize,
        pageList : [ 10, 20, 50, 100, 200 ],
        links:8,
        layout:['list','first','prev','links','next','last'],
        displayMsg : ""
    });
}
/**
 * 判断json是否为空
 * @param grid
 * @param pageSize
 */
function isEmpty(json){
    if(json){
        for(attr in json){
            return false;
        }
        return true;
    }else{
        return true;
    }
}
Date.prototype.DateAdd = function(strInterval, Number) {     
	var dtTmp = this;    
	switch (strInterval) {     
		case 's' :return new Date(Date.parse(dtTmp) + (1000 * Number));    
		case 'n' :return new Date(Date.parse(dtTmp) + (60000 * Number));    
		case 'h' :return new Date(Date.parse(dtTmp) + (3600000 * Number));    
		case 'd' :return new Date(Date.parse(dtTmp) + (86400000 * Number));    
		case 'w' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));    
		case 'q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());    
		case 'm' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());    
		case 'y' :return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());    
	}    
}
/**
 * 得到d1日期前n天
 * d1 起始时间，格式：2010-10-10
 * n  整数
 */		
function getLastRq(d1,n)
{
	var date1 = null;
	var rqc = 0;
	var arr = d1.split("-",-1);
	date1 =new Date(parseInt(arr[0],10),parseInt(arr[1],10)-1,parseInt(arr[2],10));
	date1 = date1.DateAdd("d",n);
	var y = date1.getFullYear();
	var m = date1.getMonth()+1;
	var day = date1.getDate();
	if(m<10)
	{
		m = "0"+m;
	}
	if(day<10)
	{
		day = "0"+day;
	}
	return y+"-"+m+"-"+day;
}
/**
 *置空input text
 */
function resetData(obj){
	$(obj).parent().parent().siblings().find("input:text").not("[readonly]").each(function(index){
		$(this).val("");
	});
	$(obj).parent().parent().siblings().find(".easyui-combobox").each(function(index){
		$(this).combobox("setValue","");
	});
	$(obj).parent().parent().siblings().find(".easyui-combobox").filter(".flag").each(function(index){
		$(this).combobox("setValue","-1");
	});
}
/**
  *置空弹出框input text
  */
function resetWinData(obj){
	$(obj).parent().parent().siblings().find(".easyui-combobox").each(function(index){
		$(this).combobox("setValue","");
	});
	$(obj).parent().parent().siblings().find("input:text").not("[readonly]").each(function(index){
		$(this).val("");
	});
	$(obj).parent().parent().siblings().find("textarea").each(function(index){
		$(this).val("");
	});
}
/**
 *判断是否已登录，若未登录则跳转到login页面
 */
var ifLogin=function(){
	if($.session.get("userId")==null||$.session.get("userName")==""||$.session.get("userNickname")==undefined){
		return false;
	}else{
		return true;
	}
}

/**
 *遍历字符串，为拼SQL语句
 */
function getLocationStr(locationArr) {
    var locations = "";
    if (locationArr != undefined && locationArr != null && locationArr != "") {
        for (var i = 0; i < locationArr.length; i++) {
            if (i == locationArr.length - 1) {
                locations += "'" + locationArr[i] + "'";
            } else {
                locations += "'" + locationArr[i] + "',";
            }
        }
        return locations;
    }
    return locations;
}