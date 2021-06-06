package com.hemanth.paging.Impl;

import com.hemanth.paging.model.MovieCharacter;
import com.hemanth.paging.service.CharacterService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CharacterServiceImpl implements CharacterService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MovieCharacter> findByIdAndNameAndMovie(String id, String name, String movie) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<MovieCharacter> criteria = builder.createQuery(MovieCharacter.class);
        Root<MovieCharacter> characterRoot = criteria.from(MovieCharacter.class);

        List<Predicate> predicateList = new ArrayList<>();

        if (id != null && !id.isEmpty()) {
            Predicate condition = builder.equal(characterRoot.get("id"), Integer.valueOf(id));
            predicateList.add(condition);
            //criteria.where(builder.equal(characterRoot.get("id"), Integer.valueOf(id)));
        }
        if (name != null && !name.isEmpty()) {
            Predicate condition = builder.equal(characterRoot.get("name"), name);
            predicateList.add(condition);
            //criteria.where(builder.equal(characterRoot.get("name"), name));
        }
        if (movie != null && !movie.isEmpty() ) {
            Predicate condition = builder.equal(characterRoot.get("movie"), movie);
            predicateList.add(condition);
            //criteria.where(builder.equal(characterRoot.get("movie"), movie));
        }

        if(!predicateList.isEmpty()){
            Predicate[] pArray = predicateList.toArray(new Predicate[]{});
            Predicate predicate = builder.and(pArray);
            criteria.where(predicate);
        }

        return em.createQuery(criteria).getResultList();
    }
}
