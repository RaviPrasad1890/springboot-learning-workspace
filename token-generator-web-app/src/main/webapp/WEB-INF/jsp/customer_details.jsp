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
				<th>Token Number</th>
				<th>Counter Number</th>
				<th>Token Active</th>
			</tr>
		</thead>
		<tbody>
			
				<tr>
					<td>${cust.custId}</td>
					<td>${cust.custName}</td>
					<td>${cust.primaryCustomer}</td>
					<td>${cust.token.number}</td>
					<td>${cust.counterAssigned}</td>
					<td>${cust.token.active}</td>
					<!-- <td><a type="button" class="btn btn-warning" href="/upgrade?id=${cust.custId}">Upgrade to Primary</a></td> -->
				</tr>
			
		</tbody>
	</table>
	<div>
		<a class="button" href="/generate-customer-token?id=${cust.custId}">Generate
			Token</a>
	</div>
	<div>
		<a class="button" href="/get-customer">Get Another Customer</a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>