package org.customer.service.service;


import org.customer.service.repository.UserRepository;
import org.customer.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginAttemptService {

    @Autowired
    UserRepository userRepository;


    public boolean isBlocked(final String key) {
        Optional<UserEntity> optionalUser = userRepository.findByUserName(key);
        if(optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            return "B".equals(user.getStatus());
        }
        return false;
    }
}
