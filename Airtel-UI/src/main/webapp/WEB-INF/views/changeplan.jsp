<%@taglib  uri="http://www.springframework.org/tags/form"   prefix="form"%>
<html>
<head>
</head>
<body>
<div align="center">
<img src="images/airtelogo.jpg" width="150" height="150">
<br>
<br>
<form:form  action="updated"  method="post"  modelAttribute="dto1">
  <table>
     <tr>
          <td>Phone Number : </td> <td> <form:input  path="phoneNo" readOnly="true"/> </td>
     </tr>
     <tr>
          <td>Plan ID: </td> <td> <form:select path="planId"> 
          <form:options items="${dto1.planList}"/>
          </form:select>
          </td>
     </tr>
     <tr>
          <td  colspan="2"  align="center">
                <input  type="submit"   value="Change">
          </td>
     </tr>     
  </table>
  </form:form>
  <a href="logout"><img src="images/logout.png" width="100" height="100"></a>
</div>    
</body> 
</html>     
