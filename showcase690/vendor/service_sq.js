$(".zengjia,.caozuos").click(function(){

	$(".mengceng1").css("display","block")
	$(".tankuang").css("display","block")
})
$(".ss2 .qx,.chacha").click(function(){

	$(".mengceng1").css("display","none")
	$(".tankuang").css("display","none")
})

$(".po").click(function(){
	$(".tankuang0").css("display","block")
	$(".tankuang").css("opacity","0.7")
})
$(".ss .qx,.chacha").click(function(){
	$(".tankuang").css("opacity","1")
	$(".tankuang0").css("display","none")
})
$(".peizhi_z").click(function(){

	$(".peizhi_s").css("display","block")
})
function divScroll(scrollDiv){
    var scrollLeft = scrollDiv.scrollLeft;
    document.getElementById("tableDiv_title").scrollLeft = scrollLeft;
    document.getElementById("tableDiv_body").scrollLeft = scrollLeft;        
}
function divYScroll(scrollYDiv){
    var scrollTop = scrollYDiv.scrollTop;
    document.getElementById("tableDiv_y").scrollTop = scrollTop;    
}
function onwheel(event){
    var evt = event||window.event;
    var bodyDivY = document.getElementById("tableDiv_y");
    var scrollDivY = document.getElementById("scrollDiv_y");
    if (bodyDivY.scrollHeight>bodyDivY.offsetHeight){
        if (evt.deltaY){
            bodyDivY.scrollTop = bodyDivY.scrollTop + evt.deltaY*7;
            scrollDivY.scrollTop = scrollDivY.scrollTop + evt.deltaY*7;
        }else{
            bodyDivY.scrollTop = bodyDivY.scrollTop - evt.wheelDelta/5;
            scrollDivY.scrollTop = scrollDivY.scrollTop - evt.wheelDelta/5;
        }
    }
}

