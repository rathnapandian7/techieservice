package org.example.service;


import org.example.dto.Response;
import org.example.dto.UserDto;
import org.example.globalException.InternalException;
import org.example.globalException.UserExisitsException;
import org.example.globalException.UserNotFoundException;
import org.example.model.UserDetails;
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
public class UserDetailService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailService.class);
    @Autowired
    public UserMasterRepository userMasterRepository;
    @Autowired
    public ModelMapper mapper;

    public Response createUser(final UserDto userDto) {
        Optional<UserDetails> userDetails = userMasterRepository.findByUserName(userDto.getUserName());
        if (userDetails.isPresent()) {
            throw new UserExisitsException();
        }
        saveUserDetails(userDto);
        log.info(Constants.USER_CREATED_SCCUESSFULLY);
        return new Response(HttpStatus.OK.value(), Constants.USER_CREATED_SCCUESSFULLY);
    }

    private void saveUserDetails(UserDto userDto) {
        try {
            UserDetails userDetails = mapper.map(userDto, UserDetails.class);
            userDetails.setPrefixUserId("U-" + String.valueOf(userMasterRepository.getUserSequence()));
            userMasterRepository.save(userDetails);

        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    public Response getUserById(Long userId) {
        Optional<UserDetails> userObj = userMasterRepository.findById(userId);
        if (!userObj.isPresent()) {
            throw new UserNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), mapper.map(userObj.get(), UserDto.class));

    }

    public Response getUser() {
        List<UserDetails> userObj = userMasterRepository.findAll();
        if (userObj.isEmpty()) {
            throw new UserNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), (mapper.map(userObj, List.class)));

    }

}
