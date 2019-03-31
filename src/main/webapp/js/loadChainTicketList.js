$(function(){
	$.ajax({
		url:"chainTickets",
		type:"get",
		data:{},
		dataType:"json",
		success:function(data){
			 
	           alert("页面加载成功，显示链票list【" + data + "】");  
	           
		},
		eror:function(data){
			alert(data);  
		}
	});
});
