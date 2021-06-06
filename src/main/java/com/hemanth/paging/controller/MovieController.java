package com.hemanth.paging.controller;

import com.hemanth.paging.Impl.CharacterServiceImpl;
import com.hemanth.paging.model.MovieCharacter;
import com.hemanth.paging.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/movie")
public class MovieController {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    CharacterServiceImpl characterService;

    @GetMapping("/character")
    public List<MovieCharacter> findAllCharacters(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<MovieCharacter> pagedResult =  characterRepository.findAll(pageable);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return null;
        }
    }

    @GetMapping("/moviename")
    public List<MovieCharacter> findByMovieName(@RequestParam("name") String name, @PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<MovieCharacter> pagedResult = characterRepository.findByName(name, pageable);

        if (pagedResult.hasContent()) {
            System.out.println("Total Elements: " + pagedResult.getTotalElements());
            System.out.println("Total Pages: " + pagedResult.getTotalPages());
            return pagedResult.getContent();
        } else {
            return null;
        }
    }

    @GetMapping("/search")
    public List<MovieCharacter> searchBy(@RequestParam(name = "id", defaultValue = "") String id,
                                         @RequestParam(name = "name", defaultValue = "") String name,
                                         @RequestParam(name = "movie", defaultValue = "") String movie) {
        List<MovieCharacter> pagedResult = characterService.findByIdAndNameAndMovie(id, name, movie);
        return pagedResult;

//        if (pagedResult.hasContent()) {
//            return pagedResult.getContent();
//        } else {
//            return null;
//        }
    }
}
