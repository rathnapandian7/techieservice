package org.example.controller;

import org.example.dto.Response;
import org.example.dto.RoleDto;
import org.example.service.RoleMasterService;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleMasterController {
    @Autowired
    RoleMasterService roleMasterService;


    @PostMapping("/createRole")
    public Response createRoleMaster(@RequestBody final RoleDto roleDto) {
        return roleMasterService.createRoleMaster(roleDto);
    }

    @GetMapping("/getRole")
    public Response<RoleDto> getRole() {
        return roleMasterService.getRole();
    }

    @GetMapping("/getRoleById")
    public Response<RoleDto> getRoleById(@RequestParam final Long roleId) {
        return roleMasterService.getRoleById(roleId, Constants.ROLE);

    }

    @GetMapping("/getUserByRoleId")
    public Response<RoleDto> getUserDetails(@RequestParam final Long roleId) {
        return roleMasterService.getRoleById(roleId, Constants.USER);
    }


}
