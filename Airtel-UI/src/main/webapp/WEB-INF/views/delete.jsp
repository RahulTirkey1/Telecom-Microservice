<%@taglib  uri="http://www.springframework.org/tags/form"   prefix="form"%>
<html>
<head>
</head>
<body>
<div align="center">
<img src="images/airtelogo.jpg" width="150" height="150">
<br>
<br>
<h3>Delete A Friend:-</h3>
<form:form  action="deletedfriend"  method="post"  modelAttribute="deleted">
  <table>
     <tr>
          <td>Phone Number : </td> <td> <form:input  path="phoneNo"  readonly="true" /> </td>
     </tr>
     <tr>
          <td>Friend Number: </td> <td> <form:select  path="friendNo">
          <form:options  items="${deleted.friends}"/>
         </form:select>
           </td>
           <tr>
          <td  colspan="2"  align="center">
                <input  type="submit"   value="Delete Friend">
          </td>
     </tr>     
  </table>

</form:form>
<a href="logout"><img src="images/logout.png" width="100" height="100"></a>
</div>    
</body> 
</html>     
