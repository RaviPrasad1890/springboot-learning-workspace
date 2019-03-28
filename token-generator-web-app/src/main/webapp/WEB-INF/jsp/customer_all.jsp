<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Customer Details</caption>
		<thead>
			<tr>
				<th>Customer Id</th>
				<th>Name</th>
				<th>Primary Customer</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="cust">
				<tr>
					<td>${cust.custId}</td>
					<td>${cust.custName}</td>
					<td>${cust.primaryCustomer}</td>
					<!-- <td><a type="button" class="btn btn-warning" href="/upgrade?id=${cust.custId}">Upgrade to Primary</a></td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="button" href="/get-customer">Get Specific Customer</a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>