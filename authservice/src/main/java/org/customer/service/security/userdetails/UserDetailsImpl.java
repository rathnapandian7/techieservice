package org.customer.service.security.userdetails;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.customer.service.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private UserEntity user;
    private Collection<GrantedAuthority> authorities = new HashSet<>();


    public UserDetailsImpl(UserEntity user) {
        this(user, new HashSet<>());
    }

    public UserDetailsImpl(UserEntity user, HashSet<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities.addAll(authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
