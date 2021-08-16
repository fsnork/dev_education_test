package com.example.shop.controller;

import com.example.shop.entity.Product;
import com.example.shop.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "home page";
    }

    @GetMapping("/error")
    @ResponseBody
    public String error() {
        return "oops";
    }

    @PostMapping("/add_product")
    public String addProduct(Product product) {
        return service.addProduct(product).toString();
    }

    @GetMapping("/products")
    public void getAllProducts() {
        List<Product> productList = service.getAll();
        List<Product> fridgeList = new ArrayList<>();
        List<Product> microwaveList = new ArrayList<>();
        List<Product> tvList = new ArrayList<>();
        for (Product product : productList) {
            switch (product.getType()) {
                case ("Fridge"):
                    fridgeList.add(product);
                    break;
                case ("Microwave"):
                    microwaveList.add(product);
                    break;
                case ("TV"):
                    tvList.add(product);
                    break;
            }
        }
        /*System.out.println("Category - Fridge:");
        for (Product product : fridgeList) {
            System.out.println(product);
        }
        System.out.println("\nCategory - Microwave:");
        for (Product product : microwaveList) {
            System.out.println(product);
        }
        System.out.println("\nCategory - TV:");
        for (Product product : tvList) {
            System.out.println(product);
        }*/
    }
}
