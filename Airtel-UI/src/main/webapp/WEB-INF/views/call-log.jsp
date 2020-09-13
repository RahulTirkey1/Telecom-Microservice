<%@taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
</head>
<body>
<div align="center">
<img src="images/airtelogo.jpg" width="150" height="150">
<br>
<br>
<c:forEach   items="${call}"   var="emp">
              <tr>
                    <td>Specific Call Id : </td>
                    <td><c:out  value="${emp.callId}"/> </td>
                    <br>
              </tr>   
              <tr>
                    <td>Called By : </td>
                    <td><c:out  value="${emp.calledBy}"/> </td>
                    <br>
              </tr>   
              <tr>
                    <td>Called To : </td>
                    <td><c:out  value="${emp.calledTo}"/> </td>
                    <br>
              </tr>   
              <tr>
                    <td>Called On : </td>
                    <td><c:out  value="${emp.calledOn}"/> </td>
                    <br>
              </tr>   
              <tr>
                    <td>Duration : </td>
                    <td><c:out  value="${emp.duration}"/> </td>
                    <br>
              </tr>
              
              <br>          
        </c:forEach>
        <a href="logout"><img src="images/logout.png" width="100" height="100"></a>
</div>    
</body> 
</html>   