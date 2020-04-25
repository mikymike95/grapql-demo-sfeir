package org.sfeir.pandemik.infrastructure.adapters.mongo.repository;

import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<PatientEntity, String> {

    Optional<PatientEntity> getByFirstName(String firstName);

    Optional<PatientEntity> getByFirstNameAndLastName(String firstName, String lastName);

    List<PatientEntity> findAllByInfection(String infection);

    List<PatientEntity> findAllByAddress_Country(String country);

    List<PatientEntity> findByAddress_CountryAndInfection(String country, String infection);
}
