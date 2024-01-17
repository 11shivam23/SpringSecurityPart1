package com.banking.backendApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/myAccount","myBalance","myLoans","/myCards").authenticated()
                .requestMatchers("/notices", "/contact", "/register").permitAll()
        );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetails() {
//
//        //Approach1 :- use default password encoder
//
////        UserDetails admin = User.withDefaultPasswordEncoder()
////                .username("Shivam")
////                .password("1234")
////                .authorities("admin")
////                .build();
////
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("Chavi")
////                .password("1234")
////                .authorities("read")
////                .build();
////        return new InMemoryUserDetailsManager(admin,user);
//
//
//        //Approach 2 -: NoOpPasswordEncoder
//
//        UserDetails admin = User.withUsername("Shivam")
//                .password("1234")
//                .authorities("admin")
//                .build();
//
//        UserDetails user = User.withUsername("Chavi")
//                .password("1234")
//                .authorities("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }


//       //Approach 3 -: Using JDBC user details manager

//    @Bean
//    public JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
