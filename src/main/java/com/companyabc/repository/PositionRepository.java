package com.companyabc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.companyabc.entity.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
	
	Position findByName(String name);
	
	Position findById(int id);
	
	List<Position> findAllByOrderByIdAsc();
	
	@Query("select count(u) from User u where u.position.id = ?1 GROUP BY position_id")
	Long countUsersGroupByPosition(int id);

}
