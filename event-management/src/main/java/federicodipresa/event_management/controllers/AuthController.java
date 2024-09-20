package federicodipresa.event_management.controllers;

import federicodipresa.event_management.dto.AuthRequest;
import federicodipresa.event_management.dto.AuthResponse;
import federicodipresa.event_management.security.JwtUtil;
import federicodipresa.event_management.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new Exception("Invalid username or password", e);
        }
        final String jwt = jwtUtil.generateToken(authRequest.getUsername());
        return new AuthResponse(jwt);
    }
}
