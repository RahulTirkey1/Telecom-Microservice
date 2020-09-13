package com.airtel.customerdetails.service;

import java.util.List;

import com.airtel.customerdetails.entity.Customer;
import com.airtel.customerdetails.model.CustomerDTO;
import com.airtel.customerdetails.model.Login;
import com.airtel.customerdetails.model.UpdateDTO;

public interface ICustomerService {

	public String registeruser(Customer customer);
	public String loginuser(Login login);
	public boolean changeplan(UpdateDTO dto);
	public CustomerDTO fetchprofile(Long phoneNo);
	public List<Long> allcustomer();
}
