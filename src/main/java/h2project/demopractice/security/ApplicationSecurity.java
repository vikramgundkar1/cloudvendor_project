package h2project.demopractice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class ApplicationSecurity {


    @Bean
    public InMemoryUserDetailsManager UserDetails()

    {
        User.UserBuilder users=User.withDefaultPasswordEncoder();
        UserDetails userOne=users
                .username("user")
                .password("user")
                .roles("user")
                .build();

        UserDetails userTwo=users
                .username("admin")
                .password("admin")
                .roles("Admin")
                .build();
        return new InMemoryUserDetailsManager(userOne, userTwo);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("");
        return http.build();
    }




}
