 package com.demo.ecommerce.repositiory;


 import java.util.List;
 
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;
 import com.demo.ecommerce.modal.Product;
 
 public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
 
     List<Product> findBySellerId(Long id);
 
     @Query("SELECT p FROM Product p WHERE " +
            "(:query IS NULL OR lower(p.title) LIKE lower(concat('%', :query, '%'))) OR " +
            "(:query IS NULL OR lower(p.category.name) LIKE lower(concat('%', :query, '%')))")
     List<Product> searchProduct(@Param("query") String query);
 }
 