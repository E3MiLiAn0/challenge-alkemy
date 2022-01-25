package com.alkemychallenge.alkemy.challenge.controller;

import com.alkemychallenge.alkemy.challenge.dto.GenderDto;
import com.alkemychallenge.alkemy.challenge.dto.MovieDto;
import com.alkemychallenge.alkemy.challenge.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/genders")
public class GenderController {
    @Autowired
    private GenderService genderService;


    @GetMapping("")
    public ResponseEntity<List<GenderDto>> getAll() {
        List<GenderDto> genderDtoList = genderService.getAll();
        return ResponseEntity.ok().body(genderDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderDto> getGender(@PathVariable(name = "id") Long id) {
        GenderDto genderDto = this.genderService.getOne(id);
        return ResponseEntity.ok().body(genderDto);
    }

    @PostMapping("")
    public ResponseEntity<GenderDto> createGender(@Valid @RequestBody GenderDto gender){
        GenderDto genderDto = genderService.createGender(gender);
        return ResponseEntity.ok().body(genderDto);
    }


    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<GenderDto> updateGender(@RequestBody GenderDto gender, @PathVariable Long id)  {
        GenderDto genderDto = genderService.updateGender(gender, id);
        return ResponseEntity.ok().body(genderDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGender(@PathVariable(name = "id") long id) {
        this.genderService.deleteGender(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
