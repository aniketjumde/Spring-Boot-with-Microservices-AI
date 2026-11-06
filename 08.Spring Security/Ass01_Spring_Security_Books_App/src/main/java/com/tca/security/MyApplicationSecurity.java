package com.tca.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyApplicationSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                authorize -> authorize.requestMatchers(HttpMethod.GET,"/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE,"/{id}").hasAnyRole("ADMIN")
                        .requestMatchers("/create").hasAnyRole("USER")

        ).httpBasic(Customizer.withDefaults()); // To Produce Login Diale Box

        http.csrf(csrf->csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){

        UserDetails admin= User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin@123"))
                .roles("ADMIN")
                .build();

        UserDetails users=User.builder()
                .username("users")
                .password(passwordEncoder().encode("users@123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin,users);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
