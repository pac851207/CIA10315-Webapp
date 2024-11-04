<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.petSitterServiceItem.model.*"%>

<% //見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
PetSitterServiceItemVO petSitterServiceItemVO = (PetSitterServiceItemVO) request.getAttribute("petSitterServiceItemVO");
%>
--<%= petSitterServiceItemVO == null %>--${petSitterServiceItemVO.svcId}--<!-- line 100 -->
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料新增 - addPetSitterServiceItem.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>員工資料新增 - addPetSitterServiceItem.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="petSitterServiceItem.do" name="form1">
<table>
	
	
	
	
<!-- 	<tr> -->
<!-- 		<td>員工姓名:</td> -->
<%-- 		<td><input type="TEXT" name="svcId" value="<%= (petSitterServiceItemVO==null)? "吳永志" : petSitterServiceItemVO.getSvcId()%>" size="45"/></td> --%>
<!-- 	</tr> -->
	<tr>
		<td>服務項目敘述:</td>
		<td><input type="TEXT" name="svcDescr"   value="<%= (petSitterServiceItemVO==null)? "敘述" : petSitterServiceItemVO.getSvcDescr()%>" size="45"/></td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td>雇用日期:</td> -->
<!-- 		<td><input name="hiredate" id="f_date1" type="text" ></td> -->
<!-- 	</tr> -->
	<tr>
		<td>服務項目名稱:</td>
		<td><input type="TEXT" name="svcName"   value="<%= (petSitterServiceItemVO==null)? "名稱" : petSitterServiceItemVO.getSvcName()%>" size="45"/></td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td>獎金:</td> -->
<%-- 		<td><input type="TEXT" name="comm"  value="<%= (empVO==null)? "100" : empVO.getComm()%>" size="45"/></td> --%>
<!-- 	</tr> -->

	<jsp:useBean id="petSitterServiceItemSvc" scope="page" class="com.petSitterServiceItem.model.PetSitterServiceItemService" />
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>





</html>