package com.airtel.frienddetails.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRIEND_DETAILS")
public class Friend {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    private Long phoneNo;
    private Long friendNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Long getFriendNo() {
		return friendNo;
	}
	public void setFriendNo(Long friendNo) {
		this.friendNo = friendNo;
	}
    
    
	
}
