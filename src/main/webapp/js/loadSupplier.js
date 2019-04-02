$(function(){
	$.ajax({
		url:"getSupplierList",
		type:"get",
		data:{},
		dataType:"json",
		success:function(data){
//			alert("返回数据--【" + data.length + "】");
//			alert("返回数据--【" + data[0].id + "】---"+data[0].name);
			var area = document.getElementsByTagName("select")[0];
            var optionstring = "";   
			 if (data.length > 0){
				   for (var i = 0; i < data.length; i++) {                   
				        optionstring += "<option value=" + data[i].id + ">" + data[i].name + "</option>"; //公共变量赋值
				   }
			}
			 if (area.options.length==0) {                 //如果下拉框没有数据才进行加载
				   $('#applicant').html(optionstring);   //下拉框加载数据
//				   $('#enterpriseSelect').selectpicker('refresh');
			} 	             
		},
		eror:function(data){
			alert("额度获取失败，失败原因【" + data + "】");  
		}
	});
});
