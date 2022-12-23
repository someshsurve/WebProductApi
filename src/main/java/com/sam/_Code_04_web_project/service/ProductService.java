package com.sam._Code_04_web_project.service;

import com.sam._Code_04_web_project.entity.Product;
import com.sam._Code_04_web_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void initDB() {
        List<Product> products = IntStream.rangeClosed(1,1000)
                .mapToObj(i -> new Product("product"+i,
                        "productSerialNo"+i,
                        "productLicenceCode"+i,
                        new Random().nextInt(5),
                        "productManufacturer"+i,
                        "productImportedFromCountry"+i,
                        new Random().nextInt(10000000),
                        new Random().nextInt(100),
                        new Random().nextInt(50000)))
                .collect(Collectors.toList());
        productRepository.saveAll(products);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public String deleteById(int id) {
        productRepository.deleteById(id);
        return "Successfully deleted Id@" + id;
    }
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }


    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

    public List<Product> findProductsWithSorting(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Product> findProductWithPagination(int offset, int pageSize) {
        return productRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public Page<Product> findProductWithPaginationAndSort(String field, int offset, int pageSize) {
        return productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    }



}
