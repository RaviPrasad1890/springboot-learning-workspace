package com.bank.abc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.abc.model.Counter;
import com.bank.abc.model.Customer;
import com.bank.abc.model.Token;
import com.bank.abc.service.CustomerRepository;
import com.bank.abc.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	
	//@RequestMapping(value = "/list-all-customer", method = RequestMethod.GET)
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listAllCustomer(ModelMap map) {
		List<Customer> customers=(List<Customer>) customerRepository.findAll();
		map.put("customers", customers);
		return "customer_all";
	}
	
	//@RequestMapping(value = "/get-customer", method = RequestMethod.GET)
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getCustomerPage() {
		return "customer"; 
	 }
	
	//@RequestMapping(value = "/get-customer", method = RequestMethod.POST)
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String retreiveCustomer(@ModelAttribute Customer cust1, ModelMap model) {
		int id=cust1.getCustId();
		Customer customer=customerRepository.findOne(id);
		if(customer==null) {
			model.put("error", "Customer Doesn't Exist"); 
			return "customer";
		}
		model.put("cust", customer);
		return "customer_details";
	}
	
	//@RequestMapping(value = "/add-customer", method = RequestMethod.GET) 
	//@RequestMapping(value = "/customer/", method = RequestMethod.GET) 
	
	
	
	/*
	 * 
	 * @Autowired CustomerService service;
	 * 
	 * ///list-all-customer
	 * 
	 * @RequestMapping(value = "/list-all-customer", method = RequestMethod.GET)
	 * public String listAllCustomer(ModelMap map) {
	 * 
	 * List<Customer> customers=service.retrieveCustomers(); map.put("customers",
	 * customers); return "customer_all"; }
	 * 
	 * @RequestMapping(value = "/get-customer", method = RequestMethod.GET) public
	 * String getCustomerPage() {
	 * 
	 * return "customer"; }
	 * 
	 * @RequestMapping(value = "/get-customer", method = RequestMethod.POST) public
	 * String retreiveCustomer(@ModelAttribute Customer cust1, ModelMap model) {
	 * 
	 * // String custId=cust.getCustId() int id = 0; try { // id=
	 * Integer.parseInt(custId.trim()); id = cust1.getCustId(); } catch
	 * (NumberFormatException ex) { model.put("error",
	 * "Please enter appropriate value"); return "customer"; } catch
	 * (NullPointerException npe) { model.put("error",
	 * "Please enter appropriate value"); return "customer"; }
	 * 
	 * Customer cust = service.retrieveCustomer(id); if (cust == null) {
	 * model.put("error", "Customer Doesn't Exist"); return "customer"; }
	 * 
	 * 
	 * if(cust.getTokenAssigned()==null) {
	 * cust.setTokenAssigned("Not Assigned Yet"); }
	 * 
	 * 
	 * if (cust.getCounterAssigned() == null) {
	 * cust.setCounterAssigned("Please generate Token to get Counter Number"); }
	 * 
	 * model.put("cust", cust); return "customer_details"; }
	 * 
	 * @RequestMapping(value = "/add-customer", method = RequestMethod.GET) public
	 * String addCustomerPage() {
	 * 
	 * return "add_customer"; }
	 * 
	 * @RequestMapping(value = "/add-customer", method = RequestMethod.POST) public
	 * String addCustomer(@RequestParam Map<String, String> formData, ModelMap map)
	 * {
	 * 
	 * 
	 * System.out.println("formData "+formData.get("custName"));
	 * System.out.println("formData "+formData.get("primaryCustomer"));
	 * 
	 * char isPrimary; String custName = formData.get("custName"); try { if
	 * ((formData.get("primaryCustomer").equalsIgnoreCase("on"))) { isPrimary = 'Y';
	 * } else { isPrimary = 'N'; } } catch (NullPointerException npe) { isPrimary =
	 * 'N'; } service.addCustomer(custName, isPrimary); return
	 * "redirect:/get-customer"; }
	 * 
	 * 
	 * @RequestMapping(value="/get-customer", method = RequestMethod.POST) public
	 * String retreiveCustomer(@ModelAttribute Customer cust1,ModelMap model) {
	 * 
	 * //String custId=cust.getCustId() int id=0; try { //id=
	 * Integer.parseInt(custId.trim()); id=cust1.getCustId();
	 * }catch(NumberFormatException ex) { model.put("error",
	 * "Please enter appropriate value"); return "customer";
	 * }catch(NullPointerException npe) { model.put("error",
	 * "Please enter appropriate value"); return "customer"; }
	 * 
	 * Customer cust= service.retrieveCustomer(id); if(cust==null) {
	 * model.put("error", "Customer Doesn't Exist"); return "customer"; }
	 * 
	 * 
	 * if(cust.getTokenAssigned()==null) {
	 * cust.setTokenAssigned("Not Assigned Yet"); }
	 * 
	 * 
	 * if(cust.getCounterAssigned()==null) {
	 * cust.setCounterAssigned("Please generate Token to get Counter Number"); }
	 * 
	 * 
	 * model.put("cust", cust); return "customer_details"; }
	 * 
	 * 
	 * @RequestMapping(value = "/generate-customer-token", method =
	 * RequestMethod.GET) public String generateToken(@RequestParam String id,
	 * ModelMap model) {
	 * 
	 * int custId = Integer.parseInt(id); Customer cust =
	 * service.retrieveCustomer(Integer.parseInt(id));
	 * 
	 * Token tkn = cust.getToken(); try { if (tkn.getActive() == 'Y') {
	 * model.put("msg", "An Active Token is already assigned to this Customer");
	 * model.put("cust", cust); return "customer_token_details"; } } catch
	 * (NullPointerException npe) {
	 * 
	 * }
	 * 
	 * int tokenNumer = service.assignToken(custId); Counter counter =
	 * service.assignCounter(custId);
	 * 
	 * Token token = new Token(tokenNumer, 'Y', counter); cust.setToken(token);
	 * String cno = Integer.toString(counter.getNumber());
	 * cust.setCounterAssigned(cno); model.put("cust", cust);
	 * 
	 * return "customer_token_details"; }
	 * 
	 * @RequestMapping(value = "/update-customer-token", method = RequestMethod.GET)
	 * public String completeToken(@RequestParam Map<String, String> reqData) { //
	 * int tokenId= Integer.parseInt(reqData.get("number")); int custId =
	 * Integer.parseInt(reqData.get("custId")); service.markTokenComplete(custId);
	 * // map.put("custId", custId); return "final_page";
	 * 
	 * }
	 */
}
