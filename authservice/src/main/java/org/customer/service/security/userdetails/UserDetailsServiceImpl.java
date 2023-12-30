package org.customer.service.security.userdetails;

import org.customer.service.repository.UserRepository;
import org.customer.service.entity.UserEntity;
import org.customer.service.exception.UserAccountLockedException;
import org.customer.service.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Autowired
    LoginAttemptService loginAttemptService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (loginAttemptService.isBlocked(username))
            throw new UserAccountLockedException("Account is locked");
        Optional<UserEntity> user = repository.findByUserName(username);
        return user.map(UserDetailsImpl::new).orElseGet(this::guestUser);
    }

    private UserDetailsImpl guestUser() {
        UserEntity guestUser = new UserEntity();
        guestUser.setUserName("GUEST");
        guestUser.setPassword("GUEST");
        return new UserDetailsImpl(guestUser, new HashSet<GrantedAuthority>(Collections.singletonList(new SimpleGrantedAuthority("GUEST"))));
    }
}
