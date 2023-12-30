package org.example.controller;

import org.example.dto.CustomerDto;
import org.example.dto.Response;
import org.example.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    public static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService service;


    @PostMapping("/createCustomer")
    public Response createCustomer(@RequestBody final CustomerDto customerDto) throws Exception {
        return service.createCustomer(customerDto);
    }

    @GetMapping("/getCustomerById")
    public Response getCustomerDetailsById(@RequestParam final Long customerId) throws Exception {
        return service.getCustomerDetailsById(customerId);
    }

    @GetMapping("/getCustomer")
    public Response getCustomerDetails() throws Exception {
        return service.getCustomerDetails();
    }


    @GetMapping("/getUserbyCustomerId")
    public Response getUserBycustomerId(@RequestParam Long customerId) throws Exception {
        return service.getUserDetails(customerId);
    }
}
