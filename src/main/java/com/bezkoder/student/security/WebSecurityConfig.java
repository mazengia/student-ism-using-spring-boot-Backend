package com.bezkoder.student.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bezkoder.student.security.jwt.AuthEntryPointJwt;
import com.bezkoder.student.security.jwt.AuthTokenFilter;
import com.bezkoder.student.security.services.UserDetailsServiceImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    // securedEnabled = true,
    // jsr250Enabled = true,
    prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  UserDetailsServiceImpl userDetailsService;
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers(
            "/swagger-ui/**",
            "/v3/api-docs/**"
    );
  }
  private static final String[] SWAGGER_WHITELIST = {
          "/swagger-ui/**",
          "/v3/api-docs/**",
          "/configuration/ui",
          "/swagger-resources/**",
          "/webjars/**",
          "/configuration/security",
          "/swagger-ui.html",
          "/api/auth/signin"

  };
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

    @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .authorizeRequests()
            .mvcMatchers(SWAGGER_WHITELIST).permitAll()
      .anyRequest().authenticated();

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
  }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();

      configuration.setAllowedOrigins(Arrays.asList("http://10.1.12.70:4900","http://localhost:4200"));
      configuration.setAllowedMethods(
              Arrays.asList(
                      "GET",
                      "POST",
                      "OPTIONS",
                      "DELETE",
                      "PUT",
                      "PATCH")
      );
      configuration.setAllowedHeaders(
              Arrays.asList(
                      "X-XSRF-TOKEN",
                      "X-Requested-With",
                      "Origin",
                      "Content-Type",
                      "Accept",
                      "Authorization"
              )
      );
      configuration.setAllowCredentials(true);
      configuration.setExposedHeaders(
              Collections.singletonList("Authorization")
      );
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
    }
}
