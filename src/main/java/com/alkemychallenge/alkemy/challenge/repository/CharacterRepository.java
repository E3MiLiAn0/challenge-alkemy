package com.alkemychallenge.alkemy.challenge.repository;

import com.alkemychallenge.alkemy.challenge.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {

     List<Character> findByName(String name);

    List<Character> findByAge(Integer age);
}
