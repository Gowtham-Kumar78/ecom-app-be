package com.gowtham.ecom.ecom_app.controllers;

import com.gowtham.ecom.ecom_app.models.Product;
import com.gowtham.ecom.ecom_app.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    ProductService productService;

    public ProductController (ProductService productService){
        this.productService=productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
       try {
          Product p= productService.addProduct(product);
          return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
       }
       catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }


    @PostMapping("/addProducts")
    public void addMultiProduct(@RequestBody List<Product> product){
        productService.addMultiProduct(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product =productService.getProductById(id);

        if(product!=null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PutMapping("/product/{id}")
    public ResponseEntity<String > updateProductById(@PathVariable int id,@RequestBody Product product){
        Product p = productService.updateProductById( id, product);

        if(p!=null){
            return new ResponseEntity<>("Updated Successfully",HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>("Unsuccessfully",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id){
        Product product =productService.getProductById(id);

        if(product!=null){
            productService.deleteProductById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<?> searchProducts(@RequestParam String keyword){
        System.out.println("Searching with "+keyword);

        List<Product> productList=productService.searchProducts(keyword);
        if (!productList.isEmpty())
        return new ResponseEntity<>(productList,HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

