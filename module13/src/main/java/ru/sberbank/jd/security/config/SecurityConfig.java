package ru.sberbank.jd.security.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.sberbank.jd.security.security.filter.AppSecurityFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final AppSecurityFilter appSecurityFilter;

    @SneakyThrows
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        return http
                .csrf(conf -> conf.disable())
                //                .httpBasic((conf) -> conf.disable())
                .formLogin((conf) -> conf.disable())
                .authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers(HttpMethod.GET, "/users/*").hasRole("USER")
                                .anyRequest().authenticated()
                )
                .addFilterAfter(appSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
