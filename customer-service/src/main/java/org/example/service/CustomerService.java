package org.example.service;

import org.example.dto.CustomerDto;
import org.example.dto.Response;
import org.example.dto.UserResponseDto;
import org.example.globalException.CustomerExisitsException;
import org.example.globalException.CustomerNotFound;
import org.example.globalException.InternalException;
import org.example.model.CustomerDetails;
import org.example.repository.CustomerDetailsRespository;
import org.example.repository.UserMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    public CustomerDetailsRespository customerRepo;

    @Autowired
    public ModelMapper mapper;
    @Autowired
    public UserMasterRepository userRepo;

    public Response getCustomerDetailsById(final Long cusId) {

        Optional<CustomerDetails> customerDetails = customerRepo.findById(cusId);
        if (!customerDetails.isPresent()) {
            throw new CustomerNotFound();
        }
        return new Response(HttpStatus.OK.value(), mapper.map(customerDetails.get(), CustomerDto.class));

    }

    public Response getCustomerDetails() {

        List<CustomerDetails> customerDetails = customerRepo.findAll();
        if (customerDetails.isEmpty()) {
            throw new CustomerNotFound();
        }

        return new Response(HttpStatus.OK.value(), Arrays.asList(mapper.map(customerDetails, CustomerDto[].class)));

    }

    public Response createCustomer(final CustomerDto CustomerDto) {
        Optional<CustomerDetails> customerDetailsModel = customerRepo.findByCustomerName(CustomerDto.getCustomerName());
        if (customerDetailsModel.isPresent()) {
            throw new CustomerExisitsException();
        }
        saveCustomerDetails(CustomerDto);
        return new Response<>(HttpStatus.OK.value(), Constants.CUSTOMER_CREATED_SCCUESSFULLY);
    }

    private void saveCustomerDetails(final CustomerDto CustomerDto) {
        try {
            CustomerDetails customerModel = mapper.map(CustomerDto, CustomerDetails.class);
            customerModel.setPrefixCUstomerId("C-" + String.valueOf(customerRepo.getCustomerSequence()));
            customerRepo.save(customerModel);
        } catch (InternalException e) {
            throw new InternalException(e.getMessage());
        }

    }

    public Response getUserDetails(final Long customerId) {
        Optional<CustomerDetails> customerDetailsModel = customerRepo.findById(customerId);
        if (!customerDetailsModel.isPresent()) {
            throw new CustomerNotFound();
        }
        return new Response(HttpStatus.OK.value(), mapper.map(customerDetailsModel.get(), UserResponseDto.class));

    }

}
