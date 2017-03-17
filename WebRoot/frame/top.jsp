<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<style type="text/css">
		.div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
	</style>
</head>

<body bgcolor="#0099FF">
	<div class="div1">
		欢迎您：<s:property value="#session.existEmployee.ename"/>
	</div>
</body>
</html>
