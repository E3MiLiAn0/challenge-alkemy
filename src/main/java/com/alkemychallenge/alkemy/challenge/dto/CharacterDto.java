package com.alkemychallenge.alkemy.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CharacterDto {
    private Long id;
    private String image;
    @NotBlank
    private String name;
}
