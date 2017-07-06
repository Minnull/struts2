<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>js简单计算器</title> 
<style type="text/css"> 
body{ 
font-size:12px; 
color:#333; 
} 
#jsq input{/*输入框样式*/ 
border:#ccc 1px solid; 
border-right:#e2e2e2 1px solid; 
border-bottom:#e2e2e2 1px solid; 
height:18px; 
line-height:18px; 
padding:3px; 
} 
#jsq span{ 
color:#999 
} 
#jsq input.btn{/*按钮样式*/ 
border:#e6e6e6 1px solid; 
background-color:#e2e2e2; 
width:30px; 
height:24px; 
text-align:center; 
line-height:16px; 
cursor:pointer; 
margin:0 3px; 
color:#999; 
} 
#jsq input.btn:hover{/*按钮悬浮样式*/ 
border:#e2e2e2 1px solid; 
background-color:#f2f2f2; 
color:#333; 
} 
</style> 
<script type="text/javascript"> 
function imyeah(type){ //计算函数 
var result=0; 
num1 = Number(document.jisuanqi.num1.value); //Number()可以吧字符串强制转换成数字，例如“123abc”会转换成“123” 
num2 = Number(document.jisuanqi.num2.value); 
if(num1=="" || num2==""){return false;} //如果没输入计算数则不执行 
switch(type){ //判断要执行的计算符号 
case 0:result=num1+num2;break; //计算“+” 
case 1:result=num1-num2;break; //计算“-” 
case 2:result=num1*num2;break; 
case 3:result=num1/num2;break; 
case 4:result=num1%num2;break; 
} 
document.jisuanqi.jieguo.value=result; //显示计算结果 
} 
</script> 
</head> 
<body> 
<form name="jisuanqi" id="jsq" action="" method="get" /> 
<p> 第一个数： 
<input type="text" size="10" name="num1" value="" /> 
</p> 
<p> 第二个数： 
<input type="text" size="10" name="num2" value="" /> 
</p> 
<p> 计算结果： 
<input type="text" size="10" name="jieguo" onClick="imyeah(0)" value="+" onfocus="this.select()" /> <span>左键"+",右键"选中复制"</span> 
</p> 
<p> 
<input type="button" class="btn" value="–" onClick="imyeah(1)"/> <!--定义按钮--> 
<input type="button" class="btn" value="×" onClick="imyeah(2)"/ > 
<input type="button" class="btn" value="÷" onClick="imyeah(3)"/> 
<input type="button" class="btn" value="%" onClick="imyeah(4)"/> 
</p> 
</body> 
</html> 
