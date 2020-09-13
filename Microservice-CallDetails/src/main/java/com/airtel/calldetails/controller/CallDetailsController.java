package com.airtel.calldetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.calldetails.dto.CallDetailsDTO;
import com.airtel.calldetails.service.ICallDetailsService;

@RestController
public class CallDetailsController {

	@Autowired
	ICallDetailsService service;
	
	@GetMapping(value="/profile/{phoneNumber}",produces="application/json")
	public List<CallDetailsDTO> getCallDetailsByPhoneNumber(@PathVariable("phoneNumber")Long calledBy)
	{
		
	return service.getCallDetailsByPhoneNumber(calledBy);
     }
}
