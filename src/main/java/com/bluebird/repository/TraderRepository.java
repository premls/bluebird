package com.bluebird.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebird.entity.TraderEntity;

public interface TraderRepository extends JpaRepository<TraderEntity, Long> {

	public TraderEntity findByName(String name);
}
