<%@taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
</head>
<body>
<div align="center">
<img src="images/airtelogo.jpg" width="150" height="150">
<br>
<br>
<h1>
${message}
</h1>
<h3>
Welcome <c:out value="${sessionScope.num}"/>
</h3>
<table>
<tr>
<td><a href="viewprofile?phoneNo=${sessionScope.num}"><img src="images/viewprofile.png" width="100" height="100"></a> </td>
<td>&nbsp;&nbsp;<a href="addfriends?phoneNum=${sessionScope.num}"><img src="images/addfriend.jpg" width="100" height="100"></a></td>
<td>&nbsp;&nbsp;<a href="calldetail?phoneNo=${sessionScope.num}"><img src="images/calldetails.jpg" width="100" height="100"></a> </td>
</tr>
<tr>
<td><a href="changeplan?phoneNo=${sessionScope.num}"><img src="images/changeplans.jpg" width="100" height="100"></a></td>
<td>&nbsp; &nbsp;<a href="allplans"><img src="images/all.png" width="100" height="100"></a> </td>
<td>&nbsp; &nbsp;<a href="delete?phoneNo=${sessionScope.num}"><img src="images/delete.jpg" width="100" height="100"></a> </td>
</tr>

</table>

<a href="logout"><img src="images/logout.png" width="100" height="100"></a>
</div>    
</body> 
</html>     
