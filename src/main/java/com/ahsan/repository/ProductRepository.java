package com.ahsan.repository;

import com.ahsan.entity.Product;
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


    //----------- SQL IN command Logic : //prefix = findBY + filed = Price + operator = IN
    List<Product> findByPriceIn(List<Double> prices);


    //-------- SQL BETWEEN Command Logic : // //prefix = findBY + filed = Price + operator = BETWEEN
    List<Product>findByPriceBetween(double value1, double value2);


    //-------- SQL LessThan & GreaterThan Commands: //prefix = findBY + filed = Price + operator = GreaterThan/LessThan
        List<Product> findByPriceGreaterThan(double price);
        List<Product> findByPriceLessThan(double price);


    //--------- SQL Like Operator :
        List<Product> findByPriceLike(String likeString);
}
