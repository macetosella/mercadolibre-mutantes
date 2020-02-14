package com.mercadolibre.mutants.repository;

import com.mercadolibre.mutants.model.Mutant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends MongoRepository<Mutant, String> {
}
