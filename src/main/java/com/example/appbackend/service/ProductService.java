package com.example.appbackend.service;

import com.example.appbackend.model.Product;
import com.example.appbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  // Get all products
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  // Get product by ID
  public Optional<Product> getProductById(Long id) {
    return productRepository.findById(id);
  }

  // Add a new product
  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  // Update an existing product
  public Optional<Product> updateProduct(Long id, Product productDetails) {
    return productRepository.findById(id).map(product -> {
      product.setName(productDetails.getName());
      product.setPrice(productDetails.getPrice());
      product.setImage(productDetails.getImage());
      product.setDescription(productDetails.getDescription());
      return productRepository.save(product);
    });
  }

  // Delete a product by ID
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
