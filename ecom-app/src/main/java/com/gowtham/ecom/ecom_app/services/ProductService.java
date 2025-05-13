package com.gowtham.ecom.ecom_app.services;

import com.gowtham.ecom.ecom_app.models.Product;
import com.gowtham.ecom.ecom_app.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo=productRepo;
    }

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product addProduct(Product product){
        System.out.println(product);
        productRepo.save(product);
        return product;
    }

    public void addMultiProduct(List<Product> product){
        productRepo.saveAll(product);
//        for(Product p :product){
//            productRepo.save(p);
//        }
    }


    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product updateProductById(int id, Product product) {
       return productRepo.save(product);
    }

    public void deleteProductById(int id){
        productRepo.deleteById(id);
    }


    public List<Product> searchProducts(String keyword){
        return productRepo.searchProducts(keyword);
    }
}
