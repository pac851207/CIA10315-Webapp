<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.petSitterServiceItem.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	PetSitterServiceItemService petSitterServiceItemSvc = new PetSitterServiceItemService();
    List<PetSitterServiceItemVO> list = petSitterServiceItemSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllPetSitterServiceItem.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有員工資料 - listAllPetSitterServiceItem.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="<%= request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>服務項目編號</th>
		<th>服務項目描述</th>
		<th>服務項目名稱</th>
<!-- 		<th>雇用日期</th> -->
<!-- 		<th>薪水</th> -->
<!-- 		<th>獎金</th> -->
<!-- 		<th>部門</th> -->
		<th>修改</th>
<!-- 		<th>刪除</th> -->
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="petSitterServiceItemVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${petSitterServiceItemVO.svcId}</td>
			<td>${petSitterServiceItemVO.svcDescr}</td>
			<td>${petSitterServiceItemVO.svcName}</td>
<%-- 			<td>${empVO.hiredate}</td> --%>
<%-- 			<td>${empVO.sal}</td> --%>
<%-- 			<td>${empVO.comm}</td>  --%>
<%-- 			<td>${empVO.deptno}</td> --%>
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/petSitterServiceItem/petSitterServiceItem.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="svcId"  value="${petSitterServiceItemVO.svcId}">
			     <input type="hidden" name="svcDescr"  value="${petSitterServiceItemVO.svcDescr}">
			     <input type="hidden" name="svcName"  value="${petSitterServiceItemVO.svcName}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/petSitterServiceItem/petSitterServiceItem.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="svcId"  value="${petSitterServiceItemVO.svcId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>