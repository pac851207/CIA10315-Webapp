<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.petSitterServiceItem.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
PetSitterServiceItemVO petSitterServiceItemVO = (PetSitterServiceItemVO) request.getAttribute("petSitterServiceItemVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>���u��� - listOnePetSitterServiceItem.jsp</title>

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
	width: 600px;
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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>���u��� - listOnePetSitterServiceItem.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�A�ȶ��ؽs��</th>
		<th>�A�ȶ��رԭz</th>
		<th>�A�ȶ��ئW��</th>
<!-- 		<th>���Τ��</th> -->
<!-- 		<th>�~��</th> -->
<!-- 		<th>����</th> -->
<!-- 		<th>����</th> -->
	</tr>
	<tr>
		<td><%=petSitterServiceItemVO.getSvcId()%></td>
		<td><%=petSitterServiceItemVO.getSvcDescr()%></td>
		<td><%=petSitterServiceItemVO.getSvcName()%></td>
<%-- 		<td><%=empVO.getHiredate()%></td> --%>
<%-- 		<td><%=empVO.getSal()%></td> --%>
<%-- 		<td><%=empVO.getComm()%></td> --%>
<%-- 		<td><%=empVO.getDeptno()%></td> --%>
	</tr>
</table>

</body>
</html>