package com.alkemychallenge.alkemy.challenge.controller;


import com.alkemychallenge.alkemy.challenge.dto.CharacterDto;
import com.alkemychallenge.alkemy.challenge.dto.CharacterDtoNameImage;
import com.alkemychallenge.alkemy.challenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @GetMapping("")
    public ResponseEntity<List<CharacterDtoNameImage>> getAll() {
        List<CharacterDtoNameImage> characterDtoList = this.characterService.getAll();
        return ResponseEntity.ok().body(characterDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable(name = "id") Long id) {
        CharacterDto characterDto = this.characterService.getOne(id);
        return ResponseEntity.ok().body(characterDto);
    }

    @PostMapping("")
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody CharacterDto character){
        CharacterDto characterDto = characterService.createCharacter(character);
        return ResponseEntity.ok().body(characterDto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CharacterDto> modify(@RequestBody CharacterDto character, @PathVariable Long id) throws Exception {
        CharacterDto characterDto = characterService.updateCharacter(character, id);
        return ResponseEntity.ok().body(characterDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        this.characterService.deleteCharacter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
