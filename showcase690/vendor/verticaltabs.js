function verticaltabs(container){
	
	var navBox = container.find('.tabTagBox'), 
		navList = container.find('.tabTagList'), 
		navs = navList.children('li'), 
		upBtn = container.find('.uPrev'), 
		downBtn = container.find('.dNext'), 
		tabItems = container.find(".tab-item"), 
		contentBoxs = container.find('.tab-panel');
	
	var opts = {
		moveH: 41,
		moveSpeed: 200,
		curMoveH: 0,
		curSumH: 0,
		curNavIndex: 0
	}
	
	opts.curSumH = (opts.moveH * navs.size()) - navBox.height();
	
	
	var navMove = function () {
		
		var _arg = arguments.length > 0 ? arguments[0] : '';
		
		if(opts.curSumH <=0){return false;}
		
		if (_arg === 'up') {
			if (-opts.curSumH === opts.curMoveH) {
				alert('到头了');
				return;
			}
			opts.curMoveH -= opts.moveH;
			opts.curNavIndex += 1;
		}
		
		if (_arg === 'down') {
			if (opts.curMoveH === 0) {
				alert('到头了');
				return;
			}
			opts.curMoveH += opts.moveH;
			opts.curNavIndex -= 1;
		}
		
		if(opts.curMoveH<0){
			if(Math.abs(opts.curMoveH)>opts.curSumH){
				opts.curMoveH = -opts.curSumH;
			}
		}else{
			if(opts.curMoveH>0){
				opts.curMoveH = 0;
			}
		}
		
		navList.animate({ top: opts.curMoveH + 'px' }, opts.moveSpeed);
	};
	
	upBtn.click(function () {
		navMove('down');
	});
	
	downBtn.click(function () {
		navMove('up');
	});
	
	
	container.on("click","[data-panel]",function(){
		//opts.curNavIndex = $(this).index();
		var el = $(this);
		var id = el.attr("data-panel");
		var level3menu = el.closest(".tabshow-level3menu");
		var level3menuId = level3menu.attr("id");
		contentBoxs.hide();
		container.find("#"+id).show();
		
		navs.removeClass('current');
		if(level3menuId){
			container.find("#"+level3menuId.replace("-menu","")).addClass('current');
			level3menu.css({visibility: "hidden"});
		}else{
			$(this).addClass('current');
		}
	});
	tabItems.on("mouseenter",function(){
		var el = $(this);
		var id = el.attr("id");
		container.find(".tabshow-level3menu").css({visibility: "hidden"});
		if(id){
			var level3menu = container.find("#"+id+"-menu");
			var pos = el.position();
			level3menu.css({top:pos.top+navList.position().top+35,visibility: "visible"});
		}
	}).on("mouseleave",function(){
		var el = $(this);
		var id = el.attr("id");
		if(id){
			var level3menu = container.find("#"+id+"-menu");
			var pos = el.position();
			//level3menu.css({top:pos.top+35,visibility: "hidden"});
		}
	});
	
	
	container.on("mouseleave",".tabshow-level3menu",function(){
		$(this).css({visibility: "hidden"});
	});
	
}