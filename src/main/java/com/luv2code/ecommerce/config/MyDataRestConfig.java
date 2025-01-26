package com.luv2code.ecommerce.config;


import com.luv2code.ecommerce.entity.Country;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import com.luv2code.ecommerce.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        // Create an array of HTTP methods we want to disable
        // This will prevent users from creating, updating, or deleting data
        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        // --- Product Configuration ---
        // Disable HTTP methods for Product entity
        // This makes the Product endpoints -> ((read-only))
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                // Disable methods for single items (example: /api/products/1)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                // Disable methods for product collection (example: /api/products)
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));


        // --- Product Category Configuration ---
        // Disable HTTP methods for ProductCategory entity
        // This makes the ProductCategory endpoints -> ((read-only))
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                // Disable methods for single category (example: /api/product-category/1)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                // Disable methods for category collection (example: /api/product-category)
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));



        // --- Country Configuration ---
        // Disable HTTP methods for Country entity
        // This makes the Country endpoints -> ((read-only))
        config.getExposureConfiguration()
                .forDomainType(Country.class)
                // Disable methods for single category (example: /api-countries/countries/1)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                // Disable methods for category collection (example: /api-countries/countries)
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));


        // --- State Configuration ---
        // Disable HTTP methods for Country entity
        // This makes the State endpoints -> ((read-only))
        config.getExposureConfiguration()
                .forDomainType(State.class)
                // Disable methods for single category (example: /api-states/states/1)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                // Disable methods for category collection (example: /api-states/states)
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));


        // Call an internal helper method
        exposeIds(config);

    }





    /**
     * This method exposes the entity IDs in the REST API responses
     *
     * Here's what the method does:
     * 1. Get all entity types from JPA metamodel via entityManager
     * 2. Create a List to store the entity Java classes
     * 3. Iterates through each entity type and adds its Java class to list
     * 4. Converts the List to an array of Class objects
     * 5. Configures Spring Data REST to expose IDs for all these entity types
     *
     * This is needed because by default, Spring Data REST does not expose entity IDs.
     * Exposing IDs is often useful for frontend frameworks that need to track entities.
     *
     * @param config The RepositoryRestConfiguration to configure ID exposure
     */
    private void exposeIds(RepositoryRestConfiguration config) {

        Set<jakarta.persistence.metamodel.EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<Class<?>> entityClasses = new ArrayList<>();
        for (EntityType<?> tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }




}
