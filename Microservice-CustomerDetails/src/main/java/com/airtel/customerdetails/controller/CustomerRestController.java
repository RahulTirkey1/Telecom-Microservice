package com.airtel.customerdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.customerdetails.MicroserviceCustomerDetailsApplication;
import com.airtel.customerdetails.entity.Customer;
import com.airtel.customerdetails.model.CustomerDTO;
import com.airtel.customerdetails.model.Login;
import com.airtel.customerdetails.model.UpdateDTO;
import com.airtel.customerdetails.service.ICustomerService;

@RestController
@RibbonClient(name="custribbon")
public class CustomerRestController 
{  
	@Autowired
   ICustomerService service;
	
	@PostMapping(value="/register", produces="text/plain",consumes="application/json")
	public String addCustomer(@RequestBody Customer customer)
	{
		return service.registeruser(customer);
	}
	
	@PostMapping(value="/login", produces="text/plain",consumes="application/json")
	public String logincustomer(@RequestBody Login login)
	{
		return service.loginuser(login);
	}
	
	@GetMapping(value="/profile/{phoneno}",produces="application/json")
	public CustomerDTO getcustomer(@PathVariable("phoneno")Long phoneNo)
	{
		return service.fetchprofile(phoneNo);
	}
	
	@PostMapping(value="/update",produces="text/plain",consumes="application/json")
	public String updater(@RequestBody UpdateDTO dto)
	{   
		boolean l=service.changeplan(dto);
		
		if(l==true)
			return "Plan Updated successfully";
		else
			return "Please Check whether the Given Number is proper or not.";
	}
	
	@GetMapping(value="/getnumber",produces="application/json")
	public List<Long> get_numberList()
	{
		return service.allcustomer();
	}
		
	}

