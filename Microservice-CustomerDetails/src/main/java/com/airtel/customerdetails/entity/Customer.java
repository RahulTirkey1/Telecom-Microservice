package com.airtel.customerdetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_DETAILS")
public class Customer
{
 @Id
 private Long phoneNo;
 @Column(length=20)
 private String name;
 @Column(length=20)
 private String password;
 @Column(length=20)
 private String planId;
 
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
 
}
