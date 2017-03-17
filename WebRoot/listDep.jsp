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
            width:auto;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
	<table border="0" width="1340">
		<tr>
		<td align="Left" style="font-size:24px; color:#999"> 部门管理</td>
		<td align="right"><a href="addDept.jsp">添加</a></td>
		</tr>
	</table>
	
	<br/>
	
		<table cellspacing="0" border="1" class="table1">
			<thead>
			   <tr><th width="450">部门名称</th><th  width="450">编辑</th></tr>
			</thead>
			<tbody>
			<s:iterator value="list" var="d">
				<tr>
					<td align="center"><s:property value="#d.dname"/></td>
					<td align="center" width="7%"><a href="addDept.jsp"><img src="${ pageContext.request.contextPath }/images/编辑.png"></img></a></td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
	<br/>
	
	
	<table border="0" cellspacing="0" cellpadding="0"  align="center">
	<tr>
	<td align="right">
	   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
	   <span>总记录数：<s:property value="totalCount"/>&nbsp;&nbsp;每页显示<s:property value="pageSize"/>条</span>&nbsp;&nbsp;
	   <span>
		   <s:if test="currPage != 1">
		       <a href="${ pageContext.request.contextPath }/department_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
		       <a href="${ pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
		   </s:if>
		   <s:if test="currPage != totalPage">
		       <a href="${ pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
		       <a href="${ pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
		   </s:if>
	   </span>
	</td>
	</tr>
	</table>
</body>
</html>