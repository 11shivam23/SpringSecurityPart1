package com.banking.backendApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        ////below is the custom security configurations

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/myAccount/**","myBalance","myLoans","/myCards").authenticated()
                .requestMatchers("/notices", "/contact").permitAll()
        );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();


        ////deny all http request configuration

//        http.authorizeHttpRequests((requests) -> requests
//                        .anyRequest().denyAll()
//        );
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();


        ////permit all configuration

//        http.authorizeHttpRequests((requests) -> requests
//                .anyRequest().permitAll()
//        );
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();
    }
}
