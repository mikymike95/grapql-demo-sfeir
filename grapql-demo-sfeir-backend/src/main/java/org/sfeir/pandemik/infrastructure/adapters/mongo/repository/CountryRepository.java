package org.sfeir.pandemik.infrastructure.adapters.mongo.repository;

import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends MongoRepository<CountryEntity, String> {

    Optional<CountryEntity> findByName(String name);

    boolean existsByName(String name);

    List<CountryEntity> findAllByInfectionsContains(String infections);

}
