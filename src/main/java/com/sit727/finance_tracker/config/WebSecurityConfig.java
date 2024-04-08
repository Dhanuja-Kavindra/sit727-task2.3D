package com.sit727.finance_tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    // Define a bean for the PasswordEncoder to use BCrypt hashing algorithm
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configure the security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            //.csrf().disable() // Disable CSRF protection for simplicity (consider re-enabling it for production)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/css/**", "/js/**").permitAll() // Allow access to these paths without authentication
                .anyRequest().authenticated()) // Require authentication for any other request
            .formLogin(form -> form
                .loginPage("/login") // Specify the login page URL
                .defaultSuccessUrl("/financeTracker", true) // Redirect to this URL after successful login
                .permitAll()) // Allow everyone to access the login page
            .logout(logout -> logout
                .permitAll() // Allow everyone to access the logout page
                .logoutSuccessUrl("/login?logout")); // Redirect to the login page with a query parameter indicating successful logout

        return http.build();
    }
}