package com.airtel.frienddetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.frienddetails.entity.Friend;
import com.airtel.frienddetails.service.IFriendService;

@RestController
public class FriendRestController {
    
	@Autowired
	IFriendService service;
	
/*	@GetMapping(value="/{phoneno}", produces="application/json")
	public List<Friend> getfriend(@PathVariable("phoneno")Long phoneNo)
	{
		return service.getfriendNo(phoneNo);
   }
	*/
	@GetMapping(value="/{phoneNum}",produces="application/json")
	public List<Long> getfriend(@PathVariable ("phoneNum") Long phoneNo)
	{
		return service.getfriendNo(phoneNo);
	}
	
	@PostMapping(value="/addfriend", produces="text/plain",consumes="application/json")
	public String addedfriend(@RequestBody Friend friend)
	{
		return service.addFriend(friend);
	}
	
	@PostMapping(value="/deletefriend",produces="text/plain",consumes="application/json")
	public String deletefriend(@RequestBody Friend friend)
	{
		return service.deletefriend(friend);
	}
}
