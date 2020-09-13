<%@taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
</head>
<body>
<div align="center">
<img src="images/airtelogo.jpg" width="150" height="150">
<br>
<br>
<c:if  test="${message ne null }">
    <font color="red"> Reason: <c:out value="${message}"/></font>
</c:if>


<h3>
Welcome <c:out value="${sessionScope.num}"/>
</h3>

<table>
     <tr>
          <td>Name : </td> <td> &nbsp; ${dt1.name}</td>
     </tr>
     <tr>
          <td>Phone Number : </td> <td> &nbsp; ${dt1.phoneNo} </td>
     </tr>
     
     <tr>
          <td> Plan Id : </td> <td> &nbsp; ${dt1.planId} </td> 
          
     </tr>      
         <tr>
    
         <td> <h3>The Current Plan details are : </h3></td>          
     </tr>
     <tr>
        <td> &nbsp; &nbsp;Plan Id:</td> <td> &nbsp; ${planned.planId} </td>
     </tr>
     
     <tr>
        <td> &nbsp; &nbsp;Plan Name:</td> <td> &nbsp; ${planned.planName} </td>
     </tr>
     
     <tr>
        <td> &nbsp; &nbsp;Plan Validity:</td> <td> &nbsp; ${planned.validity} </td>
     </tr>
    </table>
    
    <br>
<a href="logout"><img src="images/logout.png" width="100" height="100"></a>
</div>    
</body> 
</html>     
