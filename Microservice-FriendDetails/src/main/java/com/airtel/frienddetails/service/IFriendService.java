package com.airtel.frienddetails.service;

import java.util.List;

import com.airtel.frienddetails.entity.Friend;

public interface IFriendService
{
public List<Long> getfriendNo(Long phoneNo);
public String addFriend(Friend friend);
public String deletefriend(Friend friend);
}
