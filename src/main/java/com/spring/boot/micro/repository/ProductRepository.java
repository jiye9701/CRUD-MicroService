package com.spring.boot.micro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.micro.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	//e
//	@Query(value = "SELECT * FROM Product where productId=?1", nativeQuery = true)
//    List<Product> findById(int ProductId);

}
