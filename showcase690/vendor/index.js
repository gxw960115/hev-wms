$(function(){ 
    $(".personal").hover(function(){
        $(".personal_li").toggle();
    })
    $('.gridly').gridly({
			base: 80, // px 
			gutter: 7, // px
			columns: 12
		});
		$(".gridly .panel-tool-close").on("click", function(event) {
			var $this;
			event.preventDefault();
			event.stopPropagation();
			$this = $(this);
			$this.closest('.brick').remove();
			return $('.gridly').gridly('layout');
		});
		$(".gridly .panel-tool-max").on("click", function(event) {
			var $this, width, height;
			event.preventDefault();
			event.stopPropagation();
			$this = $(this).parent().parent().parent().parent();
			$this.toggleClass('large');
			$this.toggleClass('big');
			if ($this.hasClass('large')) {
				width = 328;
				height = 376;
				$this.find(".panel").find(".panel-body").css({
					"height": 310
				});
				try {
					$this.find(".panel").find(".panel-body").find("div").highcharts().setSize(310, 300);
				} catch (w) {}
			}
			if ($this.hasClass('big')) {
				width = 1030;
				height = 676;
				$this.find(".panel").find(".panel-body").css({
					"height": 610
				});
				try {
					$this.find(".panel").find(".panel-body").find("div").highcharts().setSize(1000, 610);
				} catch (w) {}
			}
			$this.data('width', width);
			$this.data('height', height);
			return $('.gridly').gridly('layout');
		});
		$(document).on("click", ".add", function(event) {
			var brick = '<div class="brick large"><div class="panel panel-default"><div class="panel-header panel-header-noborder panel-heading">	<div class="panel-title panel-with-icon">信用数据分析</div><div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-max"></a><a href="javascript:void(0)" class="panel-tool-close"></a></div></div><div class="panel-body" style="height:310px"><div id="container4" style="width: 100%; height: 300px;"></div></div></div></div>';
			//alert();
			event.preventDefault();
			event.stopPropagation();
			$('.gridly').append(brick);
			$(".gridly .panel-tool-close").on("click", function(event) {
				var $this;
				event.preventDefault();
				event.stopPropagation();
				$this = $(this);
				$this.closest('.brick').remove();
				return $('.gridly').gridly('layout');
			});
			
			return $('.gridly').gridly();
		});
		var iss = true;
		var shownav = function() {
			if (iss) {
				$("#dvDockList").css({
					"width": 696,
					"height": 311,
					"border": "1px solid #ddd"
				});
				iss = false;
			} else {
				$("#dvDockList").css({
					"width": 0,
					"height": 0,
					"border": "0px solid #ddd"
				});
				iss = true;
			}
		}
		var $el = $("#show1");
		$el.click(function(e) {
			e.stopPropagation();
			//$(this).toggleClass('active');
		});
		var $el1 = $("#dvDockList1");
		$el1.click(function(e) {
			e.stopPropagation();
			//$(this).toggleClass('active');
		});
		var $el22 = $("#show2");
		$el22.click(function(e) {
			e.stopPropagation();
			//$(this).toggleClass('active');
		});
		var $el22 = $("#dvDockList");
		$el22.click(function(e) {
			e.stopPropagation();
			//$(this).toggleClass('active');
		});
		$(document).on('click', function(e) {
			console.log($(e.target));
			if (($(e.target) != $el)||($(e.target) != $$el1)) {
				//$el.removeClass('active');
				// console.log("yes");
				$("#dvDockList1").css({
				"width": 0,
				"height": 0,
				"border": "0px solid #ddd"
			});
			iss1 = true;
			}
			if (($(e.target) != $el22)||($(e.target) != $$el22)) {
				//$el.removeClass('active');
				// console.log("yes");
				$("#dvDockList").css({
				"width": 0,
				"height": 0,
				"border": "0px solid #ddd"
			});
			iss = true;
			}
		});
    lanrenzhijia(".drop-menu-effect");
    function lanrenzhijia(_this){
		$(_this).each(function(){
			var $this = $(this);
			var theMenu = $this.find(".submenu");
			var tarHeight = theMenu.height();
			theMenu.css({height:0});
			$this.hover(
				function(){
					$(this).addClass("mj_hover_menu");
					theMenu.stop().show().animate({height:tarHeight},400);
				},
				function(){
					$(this).removeClass("mj_hover_menu");
					theMenu.stop().animate({height:0},400,function(){
						$(this).css({display:"none"});
					});
				}
			);
		});
	}

})
