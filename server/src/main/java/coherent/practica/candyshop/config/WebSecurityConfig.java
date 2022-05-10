package coherent.practica.candyshop.config;

import coherent.practica.candyshop.model.User;
import coherent.practica.candyshop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    JwtTokenGenerator jwtTokenGenerator;
    SecurityProperties securityProperties;
    UserService userService;

    public WebSecurityConfig(JwtTokenGenerator jwtTokenGenerator, SecurityProperties securityProperties, UserService userService) {
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.securityProperties = securityProperties;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/candies").hasRole("ADMIN")
                .antMatchers("/candies/**").hasRole("ADMIN")
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokenGenerator, securityProperties,userService));
    }

    // Function to encode the password
    // assign to the particular roles.
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}