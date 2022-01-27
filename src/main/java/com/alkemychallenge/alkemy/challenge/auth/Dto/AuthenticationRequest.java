package com.alkemychallenge.alkemy.challenge.auth.Dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthenticationRequest {
    private String username;
    private String password;
}
