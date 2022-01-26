package com.alkemychallenge.alkemy.challenge.controller;


import com.alkemychallenge.alkemy.challenge.dto.MovieDto;
import com.alkemychallenge.alkemy.challenge.dto.MovieDetalleDto;
import com.alkemychallenge.alkemy.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<MovieDetalleDto> getMovie(@Valid @PathVariable(name = "id") Long id) {
        MovieDetalleDto movieDetalleDto = this.movieService.getOne(id);
        return ResponseEntity.ok().body(movieDetalleDto);
    }

    @PostMapping("")
    public ResponseEntity<MovieDetalleDto> createMovie(@Valid @RequestBody MovieDetalleDto movie){
        MovieDetalleDto movieDetalleDto = movieService.createMovie(movie);
            return ResponseEntity.ok().body(movieDetalleDto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<MovieDetalleDto> updateMovie(@Valid @RequestBody MovieDetalleDto movie, @PathVariable Long id) throws Exception {
        MovieDetalleDto movieDetalleDto = movieService.updateMovie(movie, id);
        return ResponseEntity.ok().body(movieDetalleDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@Valid @PathVariable(name = "id") long id) {
        this.movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
