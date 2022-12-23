package com.sam._Code_04_web_project.controller;

import com.sam._Code_04_web_project.entity.Product;
import com.sam._Code_04_web_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    @PreAuthorize("hasRole('Admin')")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    @PreAuthorize("hasRole('Admin')")
    public List<Product> addProduct(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('User')")
    public List<Product> getAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productWithId/{id}")
    @PreAuthorize("hasRole('User')")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/productWithName/{name}")
    @PreAuthorize("hasRole('User')")
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('Admin')")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteById(id);
    }

    @GetMapping("/products/{field}")
    @PreAuthorize("hasRole('User')")
    public List<Product> sortedProducts(@PathVariable String field) {
        return service.findProductsWithSorting(field);
    }

    @GetMapping("/productsPagination/{offset}/{pageSize}")
    @PreAuthorize("hasRole('User')")
    public Page<Product> pagedProducts(@PathVariable int offset, @PathVariable int pageSize) {
        return service.findProductWithPagination(offset,pageSize);
    }

    @GetMapping("/productsPaginationandsorting/{field}/{offset}/{pageSize}")
    @PreAuthorize("hasRole('User')")
    public Page<Product> pagedProducts(@PathVariable String field,@PathVariable int offset,@PathVariable int pageSize) {
        return service.findProductWithPaginationAndSort(field,offset,pageSize);
    }
}
