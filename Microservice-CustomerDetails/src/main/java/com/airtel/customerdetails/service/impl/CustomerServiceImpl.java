package com.airtel.customerdetails.service.impl;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.airtel.customerdetails.entity.Customer;
import com.airtel.customerdetails.hystrix.CustomerCircuitService;
import com.airtel.customerdetails.model.CustomerDTO;
import com.airtel.customerdetails.model.Login;
import com.airtel.customerdetails.model.PlanDTO;
import com.airtel.customerdetails.model.UpdateDTO;
import com.airtel.customerdetails.repository.CustomerRepository;
import com.airtel.customerdetails.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
	CustomerRepository repository;
    
    @Autowired
    CustomerCircuitService circuit;
    
//	@LoadBalancedRestTemplate
    @Autowired
   public  RestTemplate   restTemplate;
    
	@Override
	public String registeruser(Customer customer) 
	{
		boolean flag=repository.existsById(customer.getPhoneNo());
		if(flag)
		{
			return "No";
		}
		else
		{
	    repository.save(customer);	
		return "Yes";
		}
	}

	@Override
	public String loginuser(Login login) {
		// TODO Auto-generated method stub
		Integer flag=repository.readphoneNoandpassword(login.getPhoneNo(),login.getPassword());
		if(flag>0)
		{
			return "Yes";
		}
		else
		{
			return "No";
		}
	}

	@Override
	public CustomerDTO fetchprofile(Long phoneNo) {
		// TODO Auto-generated method stub
		CustomerDTO dto=new CustomerDTO();
		Customer customer=repository.findByphoneNo(phoneNo);
		dto.setName(customer.getName());
		dto.setPhoneNo(customer.getPhoneNo());
		dto.setPlanId(customer.getPlanId());
//		String Url_1="http://localhost:2324/Plandetails/{dto.getPlanId()}";
		String Url_1="http://PLANDETAILSMS/Plandetails/{id}";
		PlanDTO dis =restTemplate.getForObject(Url_1,PlanDTO.class,dto.getPlanId());
		dto.setCurrentPlan(dis);
//			Future<PlanDTO> future=circuit.getPlandata(dto.getPlanId());
//		try {
//	        	dto.setCurrentPlan(future.get());
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		} 
//		String Url_2="http://custribbon/Frienddetails/{dto.getPhoneNo()}";
	//	String Url_2="http://FRIENDDETAILSMS/Frienddetails/{phoneNo}";
    //    List<Long> friend=restTemplate.getForObject(Url_2, List.class, dto.getPhoneNo());
		
		dto.setFriends(circuit.getfriendsnormal(dto.getPhoneNo()));
		return dto;
	}

	@Override
	public boolean changeplan(UpdateDTO dto) {
		Integer l=repository.updated(dto.getPlanId(), dto.getPhoneNo());
		if(l>0)
			return true;
		else
			return false;
	}

	@Override
	public List<Long> allcustomer()
	{
	   List<Long> l=repository.customer();
		return l;
	}

	
	
}
