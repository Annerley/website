package com.example.demo.repo;

import com.example.demo.models.Article;
import com.example.demo.models.Creature;
import com.example.demo.models.CreatureView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface CreatureRepository extends CrudRepository<Creature, Long> {
    @Query("select b from Creature b where b.name = :name")
    ArrayList<Creature> findByName(@Param("name") String name);

}
