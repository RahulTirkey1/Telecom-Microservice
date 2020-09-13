package com.airtel.ui.model;

import java.util.ArrayList;
import java.util.List;

public class PlanDTO
{
	private String planId;
    private String planName;
    private Integer validity;
    
    private List<PlanDTO> planlist=new ArrayList<>();
    
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getValidity() {
		return validity;
	}
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	public List<PlanDTO> getPlanlist() {
		return planlist;
	}
	public void setPlanlist(List<PlanDTO> planlist) {
		this.planlist = planlist;
	}
	
	
    
}
