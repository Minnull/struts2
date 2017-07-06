<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <body>
        <h1>
            我的简易计算器
        </h1>
 
        <form name="form1" action="jisuanqi">
            请输入第一个数：
            <br>
            <input type="text" name="num1">
            <br>
            请选择运算符号：
            <br>
            <select name="flag">
                <option value=+>
                    +
                </option>
                <option value=->
                    -
                </option>
                <option value=*>
                    *
                </option>
                <option value= />
                    /
                </option>
            </select>
            <br>
            请输入第二个数：
            <br>
            <input type="text" name="num2">
            <br>
            <input type="submit" value="计算">
        </form>
        计算的结果是：<s:property value="result"/> 
     
 
    </body>
</html>