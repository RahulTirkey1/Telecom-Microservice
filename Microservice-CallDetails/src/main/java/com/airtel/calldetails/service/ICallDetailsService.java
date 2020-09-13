package com.airtel.calldetails.service;

import java.util.List;

import com.airtel.calldetails.dto.CallDetailsDTO;

public interface ICallDetailsService
{
List<CallDetailsDTO> getCallDetailsByPhoneNumber(Long calledBy);
}
