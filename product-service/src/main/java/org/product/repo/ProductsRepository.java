package org.product.repo;

import org.product.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ProductsRepository extends JpaRepository<Products, Long>{

	
}
