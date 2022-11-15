package com.bbuhha.spring.rest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;


@EnableWebSecurity //помечаем класс, как класс ответственный за Security конфигурацию
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder(); //дефолт шифрование
//
//        //hardcoded
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder
//                        .username("Maxim")
//                        .password("Maxim")
//                        .roles("EMPLOYEE"))
//                .withUser(userBuilder
//                        .username("Sveta")
//                        .password("Sveta")
//                        .roles("HR"))
//                .withUser(userBuilder
//                        .username("Danila")
//                        .password("Danila")
//                        .roles("MANAGER", "HR"));

        //инфа о юзерах в бд
        auth.jdbcAuthentication().dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/api/employees").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/**").hasAnyRole("HR", "MANAGER")
                .and().formLogin().permitAll();

    }

}
