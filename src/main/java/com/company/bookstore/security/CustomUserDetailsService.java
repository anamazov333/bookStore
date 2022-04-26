package com.company.bookstore.security;


import com.company.bookstore.entity.Role;
import com.company.bookstore.entity.User;
import com.company.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private  final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), mapRolesToAuthorities(user.getRoleId()));
    }

//    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Role role){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
//
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        log.info("in here");
        log.info(role.getName());
        return Collections.singleton(new SimpleGrantedAuthority(role.getName()));

    }
}
