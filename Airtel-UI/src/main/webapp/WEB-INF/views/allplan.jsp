<%@taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
</head>
<body>
<div align="center">
<img src="images/airtelogo.jpg" width="150" height="150">
<br>
<br>
<c:forEach   items="${plan1}"   var="emp">
              <tr>
                    <td>Plan Id : </td>
                    <td><c:out  value="${emp.planId}"/> </td>
                    <br>
              </tr> 
               <tr>
                    <td>Plan Name : </td>
                    <td><c:out  value="${emp.planName}"/></td>
                    <br>
              </tr>
               <tr>
                    <td>Validity : </td>
                    <td><c:out  value="${emp.validity}"/></td>
                    <br>
               </tr>
               <br>
               <br>
             
</c:forEach> 
<a href="logout"><img src="images/logout.png" width="100" height="100"></a>
</div>    
</body> 
</html>          