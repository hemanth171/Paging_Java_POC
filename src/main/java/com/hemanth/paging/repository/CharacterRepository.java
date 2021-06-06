package com.hemanth.paging.repository;

import com.hemanth.paging.model.MovieCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CharacterRepository extends JpaRepository<MovieCharacter, Integer> {

    Page<MovieCharacter> findByName(String name, Pageable pageable);

    Page<MovieCharacter> findAll(Pageable pageable);

//    @Query("SELECT new com.hemanth.paging.model.MovieCharacter(mc.id, mc.name, mc.movie) from MovieCharacter mc where mc.id=:id AND mc.name=:name AND mc.movie=:movie")
//    List<MovieCharacter> findById(@Param("id") Integer id, @Param("name") String name, @Param("movie") String movie);

//    List<MovieCharacter> findByIdAndNameAndMovie(String id, String name, String movie);
}
