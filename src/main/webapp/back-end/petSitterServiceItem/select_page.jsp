<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM PetSitterServiceItem: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>�O���A���`��</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM PetSitterServiceItem: Home</p>

<h3>�q��d��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllPetSitterServiceItem.jsp'>List</a> all PetSitterServiceItems.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="petSitterServiceItem.do" >
        <b>��J�q��s�� (�p1):</b>
        <input type="text" name="svcId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="petSitterServiceItemSvc" scope="page" class="com.petSitterServiceItem.model.PetSitterServiceItemService" />
   
  <li>
     <FORM METHOD="post" ACTION="petSitterServiceItem.do" >
       <b>��ܭq��s��:</b>
       <select size="1" name="svcId">
         <c:forEach var="petSitterServiceItemVO" items="${petSitterServiceItemSvc.all}" > 
          <option value="${petSitterServiceItemVO.svcId}">${petSitterServiceItemVO.svcId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="petSitterServiceItem.do" >
       <b>��ܪA�ȶ���:</b>
       <select size="1" name="svcId">
         <c:forEach var="petSitterServiceItemVO" items="${petSitterServiceItemSvc.all}" > 
          <option value="${petSitterServiceItemVO.svcId}">${petSitterServiceItemVO.svcName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>�q��޲z</h3>

<ul>
  <li><a href='addPetSitterServiceItem.jsp'>Add</a> a new PetSitterServiceItem.</li>
</ul>

</body>
</html>