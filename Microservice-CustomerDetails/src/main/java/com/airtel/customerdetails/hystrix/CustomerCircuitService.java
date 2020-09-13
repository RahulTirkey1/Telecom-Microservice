package com.airtel.customerdetails.hystrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.airtel.customerdetails.model.PlanDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;


@Service
public class CustomerCircuitService
{
	static String Friend_URL="http://FRIENDDETAILSMS/Frienddetails/{phoneNo}";
	static String Plan_URL="http://PLANDETAILSMS/Plandetails/{planId}";
	
	@Autowired
	RestTemplate restTemplate;
	
	public Future<PlanDTO> getPlandata(String planId)
	{
		return new AsyncResult<PlanDTO>()
				{

					@Override
					public PlanDTO invoke() {
						
						return restTemplate.getForObject(Plan_URL,PlanDTO.class,planId);
					}
			         
				};
	}
	
   
	@HystrixCommand(fallbackMethod="getfriendsfallback")
	public List<Long> getfriendsnormal(Long phoneNo)
	{
		
		return restTemplate.getForObject(Friend_URL, List.class,phoneNo);
		
	}
	
	public List<Long> getfriendsfallback(Long phoneNo)
	{
		return new ArrayList<>();
	}
}
