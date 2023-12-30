package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

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
