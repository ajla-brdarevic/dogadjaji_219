package com.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.dogadjaji_219.dogadjaji_219.models.services.UserDetailsService;
import com.helpers.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class JwtRequestFilter implements Filter {
    
    @Autowired
     private UserDetailsService _UserDetailsService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                //dohvaća vrijednost zaglavlja zahtjeva za autorizaciju iz parametra zahtjeva
                final String requestTokenHeader = ((HttpServletRequest) request).getHeader("Authorization");
                String email = null;
                String jwtToken = null;
            
                /*provjerava sadrži li varijabla requestTokenHeader JWT token i, ako je tako, izdvaja token iz varijable requestTokenHeader 
                i pokušava izdvojiti email korisnika iz tokena pokušava izvući adresu e-pošte korisnika iz JWT tokena pozivanjem metode 
                getUsernameFromToken objekta jwtUtil i prosljeđivanjem varijable jwtToken*/

                    if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                        jwtToken = requestTokenHeader.substring(7);
                        try {
                            email = jwtUtil.getUsernameFromToken(jwtUtil);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Unable to get JWT Token");
                        } catch (ExpiredJwtException e) {
                            System.out.println("JWT Token has expired");
                        }
                    } 

                /*provjerava jesu li email i JWT token uspješno izvućeni iz zaglavlja zahtjeva za autorizaciju i da li je korisnik već autentificiran
                i potvrđuje JWT token pomoću metode validateToken objekta jwtUtil, kojoj se prosljeđuju varijabla jwtToken i objekt userDetails*/
                
                    if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        UserDetails userDetails = this._UserDetailsService.loadUserByEmail(email);
            
                        if (jwtUtil.validateToken(jwtToken, userDetails)) {
                            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                            usernamePasswordAuthenticationToken
                                    .setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
                            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                        }
                    }
                    chain.doFilter(request, response);
                }        

}
