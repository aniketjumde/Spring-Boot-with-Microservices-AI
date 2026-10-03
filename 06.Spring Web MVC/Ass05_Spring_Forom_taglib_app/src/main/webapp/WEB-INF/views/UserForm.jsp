<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>

<body>
	
	<spring:form  modelAttribute="user" method="post" action="/register" >
			
			User Name: <spring:input type="text" path="userName" /> <br/>
			Email Id : <spring:input type="email" path="emailId" /> <br/>
			Mobile No: <spring:input type="text" path="mobileNo" /> <br/>
			Gender   : <spring:radiobutton path="gender" value="Male" label="Male" /> 
					   <spring:radiobutton path="gender" value="Female" label="Female" /> <br/>
					   
					   
	<input type="submit" value="Submit"/>  <br>
					   
	
	</spring:form>
	
	
</body>	

</html>
