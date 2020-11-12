package com.RedisExample.redisApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RedisExample.redisApp.Entity.Product;
import com.RedisExample.redisApp.Repository.ProductDal;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductDal dao;
	
 	@PostMapping("/addProduct")
    public Product save(@RequestBody Product product) {
        return dao.save(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Product findProduct(@PathVariable int id) {
        return dao.findProductById(id);
    }
    
    @DeleteMapping("/deleteProduct/{id}")
    public Long remove(@PathVariable int id)   {
    	return dao.deleteProduct(id);
	}


}
