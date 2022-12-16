package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /*http.securityMatcher("/api/**") postavlja sigurnost za podudaranje za objekt HttpSecurity, koji određuje koji su URL-ovi zaštićeni 
    sigurnosnom konfiguracijom koja slijedi, "/api/**" znači da će svi URL-ovi koji počinju s "/api/" biti zaštićeni sigurnosnom konfiguracijom
    Unutar lambda izraza metoda requestMatchers poziva se dvaput kako bi se definirala sigurnosna pravila za URL-ove "/users/" i "/roles/"
    Metoda anyRequest().authenticated() poziva se za postavljanje sigurnosnog pravila za sve ostale URL-ove*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

    http.securityMatcher("/api/**")
        .authorizeHttpRequests(auth -> auth
        .requestMatchers("/users/**").hasRole("user")
        .requestMatchers("/roles/**").hasRole("admin")
        .anyRequest().authenticated()).csrf().disable();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
