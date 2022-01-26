package com.alkemychallenge.alkemy.challenge.repository;

import com.alkemychallenge.alkemy.challenge.model.Gender;
import com.alkemychallenge.alkemy.challenge.model.Movie;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query(
            value = "SELECT * FROM movie WHERE movie.title LIKE %:name%",
            nativeQuery = true
    )
    List<Movie> getMovieByNameList(@Param("name") String name);

    @Query(
            value = "SELECT * FROM movie WHERE movie.gender_id LIKE %:idGender%",
            nativeQuery = true
    )
    List<Movie> getMovieByIdGenderList(@Param("idGender") Long idGender);


}
