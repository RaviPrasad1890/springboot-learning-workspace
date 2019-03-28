<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
	<div>
	${msg}
	</div>
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
					<th></th>
					<!--  <th></th> -->
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
						<td><a type="button" class="btn btn-success" href="/update-customer-token?custId=${cust.custId}">Mark Complete</a></td>
						<!-- <td><a type="button" class="btn btn-warning" href="/cancel-token?number=${cust.token.number}?custId=${cust.custId}">Cancel Token</a></td> -->
					</tr>
			</tbody>
		</table>
		<div> 
		<a class="button" href="/get-customer">Get Another Customer</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>