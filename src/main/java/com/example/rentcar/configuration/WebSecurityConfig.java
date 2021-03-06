package com.example.rentcar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private UserPrincipalDetailsServices userPrincipalDetailsServices;

    public WebSecurityConfig(UserPrincipalDetailsServices userPrincipalDetailsServices) {
        this.userPrincipalDetailsServices = userPrincipalDetailsServices;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());


//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN").authorities("ACCESS_TEST1", "ACCESS_TEST2","ROLE_ADMIN")
//                .and()
//                .withUser("janek")
//                .password(passwordEncoder().encode("janek"))
//                .roles("USER")
//                .and()
//                .withUser("menago")
//                .password(passwordEncoder().encode("menago"))
//                .roles("MANAGER").authorities("ACCESS_TEST1","ROLE_MANAGER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/home.html", "/register").permitAll()
                .antMatchers("/service","/manage-cars","/addCar","/manage-cars").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/admin","/manage-user","/manage-users").hasRole("ADMIN")
                .antMatchers("/all", "/prepare-order", "/orders-history","/updateOrder").authenticated()
                .antMatchers("/orderManager").hasAuthority("ACCESS_TEST1")
                .antMatchers("/api/public/users").hasRole("ADMIN")
//                .and().exceptionHandling().accessDeniedPage("/WEB-INF/view/accessDenied.jsp")
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and()
                .formLogin()
                .loginPage("/login2")
//                .loginProcessingUrl("/home")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home");


    }


    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }


    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsServices);

        return daoAuthenticationProvider;

    }

}



