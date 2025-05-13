package com.gowtham.ecom.ecom_app.repos;

import com.gowtham.ecom.ecom_app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    //JPQL ->JPA query

    @Query("SELECT p from Product p WHERE "+"LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            +"LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            +"LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            +"LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);

}
