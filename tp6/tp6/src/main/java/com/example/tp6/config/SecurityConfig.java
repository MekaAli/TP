package com.example.tp6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/new", "/users/delete/**").hasRole("ADMIN")
                .requestMatchers("/users", "/").authenticated()
            )
            .formLogin(form -> form
            .loginPage("/login") // Your custom login page
            .defaultSuccessUrl("/users", true) // Redirect after successful login
            .permitAll() // Allow everyone to access the login page
        )
        
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
            .and()
            .withUser("user")
                .password(passwordEncoder().encode("user123"))
                .roles("USER");
    }
}
