package org.sfeir.pandemik.infrastructure.adapters.mongo.repository;

import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VirusRepository extends MongoRepository<VirusEntity, String> {

    Optional<VirusEntity> findByName(String name);
}
