package com.bbuhha.spring.rest.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@EnableWebSecurity //помечаем класс, как класс ответственный за Security конфигурацию
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder(); //дефолт шифрование

        //hardcoded
        auth.inMemoryAuthentication()
                .withUser(userBuilder
                        .username("Maxim")
                        .password("Maxim")
                        .roles("EMPLOYEE"))
                .withUser(userBuilder
                        .username("Sveta")
                        .password("Sveta")
                        .roles("HR"))
                .withUser(userBuilder
                        .username("Danila")
                        .password("Danila")
                        .roles("MANAGER", "HR"));

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }
}
