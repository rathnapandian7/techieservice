package org.example.controller;


import org.example.dto.Response;
import org.example.dto.UserDto;
import org.example.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDetailService service;


    @PostMapping("/createUser")
    public Response createUser(@RequestBody final UserDto userDto) throws Exception {
        return service.createUser(userDto);

    }

    @GetMapping("/getUser")
    public Response getUser() throws Exception {
        return service.getUser();

    }

    @GetMapping("/getUserById")
    public Response getUserById(@RequestParam final Long userId) throws Exception {
        return service.getUserById(userId);
    }


}
