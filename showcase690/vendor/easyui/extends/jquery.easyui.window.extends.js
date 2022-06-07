$.extend($.fn.window.methods,{ 
	 lineWindow :function(jq,para){
    	return jq.each(function(){
    		alert("window");
    	})
	 }
})