$(function(){
	$.ajax({
		url:"memberEnterprise/queryLimit",
		type:"get",
		data:{},
		dataType:"json",
		success:function(data){
			 if(data.limitResult!=null){   
	                $("#limitResult").text(data.limitResult);
	            }else{  
	                alert("额度获取失败，失败原因【" + data + "】");  
	            }  
		},
		eror:function(data){
			alert(data.limitResult);  
		}
	});
});

function queryLimit(){
	$.ajax({
		url:"memberEnterprise/queryLimit",
		type:"get",
		data:{},
		dataType:"json",
		success:function(data){
			 if(data.limitResult!=null){  
	                $("#limitResult").text(data.limitResult);
	            }else{  
	                alert("额度获取失败，失败原因【" + data + "】");  
	            }  
		},
		eror:function(data){
			alert(data.limitResult);  
		}
	});
}