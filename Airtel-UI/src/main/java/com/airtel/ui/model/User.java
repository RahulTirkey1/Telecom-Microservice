package com.airtel.ui.model;
import java.util.LinkedHashMap;
public class User 
{
	private Long phoneNo;
	 
	 private String name;
	 
	 private String password;
	 
	 private String planId;
	 
	 private LinkedHashMap<String,String> planList;
	 
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public LinkedHashMap<String, String> getPlanList() {
		return planList;
	}
	public void setPlanList(LinkedHashMap<String, String> planList) {
		this.planList = planList;
	}
	
}
