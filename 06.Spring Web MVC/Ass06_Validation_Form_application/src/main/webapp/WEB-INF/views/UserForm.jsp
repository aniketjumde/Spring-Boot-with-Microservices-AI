<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
	

<body>
	
	<spring:form modelAttribute="user"  method="post" action="/register">
		
		User Name :<spring:input type="text" path="userName" /> 
					<spring:errors path="userName" cssStyle="color:red" /> <br/>
				   
		Email Id  :<spring:input type="text" path="emailId" /> 
				   <spring:errors path="emailId" cssStyle="color:red" /> <br/>
				
		
		Mobile No :<spring:input type="text" path="mobileNo" /> 
				   <spring:errors path="mobileNo" cssStyle="color:red" /> <br/>
			
		
		Gender    :<spring:radiobutton path="gender" value="Male" label="Male" /> 
				   <spring:radiobutton path="gender" value="Female" label="Female" /> 
				   <spring:errors path="gender" cssStyle="color:red" />  <br/>
				   
				   
		Birth date:<spring:input type="date" path="birthDate"/>
				   <spring:errors path="birthDate" cssStyle="color:red" /> <br/>
				   <input type="submit" value="Submit"/>  <br/>

		
	</spring:form>
	
	
</body>


</html>


