package com.demo.ecommerce.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.demo.ecommerce.exception.ProductException;
import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.request.CreateProductRequest;

public interface ProductService {

    
  public  Product createProduct(CreateProductRequest req, Seller seller);
    public  void deleteProduct(Long productId) throws ProductException;
    public Product updateProduct(Long productId, Product product) throws ProductException;
    Product findProductsById(Long productId) throws ProductException;
    List<Product> searchProducts(String query);
     public Page<Product> getAllProducts(

        String category,
        String brand,
        String colors,
        String size,
        Integer minPrice,
        Integer maxPrice,
        Integer minDiscount,
        String sort,
        String stock,
        Integer pageNumber
    );

    
    List<Product> getProductBySeller(Long sellerId);
}
