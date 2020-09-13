package com.airtel.ui.model;

import java.util.LinkedHashMap;
import java.util.List;

public class FriendDTO 
{
private Long phoneNo;
private Long friendNo;
private LinkedHashMap<Long,Long> friends;
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
public LinkedHashMap<Long, Long> getFriends() {
	return friends;
}
public void setFriends(LinkedHashMap<Long, Long> friends) {
	this.friends = friends;
}


}
