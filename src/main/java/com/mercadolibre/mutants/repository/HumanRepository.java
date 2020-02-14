package com.mercadolibre.mutants.repository;

import com.mercadolibre.mutants.model.Human;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends MongoRepository<Human, String> {
}
