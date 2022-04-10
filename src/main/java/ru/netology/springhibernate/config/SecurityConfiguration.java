package ru.netology.springhibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Master").password("{noop}password").roles("READ", "WRITE", "DELETE")
                .and()
                .withUser("Hacker").password("{noop}holybible").roles("WRITE", "DELETE")
                .and()
                .withUser("Assistant").password("{noop}assword").roles("READ", "WRITE")
                .and()
                .withUser("Guest").password("{noop}gword").roles("READ")
                .and()
                .withUser("Slave").password("{noop}psw").roles("WRITE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and().authorizeRequests()
                        .antMatchers("/persons/add")
                        .permitAll()

                .and().authorizeRequests()
                        .antMatchers("/persons/delete")
                        .hasAnyRole("DELETE")

                .and().authorizeRequests()
                        .anyRequest()
                        .authenticated();
    }

}
