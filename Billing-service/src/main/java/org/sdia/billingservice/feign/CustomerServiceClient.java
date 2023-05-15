package org.sdia.billingservice.feign;

import org.sdia.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerServiceClient {
    @GetMapping(path = "/customers/{id}?projection=fullCustomer")       //si je demande la methode findcustomerbyib tu menvoi un repense avec getMApping ver le path
    Customer findCustomerById(@PathVariable(name = "id") Long id);
}
