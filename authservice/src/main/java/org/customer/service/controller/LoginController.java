package org.customer.service.controller;


import org.customer.service.entity.ResponseModel;
import org.customer.service.service.LoginService;
import org.customer.service.repository.TokenDetailRepository;
import org.customer.service.repository.UserInformation;
import org.customer.service.security.dao.LoginDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/customer")
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    LoginService customerService;

    @Autowired
    TokenDetailRepository repo;

    @PostMapping("/login")
    private ResponseEntity<UserInformation> login(@Validated @RequestBody LoginDao login) {
        log.info("customer login for username{}" + login.getUserName());
        return customerService.customerlogin(login);

    }


    @GetMapping("/home")
    private ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome to TCL!!!", HttpStatus.OK);
    }

    @GetMapping("/get")
    private ResponseEntity<String> getString() {
        return new ResponseEntity<>("Welcome to Gatewayservice!!!", HttpStatus.OK);
    }

    @GetMapping("/signOut")
    private ResponseEntity<ResponseModel> signOut(@RequestParam String token) {
        return customerService.signOut(token);
    }


}
