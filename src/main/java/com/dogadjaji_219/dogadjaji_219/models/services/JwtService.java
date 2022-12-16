package com.dogadjaji_219.dogadjaji_219.models.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.repositories.UserRepository;
import com.helpers.JwtRequest;
import com.helpers.JwtResponse;
import com.helpers.JwtUtil;

@Service
public class JwtService implements UserDetailsService{

    @Autowired
    private UserRepository _UserRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public JwtResponse createJwtToken (JwtRequest jwtRequest) throws Exception{
        String email = jwtRequest.getEmail();
        String userPassword = jwtRequest.getPassword();
        authenticate(email, userPassword);

        UserDetails userDetails = loadUserByUsername(email);
        String newGeneratedTokens = jwtUtil.generateToken(userDetails);

        JwtResponse response = new JwtResponse(newGeneratedTokens);

        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = _UserRepository.getByEmail(username);

        if(user != null){
            return (UserDetails) new User(user.getEmail(), user.getPassword(), getAuthority(user));
        }else{
            throw new UsernameNotFoundException("Nije pronađen korisnik " + username);
        }
    }

    private Set getAuthority(User user){
        Set <SimpleGrantedAuthority> authorities = new HashSet<>();

        authorities.add(SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));

        return authorities;
    }

    private SimpleGrantedAuthority SimpleGrantedAuthority(String string) {
        return null;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        }catch(DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        }catch(BadCredentialsException e){
            throw new Exception("INVALID_CREDITENTIALS", e);
        }
    }
}

