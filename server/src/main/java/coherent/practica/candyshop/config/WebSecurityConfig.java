package coherent.practica.candyshop.config;

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

    public WebSecurityConfig(JwtTokenGenerator jwtTokenGenerator, SecurityProperties securityProperties) {
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.securityProperties = securityProperties;
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
                .antMatchers("/candies").hasRole("USER")
                .antMatchers("/candies/{categoryName}").hasRole("USER")
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokenGenerator, securityProperties));
    }

    // Function to encode the password
    // assign to the particular roles.
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}