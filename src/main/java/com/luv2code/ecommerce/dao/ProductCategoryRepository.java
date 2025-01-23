package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


//@CrossOrigin("http://localhost:4200")
//@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}



/*
@RepositoryRestResource - This is a Spring annotation that configures
 how your repository will be exposed as a REST resource.

Two main parameters are being set here:
    => collectionResourceRel = "productCategory": This defines the name that will be used in the JSON
                                    response when referring to this resource

    => path = "product-category": This sets the actual URL path where this resource will be accessible
*/