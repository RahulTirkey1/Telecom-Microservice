package com.airtel.plandetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.plandetails.dto.PlanDTO;
import com.airtel.plandetails.service.IPlanService;

@RestController
public class PlanRestController 
{
    @Autowired
	IPlanService service;
	@GetMapping(value="/allPlans",produces="application/json")
	public List<PlanDTO> getallplanscon()
	{
		return service.getAllPlans();
	}
	
	@GetMapping(value="/{planid}",produces="application/json")
	public PlanDTO getparticularplancon(@PathVariable("planid")String planId)
	{
		return service.getparticularplan(planId);
}
}