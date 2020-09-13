package com.airtel.ui.model;

import java.util.LinkedHashMap;

public class UpdateDTO 
{
private String planId;
private Long phoneNo;
private LinkedHashMap<String,String> planList;
public String getPlanId() {
	return planId;
}
public void setPlanId(String planId) {
	this.planId = planId;
}
public Long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(Long phoneNo) {
	this.phoneNo = phoneNo;
}
public LinkedHashMap<String, String> getPlanList() {
	return planList;
}
public void setPlanList(LinkedHashMap<String, String> planList) {
	this.planList = planList;
}

}
