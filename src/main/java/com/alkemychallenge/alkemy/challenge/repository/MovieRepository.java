package com.alkemychallenge.alkemy.challenge.repository;

import com.alkemychallenge.alkemy.challenge.model.Movie;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

}
