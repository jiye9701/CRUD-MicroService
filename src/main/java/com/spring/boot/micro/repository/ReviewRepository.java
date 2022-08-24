package com.spring.boot.micro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.boot.micro.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer>{

//	@Query(value = "SELECT * FROM Review where userId=?1", nativeQuery = true)
//    List<Review> findById(String userId);

}
