$(document).ready(function() {
  /*判断页面所占比例*/
$(function(){
	auto();
	})
	$(window).resize(function(){
auto();
	})
function auto(){
		var widthauto=$(window).width();
	var heightauto=$(window).height();
         $(".signinpanel").width(widthauto+'px');
	    $(".signinpanel").height(heightauto-53-95+'px');
	};  
});