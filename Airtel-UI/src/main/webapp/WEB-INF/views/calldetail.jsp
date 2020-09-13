<%@taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
</head>
<body>
<div align="center">
<img src="images/airtelogo.jpg" width="150" height="150">
<br>
<br>
${message}; 
<br>
<c:forEach   items="${friend}"   var="emp">
              <tr>
                    <td> <h4> <c:out  value="${emp}"/> </h4> </td> <td> <a href="CallLog?phoneNumber=${emp}">View Log</a> </td>
                    <td> <br></td>     
              </tr>          
        </c:forEach>
        <a href="logout"><img src="images/logout.png" width="100" height="100"></a>
</div>    
</body> 
</html>     
