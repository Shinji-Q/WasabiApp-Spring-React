package com.wassabi.wassabiapp.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    
    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(getPasswordEncoder() ); //provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        // auth.userDetailsService(customUserDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        // .cors().and().csrf().disable()
        .csrf().disable()
        .authorizeRequests()
                .antMatchers("/cliente").authenticated()
                .antMatchers(HttpMethod.GET,"/produto/cat/**").permitAll()
                .antMatchers(HttpMethod.GET,"/produto/**").authenticated()
                .antMatchers(HttpMethod.GET,"/venda/**").authenticated()
                .antMatchers("/usuario").authenticated()

                .antMatchers("/").permitAll()
                .and().formLogin()
                    .loginPage("http://localhost:80/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("http://localhost:80/")
                    .failureUrl("http://localhost:80/login?error=true")
                
            ;
                
    }

    @Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
    
    @Bean
    public PasswordEncoder getPasswordEncoder() { 
        return NoOpPasswordEncoder.getInstance();
    }
}
