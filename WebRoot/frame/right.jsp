<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
	<div align="center">
		<table border="0" width="60%" cellspacing="0" cellpadding="0" id="table1">
			<tr>
				<td height="93"></td>
			</tr>
			<tr>
				<td>
					<img src="${ pageContext.request.contextPath }/images/bg.jpg" style="background-repeat:no-repeat" width="1500px" height="600px">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>