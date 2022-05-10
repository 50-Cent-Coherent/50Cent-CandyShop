package coherent.practica.candyshop.config;

import coherent.practica.candyshop.model.CustomUserDetails;
import coherent.practica.candyshop.model.User;
import coherent.practica.candyshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    JwtTokenGenerator jwtTokenGenerator;
    SecurityProperties securityProperties;
    UserService userService;
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtTokenGenerator jwtTokenGenerator, SecurityProperties securityProperties, UserService userService) {
        super(authenticationManager);
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.securityProperties = securityProperties;
        this.userService= userService;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String jwtToken = request.getHeader(securityProperties.getHeaderString());

        if (jwtToken != null && jwtToken.startsWith(securityProperties.getTokenPrefix())) {
            try {
                Authentication authentication = verifyJwtToken(jwtToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (SignatureVerificationException | TokenExpiredException ex) {
                log.error(ex.getMessage());
            }
        }

        chain.doFilter(request, response);

    }

    private Authentication verifyJwtToken(String jwtToken) {
        String userName = jwtTokenGenerator.getAccountFromToken(jwtToken);
//        userService.findBYusername(username);
        CustomUserDetails customUserDetails = new CustomUserDetails(userService.getUserByUsername(userName));
        return new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
    }
}
