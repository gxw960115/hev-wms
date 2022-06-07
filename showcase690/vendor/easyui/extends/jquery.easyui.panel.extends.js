/*
 * 扩展panel属性
 * 实现panel中含有tbar
 */
$.fn.panel.defaults.customAtt ={
	tbar :{
		items: undefined
	}
}
function initTbar(target){
	var options = $.extend(true, {}, $.fn.panel.defaults, $(target).panel('options'));
	var tbar = options.customAtt.tbar;
	if(tbar){
		var body = $(target).panel('body');
		var items = tbar.items;
		var _toolDiv = '<div class="easyui-panel" style="padding:0px;">';
		var _count = 0;
		$.each(items,function(){
			if(_count != 0){
				_toolDiv += '<div class="datagrid-btn-separator"></div>';
			}
			_toolDiv += '<a href="#" class="easyui-linkbutton" iconCls="'+$(this)[0].iconCls+'"  plain="true" style="float: left" onClick="'+$(this)[0].handler+'()">'+$(this)[0].title+'</a>';
			_count++;
		});
		_toolDiv += '</div>';
		body.prepend(_toolDiv);
	}else{
		return;
	}
}
$.extend($.fn.panel.methods, {
        withToolBar: function(jq){
            return jq.each(function(){
                initTbar(this);
            });
        }
});