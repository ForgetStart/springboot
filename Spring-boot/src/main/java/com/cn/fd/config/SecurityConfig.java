/**
 * 
 */
package com.cn.fd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cn.fd.security.CustomUserDetailsService;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月23日 下午5:02:22
 */
@Configuration
@EnableWebSecurity 
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Override  
    protected void configure(AuthenticationManagerBuilder auth)  
            throws Exception {  
        auth.userDetailsService(userDetailsService());  
    }  

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()	//访问：/home 无需登录认证权限  
                .anyRequest().authenticated()			//其他所有资源都需要认证，登陆后访问  
                .and()
            .formLogin()
                .loginPage("/login")					//指定登录页是”/login” 
                .defaultSuccessUrl("/helloadmin")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}
