<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>首页</title>
</head>
<body>
<s:form action="login" method="post" namespace="/">
<s:textfield name="username" label="用户名"/>
<s:password name="userpwd" label="密码"/>
<s:submit label="登录"/>
</s:form>
</body>
</html>