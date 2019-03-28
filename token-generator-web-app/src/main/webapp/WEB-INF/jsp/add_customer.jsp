<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
${error}

	<form method="post">
		<p>
			Customer Name: <input type="text" name="custName" />
		</p>
		<p>
			Primary Customer: <input type="checkbox" name="primaryCustomer" />
		</p>
		<input type="submit" value="Add" />
	</form>
	
	</div>
<%@ include file="common/footer.jspf" %>