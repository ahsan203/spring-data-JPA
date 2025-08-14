package com.ahsan.repository;

import com.ahsan.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>
{

    Product findByName(String name);

    List<Product> findByProductType(String name);

    List<Product> findByPriceAndProductType(double price, String productType);


    @Query(value = "SELECT * FROM Product_Table WHERE price=?1",nativeQuery = true)
    List<Product> getProductByPrice(double price);
}
