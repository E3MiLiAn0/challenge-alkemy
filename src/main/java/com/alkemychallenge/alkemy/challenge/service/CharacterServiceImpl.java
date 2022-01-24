package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.CharacterDto;
import com.alkemychallenge.alkemy.challenge.dto.CharacterDtoNameImage;
import com.alkemychallenge.alkemy.challenge.model.Character;
import com.alkemychallenge.alkemy.challenge.repository.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import java.util.stream.Collectors;
import java.util.List;

@Service
@Validated
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public CharacterDto createCharacter(CharacterDto characterDto) {
        Character characterEntity = modelMapper.map(characterDto, Character.class);
         characterRepository.save(characterEntity);
        return modelMapper.map(characterEntity, CharacterDto.class);
    }

    @Override
    public List<CharacterDtoNameImage> getAll() {
        List<Character> characterList= characterRepository.findAll();
        List<CharacterDtoNameImage> characterDtoList= characterList
                .stream()
                .map(character -> modelMapper
                        .map(character,CharacterDtoNameImage.class))
                .collect(Collectors.toList());
        return characterDtoList;
    }

    @Override
    public CharacterDto getOne(Long id) {
        Character characterEntity = characterRepository.getById(id);
        CharacterDto characterDto=modelMapper.map(characterEntity,CharacterDto.class);
        return characterDto;
    }

    @Override
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CharacterDto updateCharacter(CharacterDto characterDto, Long id) throws Exception{
        Character characterEntity = modelMapper.map(characterDto, Character.class);
        try{

            Character characterEntityBuscado= characterRepository.getById(id);
            characterEntityBuscado.setName(characterEntity.getName());
            characterEntityBuscado.setAge(characterEntity.getAge());
            characterEntityBuscado.setWeight(characterEntity.getWeight());
            characterEntityBuscado.setImage(characterEntity.getImage());
            characterEntityBuscado.setHistory(characterEntity.getHistory());
            characterEntityBuscado.setMovies(characterEntity.getMovies());

            characterRepository.save(characterEntityBuscado);
            return modelMapper.map(characterEntity, CharacterDto.class);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
