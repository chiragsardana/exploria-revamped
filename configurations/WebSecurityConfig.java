package com.devnologix.exploria_backend.configurations;

import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    private final UnauthorizedEntryPoint unauthorizedEntryPoint;

    public WebSecurityConfig(UnauthorizedEntryPoint unauthorizedEntryPoint) {
        this.unauthorizedEntryPoint = unauthorizedEntryPoint;
    }

    // @Bean
    // public BCryptPasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder();
    // }
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(bcryptEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {
                })
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/users/authenticate", "/users/register", "/", "/Dish/get",
                                "/Dish/getAllDishByCategory/**", "/Dish/getById/**",
                                "/Dish/getAllDishByRating/**", "/Dish/getAllDishByPrice/**",
                                "/Resturant/get", "/Resturant/getById/**",
                                "/Resturant/getResturantsByRating/**",
                                "/Rating/get", "/Rating/getById/**",
                                "/Rating/getAllRatingByDishId/**", "/Rating/getAllRatingByResturantId/**",
                                "/Rating/getAllRatingByUserId/**", "/Dish/getAllDishByResturantId/**",
                                "/Dish/getAllDishBySearch/**",
                                "/Resturant/getRestaurantBySearch/**",
                                "/Resturant/getResturantsByCost/**",
                                "/Resturant/getResturantsByDeliveryTime/**",
                                "/Resturant/getResturantsByCuisine/**",
                                "/Resturant/getAllCuisines",
                                "/api/preferences",
                                "/api/preferences/**",
                                "/Resturant/top12")
                        .permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(unauthorizedEntryPoint))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() {
        return new JwtAuthenticationFilter();
    }
}
