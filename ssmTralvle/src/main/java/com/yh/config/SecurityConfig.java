package com.yh.config;


import com.yh.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    UserService userService;
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //自定义表单登录页面
            http.formLogin()
                    //指定登录页面
                    .loginPage("/to/login")
                    //指定登录请求
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successForwardUrl("/to/index")
                    .failureUrl("/to/failer")
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/to/login")
                    .invalidateHttpSession(true) //是否清除session
                    .and()
                    //权限配置
                    .authorizeRequests()
                    //放行 登录页面
                    .antMatchers("/to/login","/to/failer").permitAll()
                    //放开 静态资源
                    .antMatchers("/css/**","/img/**","/js/**","/plugins/**").permitAll()
                    //其他 资源需要登录后访问
                    .anyRequest().authenticated()
                    .and()
                    //禁用csrf
                    .csrf().disable();
            //没有权限
            http.exceptionHandling().accessDeniedPage("/to/403");
        }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}