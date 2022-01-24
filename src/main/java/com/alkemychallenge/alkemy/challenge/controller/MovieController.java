package com.alkemychallenge.alkemy.challenge.controller;


import com.alkemychallenge.alkemy.challenge.dto.CharacterDto;
import com.alkemychallenge.alkemy.challenge.dto.CharacterDtoNameImage;
import com.alkemychallenge.alkemy.challenge.dto.MovieDto;
import com.alkemychallenge.alkemy.challenge.service.CharacterService;
import com.alkemychallenge.alkemy.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public ResponseEntity<List<MovieDto>> getAll() {
        List<MovieDto> movieDtoList = this.movieService.getAll();
        return ResponseEntity.ok().body(movieDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable(name = "id") Long id) {
        MovieDto movieDto = this.movieService.getOne(id);
        return ResponseEntity.ok().body(movieDto);
    }

    @PostMapping("")
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movie){
        MovieDto movieDto = movieService.createMovie(movie);
        return ResponseEntity.ok().body(movieDto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto movie, @PathVariable Long id) throws Exception {
        MovieDto movieDto = movieService.updateMovie(movie, id);
        return ResponseEntity.ok().body(movieDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(name = "id") long id) {
        this.movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
