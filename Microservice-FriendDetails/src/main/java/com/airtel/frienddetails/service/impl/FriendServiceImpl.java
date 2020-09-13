package com.airtel.frienddetails.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtel.frienddetails.entity.Friend;
import com.airtel.frienddetails.repository.FriendRepository;
import com.airtel.frienddetails.service.IFriendService;

@Service
public class FriendServiceImpl implements IFriendService {
    @Autowired
	FriendRepository repository;
	
/*	@Override
	public List<Friend> getfriendNo(Long phoneNo) {
		List<Friend> list=new ArrayList<>();
		list=repository.findByphoneNo(phoneNo);
		return list;
	}
	*/
	
    @Override
	public String addFriend(Friend friend) {
		Integer  flag=repository.counting(friend.getPhoneNo(),friend.getFriendNo());
		if(flag>0) {
			return  "Sorry! This Number already exists!!!";
		   }
		else {
			repository.save(friend);
			return  "Phone Number is added to the database successfully!!!";
		}
	}

	@Override
	public List<Long> getfriendNo(Long phoneNo)
	{
	   List<Long> list=new ArrayList<>();
	   list=repository.readfriendNoByphoneNo(phoneNo);
		return list;
	}

	@Override
	public String deletefriend(Friend friend) 
	{
	   Integer del=repository.deleted(friend.getPhoneNo(),friend.getFriendNo());
	   if(del>0)
	   {
		   return "Yes";
	   }
	   else
	   {
		   return "No";
	   }
	}

}
