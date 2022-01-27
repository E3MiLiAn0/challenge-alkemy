package com.alkemychallenge.alkemy.challenge.auth.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDetalleDto {

    @NotNull
    private String password;

    @Email(message = "Mail error")
    private String username;
}
