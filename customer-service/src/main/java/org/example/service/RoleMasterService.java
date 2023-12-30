package org.example.service;


import org.example.dto.Response;
import org.example.dto.RoleDto;
import org.example.globalException.RoleAlreadyExisitsException;
import org.example.globalException.RoleNotFoundException;
import org.example.model.RoleMaster;
import org.example.repository.RoleMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RoleMasterService {

    @Autowired
    RoleMasterRepository roleMasterRepository;

    @Autowired
    public ModelMapper mapper;

    public Response createRoleMaster(final RoleDto roleDto) {
        Optional<RoleMaster> role = roleMasterRepository.findByRoleType(roleDto.getRoleType());
        if (role.isPresent()) {
            throw new RoleAlreadyExisitsException();
        }
        roleMasterRepository.save(mapper.map(roleDto, RoleMaster.class));
        return new Response(HttpStatus.OK.value(), Constants.ROLE_CREATED_SUCCESSFULLY);
    }

    public Response<RoleDto> getRoleById(final Long roleId, String type) {
        Optional<RoleMaster> role = roleMasterRepository.findById(roleId);
        if (!role.isPresent()) {
            throw new RoleNotFoundException();
        }


        if (Constants.ROLE.equals(type)) {
            role.get().setUserDetails(null);
        }
        return new Response(HttpStatus.OK.value(), mapper.map(role.get(), RoleDto.class));


    }

    public Response<RoleDto> getRole() {
        List<RoleMaster> role = roleMasterRepository.findAll();
        if (role.isEmpty()) {
            throw new RoleNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), Arrays.asList(mapper.map(role, RoleDto[].class)));


    }

}
