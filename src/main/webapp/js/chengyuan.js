var limitquery=document.getElementById("limitquery");
var ctquery=document.getElementById("ctquery");
var drawct=document.getElementById("drawct");
var qyInforManage=document.getElementById("qyInforManage");
var qyUserManage=document.getElementById("qyUserManage");
var bankManage=document.getElementById("bankManage");
var sureInforManage=document.getElementById("sureInforManage");
var supply=document.getElementById("supply");

var limitqueryPage=document.getElementById("limitquery-page");
var ctqueryPage=document.getElementById("ctquery-page");
var drawctPage=document.getElementById("drawct-page");
var qyInforManagePage=document.getElementById("qyInforManage-page");
var qyUserManagePage=document.getElementById("qyUserManage-page");
var bankManagePage=document.getElementById("bankManage-page");
var sureInforManagePage=document.getElementById("sureInforManage-page");
var supplyPage=document.getElementById("supply-page");

limitquery.onclick=function(){
	limitqueryPage.style.display="block";
	ctqueryPage.style.display="none";
	drawctPage.style.display="none";
	qyInforManagePage.style.display="none"
	qyUserManagePage.style.display="none";
	bankManagePage.style.display="none";
	sureInforManagePage.style.display="none";
	supplyPage.style.display="none";
}
ctquery.onclick=function(){
	limitqueryPage.style.display="none";
	ctqueryPage.style.display="block";
	drawctPage.style.display="none";
	qyInforManagePage.style.display="none"
	qyUserManagePage.style.display="none";
	bankManagePage.style.display="none";
	sureInforManagePage.style.display="none";
	supplyPage.style.display="none";
}
drawct.onclick=function(){
	limitqueryPage.style.display="none";
	ctqueryPage.style.display="none";
	drawctPage.style.display="block";
	qyInforManagePage.style.display="none"
	qyUserManagePage.style.display="none";
	bankManagePage.style.display="none";
	sureInforManagePage.style.display="none";
	supplyPage.style.display="none";
}

qyInforManage.onclick=function(){
	limitqueryPage.style.display="none";
	ctqueryPage.style.display="none";
	drawctPage.style.display="none";
	qyInforManagePage.style.display="block"
	qyUserManagePage.style.display="none";
	bankManagePage.style.display="none";
	sureInforManagePage.style.display="none";
	supplyPage.style.display="none";
}
qyUserManage.onclick=function(){
	limitqueryPage.style.display="none";
	ctqueryPage.style.display="none";
	drawctPage.style.display="none";
	qyInforManagePage.style.display="none"
	qyUserManagePage.style.display="block";
	bankManagePage.style.display="none";
	sureInforManagePage.style.display="none";
	supplyPage.style.display="none";
}
bankManage.onclick=function(){
	limitqueryPage.style.display="none";
	ctqueryPage.style.display="none";
	drawctPage.style.display="none";
	qyInforManagePage.style.display="none"
	qyUserManagePage.style.display="none";
	bankManagePage.style.display="block";
	sureInforManagePage.style.display="none";
	supplyPage.style.display="none";
}
sureInforManage.onclick=function(){
	limitqueryPage.style.display="none";
	ctqueryPage.style.display="none";
	drawctPage.style.display="none";
	qyInforManagePage.style.display="none"
	qyUserManagePage.style.display="none";
	bankManagePage.style.display="none";
	sureInforManagePage.style.display="block";
	supplyPage.style.display="none";
}
supply.onclick=function(){
	limitqueryPage.style.display="none";
	ctqueryPage.style.display="none";
	drawctPage.style.display="none";
	qyInforManagePage.style.display="none"
	qyUserManagePage.style.display="none";
	bankManagePage.style.display="none";
	sureInforManagePage.style.display="none";
	supplyPage.style.display="block";
}
