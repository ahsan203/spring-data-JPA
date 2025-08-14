package com.ahsan.repository;

import com.ahsan.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>
{

}
