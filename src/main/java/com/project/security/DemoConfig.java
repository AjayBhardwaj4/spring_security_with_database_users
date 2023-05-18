package com.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DemoConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ajay")
                .password("Ajay1234")
                .authorities("qa")
                .and()
                .withUser("kartik")
                .password("Kartik1234")
                .authorities("dev");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/qa/**").hasAuthority("qa")
                .antMatchers("/dev/**").hasAuthority("dev")
                .antMatchers("/accessserver/**").hasAnyAuthority("dev", "qa")
                .antMatchers("/home").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    PasswordEncoder getPE() {
        return NoOpPasswordEncoder.getInstance();
    }
}
