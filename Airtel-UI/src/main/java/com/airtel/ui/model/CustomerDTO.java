package com.airtel.ui.model;

import java.util.List;

public class CustomerDTO 
{
private Long phoneNo;
private String name;

private String planId;
private PlanDTO currentPlan;
private List<Long> friends;
public Long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(Long phoneNo) {
	this.phoneNo = phoneNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPlanId() {
	return planId;
}
public void setPlanId(String planId) {
	this.planId = planId;
}
public PlanDTO getCurrentPlan() {
	return currentPlan;
}
public void setCurrentPlan(PlanDTO currentPlan) {
	this.currentPlan = currentPlan;
}
public List<Long> getFriends() {
	return friends;
}
public void setFriends(List<Long> friends) {
	this.friends = friends;
}



}
