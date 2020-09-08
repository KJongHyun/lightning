package com.jonghyeon.lightning.infra.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .mvcMatchers("/", "/login", "/sign-up", "/check-emil-token",
                "/email-login", "/login-by-email").permitAll()
                .anyRequest().authenticated()

        http.formLogin()
                .loginPage("/login").permitAll()

        http.logout()
                .logoutSuccessUrl("/")

    }
}