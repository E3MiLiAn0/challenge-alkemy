package com.alkemychallenge.alkemy.challenge.dto;

import com.alkemychallenge.alkemy.challenge.model.Character;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto {


    private Long idMovie;
    private String image;

    private String title;

    private LocalDate createdDate;
    private Integer qualification;
    private List<CharacterDto> characters;
}
