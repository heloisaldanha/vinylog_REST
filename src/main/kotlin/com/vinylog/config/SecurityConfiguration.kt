package com.vinylog.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailsService: UserDetailsService
) {

    fun configure(http: HttpSecurity?) {
        http?.authorizeHttpRequests()?.anyRequest()?.authenticated()?.
        and()?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)?.
        and()?.formLogin()?.disable()?.httpBasic()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    fun configureAuthenticator(auth: AuthenticationManagerBuilder?) {
        auth
            ?.userDetailsService(userDetailsService)?.passwordEncoder(bCryptPasswordEncoder())
    }
}