package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.MovieDto;
import com.alkemychallenge.alkemy.challenge.model.Movie;
import com.alkemychallenge.alkemy.challenge.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movieEntity = modelMapper.map(movieDto, Movie.class);
        movieRepository.save(movieEntity);
        return modelMapper.map(movieEntity, MovieDto.class);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    @Transactional
    public MovieDto updateMovie(MovieDto movieDto, Long id) throws Exception {
        Movie movieEntity = modelMapper.map(movieDto, Movie.class);

        try {
            Movie movieEntityBuscado= movieRepository.getById(id);
            movieEntityBuscado.setIdMovie(movieEntity.getIdMovie());
            movieEntityBuscado.setCharacters(movieEntity.getCharacters());
            movieEntityBuscado.setCreatedDate(movieEntity.getCreatedDate());
            movieEntityBuscado.setImage(movieEntity.getImage());
            movieEntityBuscado.setGender(movieEntity.getGender());
            movieEntityBuscado.setQualification(movieEntity.getQualification());
            movieEntityBuscado.setTitle(movieEntity.getTitle());

            movieRepository.save(movieEntityBuscado);
            return modelMapper.map(movieEntity,MovieDto.class);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public List<MovieDto> getAll() {
        List<Movie> movieList= movieRepository.findAll();
        List<MovieDto> movieDtoList= movieList
                .stream()
                .map(movie -> modelMapper
                        .map(movie,MovieDto.class))
                .collect(Collectors.toList());
        return movieDtoList;
    }

    @Override
    public MovieDto getOne(Long id) {
        Movie movieEntity = movieRepository.getById(id);
        MovieDto movieDto=modelMapper.map(movieEntity,MovieDto.class);
        return movieDto;
    }
}
