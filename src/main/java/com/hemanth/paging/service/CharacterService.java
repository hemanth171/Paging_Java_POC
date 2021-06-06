package com.hemanth.paging.service;

import com.hemanth.paging.model.MovieCharacter;

import java.util.List;

public interface CharacterService {

    List<MovieCharacter> findByIdAndNameAndMovie(String id, String name, String movie);
}
