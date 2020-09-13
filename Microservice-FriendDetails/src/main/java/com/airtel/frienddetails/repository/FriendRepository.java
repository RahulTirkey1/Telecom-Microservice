package com.airtel.frienddetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airtel.frienddetails.entity.Friend;
@Repository
@Transactional
public interface FriendRepository extends JpaRepository<Friend, Long> 
{
    @Query(value="select friend_no from friend_details where phone_no=?",nativeQuery=true)
	List<Long> readfriendNoByphoneNo(Long phoneNo);
	
//	List<Friend> findByphoneNo(Long phoneNo);
    
    @Query(value="select count(*) from friend_details where phone_no=? and friend_no=?",nativeQuery=true)
    Integer counting(Long phoneNo,Long friendNo);
    
    @Modifying
    @Query(value="delete from friend_details where phone_no=? and friend_no=?",nativeQuery=true)
    Integer deleted(Long phoneNo,Long friendNo);
}
