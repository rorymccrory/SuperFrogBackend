package com.example.backend.config;

import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:3000")
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //let Spring Security know how to retrieve user info from system
        auth.userDetailsService(this.userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users").authenticated()
                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("director")
                .antMatchers(HttpMethod.DELETE, "/appearances/**").hasAuthority("director")
                .antMatchers(HttpMethod.GET, "/superfrogs/**").hasAuthority("director")
                .antMatchers(HttpMethod.POST, "/superfrogs/**").hasAuthority("director")
                //.antMatchers(HttpMethod.GET, "/superfrogs/{id}").hasAuthority("superfrog");
                //.antMatchers(HttpMethod.GET, "/superfrogs/{id}").hasAuthority("superfrog");
                //

                .and().formLogin().loginProcessingUrl("/users/login");
        http.csrf().disable();
        http.headers().frameOptions().disable();






    }
}
