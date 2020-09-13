package com.airtel.plandetails.service;

import java.util.List;

import com.airtel.plandetails.dto.PlanDTO;

public interface IPlanService {

	List<PlanDTO> getAllPlans();
	PlanDTO getparticularplan(String planId);
	
}
