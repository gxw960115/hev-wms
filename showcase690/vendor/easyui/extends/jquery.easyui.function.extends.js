/**
 * JQuery扩展方法，用户对JQuery EasyUI的DataGrid控件进行操作。
 */
$.fn.extend({
			/**
			 * 修改DataGrid对象的默认大小，以适应页面宽度。
			 * 
			 */
			resizeDataGrid : function() {
				var height = $(document.body).height();
				var width = $(document.body).width();
				$(this).datagrid('resize', {
							height : height,
							width : width
						});
			}
		});
$.ajaxSetup({  
    contentType : "application/x-www-form-urlencoded;charset=utf-8",  
    complete : function(xhr, textStatus) {  
        //session timeout   
        if (xhr.status == 110) { 
            window.parent.location = "../../login.jsp";   
            return;  
        }  
    }  
});
$.extend({
			maskLoading : function() {
				$.messager.progress({
							title : 'Please Waiting',
							msg : 'Loading data...'
						});
			},
			maskEnd : function() {
				$.messager.progress('close');
			}
		});
function myformatter(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}
function myparser(s) {
	if (!s)
		return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0], 10);
	var m = parseInt(ss[1], 10);
	var d = parseInt(ss[2], 10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
		return new Date(y, m - 1, d);
	} else {
		return new Date();
	}
}
function gridScroll(grid) {
	grid.prev(".datagrid-view2").children(".datagrid-body")
			.html("<div style='width:"
					+ grid.prev(".datagrid-view2").find(".datagrid-header-row")
							.width()
					+ "px;border:solid 0px;height:1px;'></div>");
}
/**
 * EasyUI DataGrid根据字段动态合并单元格
 * 
 * @param tableID
 *            要合并table的id
 * @param colList
 *            要合并的列,用逗号分隔(例如："name,department,office");
 */
function mergeCellsByField(tableID, colList) {
	var ColArray = colList.split(",");
	var tTable = $('#' + tableID);
	var TableRowCnts = tTable.datagrid("getRows").length;
	var tmpA;
	var tmpB;
	var PerTxt = "";
	var CurTxt = "";
	var alertStr = "";
	var PerTxt_t = "";
	var CurTxt_t = "";
	for (j = ColArray.length - 1; j >= 0; j--) {
		PerTxt = "";
		PerTxt_t = "";
		tmpA = 1;
		tmpB = 0;
		if (j > 1) {
			for (i = 0; i <= TableRowCnts; i++) {
				if (i == TableRowCnts) {
					CurTxt = "";
					CurTxt_t = "";
				} else {
					CurTxt_t = tTable.datagrid("getRows")[i][ColArray[j-1]];
					CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
				}
				if (PerTxt == CurTxt && PerTxt_t == CurTxt_t) {
					tmpA += 1;
				} else {
					tmpB += tmpA;
					tTable.datagrid('mergeCells', {
								index : i - tmpA,
								field : ColArray[j],
								rowspan : tmpA,
								colspan : null
							});
					tmpA = 1;
				}
				PerTxt = CurTxt;
				PerTxt_t = CurTxt_t;
			}
		} else {
			for (i = 0; i <= TableRowCnts; i++) {
				if (i == TableRowCnts) {
					CurTxt = "";
				} else {
					CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
				}
				if (PerTxt == CurTxt) {
					tmpA += 1;
				} else {
					tmpB += tmpA;
					tTable.datagrid('mergeCells', {
								index : i - tmpA,
								field : ColArray[j],
								rowspan : tmpA,
								colspan : null
							});
					tmpA = 1;
				}
				PerTxt = CurTxt;
			}
		}

	}
}
$.extend($.fn.datagrid.methods, {
	    fixRownumber : function (jq) {
	        return jq.each(function () {
	            var panel = $(this).datagrid("getPanel");
	            //获取最后一行的number容器,并拷贝一份
	            var clone = $(".datagrid-cell-rownumber", panel).last().clone();
	            //由于在某些浏览器里面,是不支持获取隐藏元素的宽度,所以取巧一下
	            clone.css({
	                "position" : "absolute",
	                left : -1000
	            }).appendTo("body");
	            var width = clone.width("auto").width();
	            //默认宽度是25,所以只有大于25的时候才进行fix
	            if (width > 25) {
	                //多加5个像素,保持一点边距
	                $(".datagrid-header-rownumber,.datagrid-cell-rownumber", panel).width(width + 5);
	                //修改了宽度之后,需要对容器进行重新计算,所以调用resize
	                $(this).datagrid("resize");
	                //一些清理工作
	                clone.remove();
	                clone = null;
	            } else {
	                //还原成默认状态
	                $(".datagrid-header-rownumber,.datagrid-cell-rownumber", panel).removeAttr("style");
	            }
	        });
	    }
	});
