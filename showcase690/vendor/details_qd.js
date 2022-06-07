$(".mengceng").click(function(){

	$(".mengceng1").css("display","block")
	$(".tankuang").css("display","block")
})
$(".btn_xiao .qx,.chacha").click(function(){

	$(".mengceng1").css("display","none")
	$(".tankuang").css("display","none")
})
		$(function(){
				    $(".bianjis").click(function() {
				  
				        str = $(this).val()=="编辑"?"确定":"编辑";  
				        $(this).val(str);   // 按钮被点击后，在“编辑”和“确定”之间切换
				        $(this).parent().siblings("td").each(function() {  // 获取当前行的其他单元格
				            obj_text = $(this).find("input:text");    // 判断单元格下是否有文本框
				            if(!obj_text.length)   // 如果没有文本框，则添加文本框使之可以编辑
				                $(this).html("<input type='text' value='"+$(this).text()+"'>");
				            else   // 如果已经存在文本框，则将其显示为文本框修改的值
				                $(this).html(obj_text.val()); 
				        });
				    });
				}); 