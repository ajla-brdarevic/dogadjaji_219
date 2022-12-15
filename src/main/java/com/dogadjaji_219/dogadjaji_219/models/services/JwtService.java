package com.dogadjaji_219.dogadjaji_219.models.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.repositories.UserRepository;
import com.helpers.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService implements UserDetailsService{
    private String secret;
    private long expiration;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserRepository _UserRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = _UserRepository.getByEmail(username);

        if(user != null){
            return (UserDetails) new User(user.getEmail(), user.getPassword(), getAuthority(user));
        }else{
            throw new UsernameNotFoundException("Nije pronađen korisnik " + username);
        }    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}

    
    /*@Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository _UserRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken (JwtRequest jwtRequest) throws Exception{
        String email = jwtRequest.getEmail();
        String userPassword = jwtRequest.getPassword();
        authenticate(email, userPassword);

        UserDetails userDetails = loadUserByUsername(email);
        String newGeneratedTokens = getUtil.generatedTokens(userDetails);

        JwtResponse aaa = new JwtResponse(newGeneratedToken);

        return aaa;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = _UserRepository.getByEmail(username);

        if(user != null){
            return new User(user.getEmal(), user.getPassword(), getAuthority(user));
        }else{
            throw new UsernameNotFoundException("Nije pronađen korisnik " + username);
        }
    }

    private Set getAuthority(User user){
        Set <SimpleGrantedAuthority> authorities = new HashSet<>();

        authorities.add(SimpleGrantedAuthority("ROLE_" + user.getRoles().getName()));

        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        }catch(DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        }catch(BadCredentialsException e){
            throw new Exception("INVALID_CREDITENTIALS", e);
        }
    }*/

