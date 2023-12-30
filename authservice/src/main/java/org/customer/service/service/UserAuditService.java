package org.customer.service.service;


import org.customer.service.repository.UserAuditRepository;
import org.customer.service.entity.UserAuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuditService {


    @Autowired
    UserAuditRepository userAuditRepo;


    public void saveUserAudit(UserAuditEntity userAuditEntity) {
        userAuditRepo.save(userAuditEntity);
    }

    public int getUserAuditCount(Integer userId) {
        return userAuditRepo.getUserAuditCount(userId);
    }

    public void deleteUserAudit(Integer userId) {
        userAuditRepo.deleteUserAudit(userId);
    }
}
