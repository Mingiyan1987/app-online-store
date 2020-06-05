package ru.basanov.apponlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.basanov.apponlinestore.model.Product;
import ru.basanov.apponlinestore.model.ProductStatus;
import ru.basanov.apponlinestore.service.ProductService;

@RestController
public class ProductController {

    private static final int PAGE_SIZE = 15;

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable(value = "id") Long id) {
        productService.deleteById(id);
    }

    @DeleteMapping("/products")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        productService.deleteAll();
    }

    @GetMapping(value = "products/{pageNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Product> getAllProduct(@RequestParam(required = false, defaultValue = "") ProductStatus productStatus, @PathVariable(value = "pageNo") int pageNo) {

        Pageable sortedByDate = PageRequest.of(pageNo, PAGE_SIZE, Sort.by("date").ascending());

        if (productStatus != null) {
            return productService.findByStatus(productStatus, sortedByDate);
        }
        return productService.getAll(sortedByDate);
    }

}
