package com.companyabc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyabc.entity.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {

}
