package com.example.crudapp.service;

import com.example.crudapp.entity.Product;
import com.example.crudapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    @Autowired
    private ProductRepository repository;

    //post method
    public Product saveProduct(Product product){
        return  repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return  repository.saveAll(products);
    }

    //get method
    public  List<Product> getProduct() {
        return repository.findAll();
    }
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    //delete product by id
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product Removed" + id ;
    }

    public Product updateProduct(Product product) {
        Product exitingProduct = repository.findById(product.getId()).orElse(null);
        exitingProduct.setName(product.getName());
        exitingProduct.setQuantity(product.getQuantity());
        exitingProduct.setPrice(product.getPrice());
        return repository.save(exitingProduct);

    }
}
