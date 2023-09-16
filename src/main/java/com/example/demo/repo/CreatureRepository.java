package com.example.demo.repo;

import com.example.demo.models.Article;
import com.example.demo.models.Creature;
import org.springframework.data.repository.CrudRepository;

public interface CreatureRepository extends CrudRepository<Creature, Long> {
    
}
