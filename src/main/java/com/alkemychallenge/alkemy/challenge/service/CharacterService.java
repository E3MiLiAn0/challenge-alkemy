package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.CharacterDto;

import javax.validation.Valid;
import java.util.List;

public interface CharacterService {

    CharacterDto createCharacter(@Valid CharacterDto characterDto );
    List<CharacterDto> getAll();
    CharacterDto getOne(Long id);
    void deleteCharacter(Long id);
    CharacterDto updateCharacter(@Valid CharacterDto characterDto, Long id) throws Exception;
}
