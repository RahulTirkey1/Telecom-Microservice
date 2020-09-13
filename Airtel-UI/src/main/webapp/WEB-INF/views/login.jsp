<%@taglib  uri="http://www.springframework.org/tags/form"   prefix="form"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
</head>
<body>
<div align="center">
<img src="images/airtelogo.jpg" width="150" height="150">
<br>
<c:if  test="${message ne null }">
      <c:out  value="${message}"/>
  </c:if>
<br>
<form:form  action="loginsave"  method="post"  modelAttribute="use">
  <table>
     <tr>
          <td>Phone Number : </td> <td> <form:input  path="phoneNo"/> </td>
     </tr>
     <tr>
          <td>Password : </td> <td> <form:input  path="password"/> </td>
     </tr>
          <tr>
          <td  colspan="2"  align="center">
                <input  type="submit"   value="Submit">
          </td>
     </tr>     
  </table>

</form:form>
</div>    
</body> 
</html>     
