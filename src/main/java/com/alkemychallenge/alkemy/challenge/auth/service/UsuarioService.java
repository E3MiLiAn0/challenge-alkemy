package com.alkemychallenge.alkemy.challenge.auth.service;


import com.alkemychallenge.alkemy.challenge.auth.Dto.UsuarioDetalleDto;
import com.alkemychallenge.alkemy.challenge.auth.model.Usuario;
import com.alkemychallenge.alkemy.challenge.auth.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.Collections;


@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;
    /*@Autowired
    private EmailService emailService;*/
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario userEntity = userRepository.findByUsername(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or password not fount");
        }
        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

    public boolean save(UsuarioDetalleDto userDTO) {
        Usuario userEntity = new Usuario();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        String password = passwordEncoder.encode(userDTO.getPassword());
        userEntity.setPassword(password);
        userEntity = this.userRepository.save(userEntity);
      /*  if (userEntity != null) {
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }*/
        return userEntity != null;
    }


}
