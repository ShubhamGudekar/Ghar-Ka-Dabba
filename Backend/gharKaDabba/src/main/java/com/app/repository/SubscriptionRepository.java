package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.SubscriptionPlan;

public interface SubscriptionRepository extends JpaRepository<SubscriptionPlan, Long> {

}
