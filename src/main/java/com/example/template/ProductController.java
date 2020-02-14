package com.example.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProductService productService;

    @GetMapping("/product/{productId}")
    Product productStockCheck(@PathVariable(value = "productId") Long productId) {

        System.out.println("productStockCheck call");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  this.productService.getProductById(productId);
    }

    @PutMapping("/product/increaseStock/{productId}")
    void increaseStock(@PathVariable(value = "productId") Long productId, @RequestBody int qty) {
        this.productService.increaseStock(productId, qty);
    }
    @PutMapping("/product/decreaseStock/{productId}")
    void decreaseStock(@PathVariable(value = "productId") Long productId, @RequestBody int qty) {
        this.productService.decreaseStock(productId, qty);
    }

    @PostMapping("/product")
    Product productInsert(@RequestBody String data) {
        System.out.println(data);
        return this.productService.save(data);
    }

}
