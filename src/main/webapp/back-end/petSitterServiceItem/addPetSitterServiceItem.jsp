<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.petSitterServiceItem.model.*"%>

<% //��com.emp.controller.EmpServlet.java��238��s�Jreq��empVO���� (������J�榡�����~�ɪ�empVO����)
PetSitterServiceItemVO petSitterServiceItemVO = (PetSitterServiceItemVO) request.getAttribute("petSitterServiceItemVO");
%>
--<%= petSitterServiceItemVO == null %>--${petSitterServiceItemVO.svcId}--<!-- line 100 -->
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>���u��Ʒs�W - addPetSitterServiceItem.jsp</title>

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
		 <h3>���u��Ʒs�W - addPetSitterServiceItem.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/images/tomcat.png" width="100" height="100" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��Ʒs�W:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="petSitterServiceItem.do" name="form1">
<table>
	
	
	
	
<!-- 	<tr> -->
<!-- 		<td>���u�m�W:</td> -->
<%-- 		<td><input type="TEXT" name="svcId" value="<%= (petSitterServiceItemVO==null)? "�d�ç�" : petSitterServiceItemVO.getSvcId()%>" size="45"/></td> --%>
<!-- 	</tr> -->
	<tr>
		<td>�A�ȶ��رԭz:</td>
		<td><input type="TEXT" name="svcDescr"   value="<%= (petSitterServiceItemVO==null)? "�ԭz" : petSitterServiceItemVO.getSvcDescr()%>" size="45"/></td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td>���Τ��:</td> -->
<!-- 		<td><input name="hiredate" id="f_date1" type="text" ></td> -->
<!-- 	</tr> -->
	<tr>
		<td>�A�ȶ��ئW��:</td>
		<td><input type="TEXT" name="svcName"   value="<%= (petSitterServiceItemVO==null)? "�W��" : petSitterServiceItemVO.getSvcName()%>" size="45"/></td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td>����:</td> -->
<%-- 		<td><input type="TEXT" name="comm"  value="<%= (empVO==null)? "100" : empVO.getComm()%>" size="45"/></td> --%>
<!-- 	</tr> -->

	<jsp:useBean id="petSitterServiceItemSvc" scope="page" class="com.petSitterServiceItem.model.PetSitterServiceItemService" />
<!-- 	<tr> -->
<!-- 		<td>����:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>

</body>





</html>