package com.alkemychallenge.alkemy.challenge.auth.controller;

import com.alkemychallenge.alkemy.challenge.auth.Dto.AuthenticationRequest;
import com.alkemychallenge.alkemy.challenge.auth.Dto.AuthenticationResponse;
import com.alkemychallenge.alkemy.challenge.auth.Dto.UsuarioDetalleDto;
import com.alkemychallenge.alkemy.challenge.auth.service.Jwt;
import com.alkemychallenge.alkemy.challenge.auth.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    private UsuarioService userDetailsService;
    private AuthenticationManager authenticationManager;
    private Jwt jwtTokenUtil;


    @Autowired
    public UsuarioController(
            UsuarioService userDetailsService,
            AuthenticationManager authenticationManager,
            Jwt jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> singUp(@Valid @RequestBody UsuarioDetalleDto user) throws Exception {
        this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authRequest) throws Exception {

        UserDetails userDetails;
        try {
            System.out.println("Usuario entrante: "+authRequest.toString());


            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
