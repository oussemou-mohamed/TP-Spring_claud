package org.sdia.billingservice.feign;

import org.sdia.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCT-SERVICE")

public interface InventoryServiceClient {
   //@GetMapping(path = "/products/{id}?projection=fullProduct")
   @GetMapping(path = "/products")
    PagedModel<Product> pageProduct();
   @GetMapping(path = "/products/{id}")
   Product findProductById(@PathVariable Long id);


}

















