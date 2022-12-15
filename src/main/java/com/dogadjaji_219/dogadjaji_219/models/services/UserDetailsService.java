package com.dogadjaji_219.dogadjaji_219.models.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailsService {
    UserDetails loadUserByEmail(String var1) throws UsernameNotFoundException;
}
