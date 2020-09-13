package com.airtel.calldetails.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtel.calldetails.dto.CallDetailsDTO;
import com.airtel.calldetails.entity.CallDetails;
import com.airtel.calldetails.repository.CallDetailsRepository;
import com.airtel.calldetails.service.ICallDetailsService;

@Service
public class CallDetailsServiceImpl implements ICallDetailsService {
    
	@Autowired
	CallDetailsRepository repository;
	@Override
	public List<CallDetailsDTO> getCallDetailsByPhoneNumber(Long calledBy) {
		
		List<CallDetails> callDetailslist=repository.findBycalledBy(calledBy);
		List<CallDetailsDTO> callDetailslistDTO=new ArrayList<>();
		for(CallDetails calldetails:callDetailslist)
		{
			CallDetailsDTO dto=new CallDetailsDTO();
			BeanUtils.copyProperties(calldetails,dto);
			callDetailslistDTO.add(dto);
			
		}
		return callDetailslistDTO;
	}

}
