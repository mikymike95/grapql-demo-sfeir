package org.sfeir.pandemik.domain.adapters.output;

import org.sfeir.pandemik.domain.entities.PatientEntity;

import java.util.List;
import java.util.Optional;

public interface PatientPersistenceAdapter {

    Optional<PatientEntity> registerPatient(PatientEntity patient);
    Optional<PatientEntity> getPatientByName(String name);
    Optional<PatientEntity> getByFullName(String firstName, String lastName);
    List<PatientEntity> getAll();
    List<PatientEntity> getAllByCountry(String country);
    List<PatientEntity> getAllByInfection(String infection);
    List<PatientEntity> getAllByCountryInfectedBy(String country, String infection);
}
