package com.example.demo.services;

import com.example.demo.DemoApplication;
import java.util.List;
import java.util.UUID;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.entities.Product;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component.
public class ProductService implements IProductService {

    private final DemoApplication demoApplication;
    @Autowired
    private ProductRepository productRepository;

    ProductService(DemoApplication demoApplication) {
        this.demoApplication = demoApplication;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product addProduct(ProductRequestDto productDto){
        var product = Product
            .builder()
            .name(productDto.getName())
            .description(productDto.getDescription())
            .price(productDto.getPrice())
            .resourceId(UUID.randomUUID())
            .build();
        return productRepository.addProduct(product);
    }

    @Override
    public Product getByResourceId(UUID resourceId){
        return productRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new ProductNotFoundException( "Producto no encontrado"));
    }

    @Override
    public Product updateProduct(UUID resourceId, ProductRequestDto productDto) {
        var product = productRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            return productRepository.updateProduct(product);
    }

    @Override
    public void removeProduct(UUID resourceId) {
        var product = productRepository.findByResourceId(resourceId)
        .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado"));

        productRepository.delete(product);
    }
}
