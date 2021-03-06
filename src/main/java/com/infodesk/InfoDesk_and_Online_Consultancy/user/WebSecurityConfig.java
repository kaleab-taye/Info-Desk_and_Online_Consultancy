package com.infodesk.InfoDesk_and_Online_Consultancy.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/newRegisteredUser").permitAll()
            .antMatchers("/reg").permitAll()
            .antMatchers("/images/signup-image.jpg").permitAll()
            .antMatchers("/fonts/material-icon/css/material-design-iconic-font.min.css").permitAll()
            .antMatchers("/fonts/**").permitAll()
            .antMatchers("/css/style.css").permitAll()
            .antMatchers("/js/main.js").permitAll()
            .antMatchers("/newRegisteredUserL").permitAll()
            .antMatchers("/register_success").permitAll()
            // .antMatchers("/").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/user").hasAnyAuthority("USER")
            .antMatchers("/user/**").hasAnyAuthority("USER")
            .antMatchers("/admin/**").hasAnyAuthority("ADMIN")

            // .antMatchers("/admin").permitAll()


            .antMatchers("/admin").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .successHandler(successHandler).permitAll()
            // .defaultSuccessUrl("/list")
            // .loginPage("/login").permitAll()
            .usernameParameter("email")
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            ;
    }
    @Autowired
    private LoginSuccessHandler successHandler;
}