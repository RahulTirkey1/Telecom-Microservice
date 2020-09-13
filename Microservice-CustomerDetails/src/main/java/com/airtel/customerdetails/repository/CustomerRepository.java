package com.airtel.customerdetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airtel.customerdetails.entity.Customer;

import org.springframework.data.jpa.repository.Modifying;



@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
@Query(value="select count(*) from customer_details where phone_no=? and password=?",nativeQuery=true)	
Integer readphoneNoandpassword(Long phoneNo,String password);

Customer findByphoneNo(Long phoneNo);

@Modifying
@Query(value="update customer_details set plan_id=? where phone_no=?",nativeQuery=true)
Integer updated(String planId,Long phoneNo);

@Query(value="select phone_no from customer_details",nativeQuery=true)
List<Long> customer();
}
