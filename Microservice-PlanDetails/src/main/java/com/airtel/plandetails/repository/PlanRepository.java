package com.airtel.plandetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airtel.plandetails.entity.Plan;
@Repository
public interface PlanRepository extends JpaRepository<Plan, String> {

	Plan findByplanId(String planId);
}
