package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.CharacterDto;
import com.alkemychallenge.alkemy.challenge.dto.CharacterDtoNameImage;
import com.alkemychallenge.alkemy.challenge.dto.MovieDto;

import javax.validation.Valid;
import java.util.List;

public interface MovieService {

    MovieDto createMovie(@Valid MovieDto createMovie );
    void deleteMovie(Long id);
    MovieDto updateMovie(@Valid MovieDto movieDto, Long id) throws Exception;
    List<MovieDto> getAll();
    MovieDto getOne(Long id);
}
