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
        .table1{
            border:1px solid #ddd;
            width: 1340px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
	<table border="0" width="1340px">
		<tr>
			<td align="Left" style="font-size:24px; color:#666"> 员工管理</td>
			<td align="right" > <a href="addEmployee.jsp">添加</a></td>
		</tr>
	</table>
	<br/>
	<table cellspacing="0" border="1" class="table1">
		<thead>
			  <tr>
				<td align="center">编号</td>
				<td align="center">员工姓名</td>
				<td align="center">性别</td>
				<td align="center">出生日期</td>
				<td align="center">入职时间</td>
				<td align="center">所属部门</td>
				<td align="center">编辑</td>
			 </tr>
		</thead>
	<tbody>
		<s:iterator value="list" var="d">
			<tr>
				<td align="center"><s:property value="#d.eno"/></td>
				<td align="center"><s:property value="#d.ename"/></td>
				<td align="center"><s:property value="#d.sex"/></td>
				<td align="center"><s:date name="#d.birthday" format="yyyy-MM-dd"/></td>
				<td align="center"><s:date name="#d.joinDate" format="yyyy-MM-dd"/></td>
				<td align="center"><s:property value="#d.department.dname"/></td>
				<td align="center"><a href="editEmployee.jsp"><img src="${ pageContext.request.contextPath }/images/编辑.png"/></a></td>
			</tr>
		</s:iterator>
	</tbody>
	</table>
	<br/>

	<table border="0" cellspacing="0" cellpadding="0"  width="900px">
		<tr>
			<td align="right">
			   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
			    <span>总记录数：<s:property value="totalCount"/>&nbsp;&nbsp;每页显示<s:property value="pageSize"/>条</span>&nbsp;&nbsp;
			   <span>
			   	<s:if test="currPage != 1">
			       <a href="${ pageContext.request.contextPath }/employee_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
			       <a href="${ pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
			    </s:if>
			    <s:if test="currPage != totalPage">
			       <a href="${ pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
			       <a href="${ pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[尾页]</a>&nbsp;&nbsp;
			  	</s:if>
			   </span>
			</td>
		</tr>
	</table>
</body>
</html>