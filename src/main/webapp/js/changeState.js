var obj={0:"审核中",1:"审核未通过",2:"待签收",3:"正常流转",4:"正常结算",5:"逾期未结算",6:"死亡"};
		var tab=document.getElementsByTagName("table")[0];
		for(var i=1;i<tab.rows.length;i++){
			var str=tab.rows[i].cells[5].innerHTML;
			tab.rows[i].cells[5].innerHTML=obj[str];
		}