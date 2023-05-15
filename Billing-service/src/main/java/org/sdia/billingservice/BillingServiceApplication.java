package org.sdia.billingservice;

import org.sdia.billingservice.entities.Bill;
//import org.sdia.billingservice.entities.BillRepository;
import org.sdia.billingservice.entities.ProductItem;
//import org.sdia.billingservice.entities.ProductItemRepository;
import org.sdia.billingservice.feign.CustomerServiceClient;
import org.sdia.billingservice.feign.InventoryServiceClient;
import org.sdia.billingservice.model.Customer;
import org.sdia.billingservice.model.Product;
import org.sdia.billingservice.repository.BillRepository;
import org.sdia.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication

@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
                            InventoryServiceClient inventoryServiceClient, CustomerServiceClient customerServiceClient){
        return args -> {
            //Bill bill=new Bill();
            //bill.setBillingDate(new Date());
            Customer customer=customerServiceClient.findCustomerById(1L);
            //bill.setCustomerID(customer.getId());
            //billRepository.save(bill);
            //inventoryServiceClient.findAll().getContent().forEach(p->{
              //  productItemRepository.save(new ProductItem(null,1,p.getId(),p.getPrice(),bill,new Product()));
           // });
            System.out.println("*************************");
            System.out.println(customer.getId());
            System.out.println(customer.getName());
            System.out.println(customer.getEmail());
        };
    }}

















