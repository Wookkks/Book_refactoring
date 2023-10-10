package com.book.check.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.book.check.config.oauth.PrincipalOAuth2UserService;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final PrincipalOAuth2UserService principalOAuth2UserService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/js/**", "/css/**", "/img/**", "/icon/**", "/test/**")
                .permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest()
                .authenticated()
                
            .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/user/main")
                .failureForwardUrl("/user/main")
                
            .and()
                .oauth2Login()
                .loginPage("/user/login")
                .defaultSuccessUrl("/user/main")
                .userInfoEndpoint()
                .userService(principalOAuth2UserService);

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/user/main");

        return http.build();
    }
}
