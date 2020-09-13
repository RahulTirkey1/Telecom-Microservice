package com.airtel.plandetails.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtel.plandetails.dto.PlanDTO;
import com.airtel.plandetails.entity.Plan;
import com.airtel.plandetails.repository.PlanRepository;
import com.airtel.plandetails.service.IPlanService;

@Service
public class PlanServiceImpl implements IPlanService {
    @Autowired
	PlanRepository repository;
	@Override
	public List<PlanDTO> getAllPlans() {
		List<Plan> plandetails=repository.findAll();
		List<PlanDTO> plandtodetails=new ArrayList<>();
		for(Plan plandetail:plandetails)
		{
			PlanDTO dto=new PlanDTO();
			BeanUtils.copyProperties(plandetail, dto);
			plandtodetails.add(dto);
		}
		return plandtodetails;
	}

	@Override
	public PlanDTO getparticularplan(String planId) {
		Plan getparticularplan=repository.findByplanId(planId);
		PlanDTO getdtoparticularplan=new PlanDTO();
		BeanUtils.copyProperties(getparticularplan, getdtoparticularplan);
		return getdtoparticularplan;
	}

}
