<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
${error}

	<form method="post">
		<p>
			Customer ID: <input type="text" name="custId" />
		</p>
		    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
		<input type="submit" value="Get Customer Details" />
	</form>
	<a type="button" class="btn btn-warning" href="/add-customer">Add New Customer</a>
	
	
	</div>
<%@ include file="common/footer.jspf" %>