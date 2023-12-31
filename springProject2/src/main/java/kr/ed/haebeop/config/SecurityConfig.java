package kr.ed.haebeop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder pwEncoder() {return new BCryptPasswordEncoder();}
}
