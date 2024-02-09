package com.jwt.example.config;

import com.jwt.example.models.Emp;
import com.jwt.example.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Autowired
    EmpRepo empRepo;

    @Bean
    public UserDetailsService userDetailService() {
        List<Emp> empList = empRepo.findAll();
        UserDetails newUser = null;
        List<UserDetails> userList = new ArrayList<>();
        for (Emp emp : empList) {
            newUser = User.builder().username(emp.getUsername()).password(passwordEncoder().encode(emp.getPassword())).roles("ADMIN").build();
            userList.add(newUser);
        }
        // UserDetails user = User.builder().username("harsh").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
        //  UserDetails user1 = User.builder().username("varun").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(userList);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
