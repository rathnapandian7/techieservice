package org.customer.service.service;


import org.customer.service.repository.TokenDetailRepository;
import org.customer.service.entity.TokenDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenValidation {

    @Autowired
    TokenDetailRepository tokenDetailRepository;

    public Integer validateToken(String header) {
        TokenDetailEntity token = tokenDetailRepository.findByToken(header);
        if (token == null)
            return null;
        if (null == token.getIsRemember() || 0 == token.getIsRemember()) {
            if (LocalDateTime.now().isAfter(token.getTokenExpiryTime())) {
                tokenDetailRepository.delete(token);
                return null;
            }
            LocalDateTime tokenExtendTime = token.getTokenExpiryTime().minusMinutes(5);
            if (tokenExtendTime.isBefore(LocalDateTime.now())) {
                token.setTokenExpiryTime(LocalDateTime.now().plusMinutes(15));
                tokenDetailRepository.save(token);
            }
        }
        return token.getUserId();
    }
}
