package org.sfeir.pandemik.domain.usecases.fetch;

import org.sfeir.pandemik.domain.entities.PatientEntity;

import java.util.List;
import java.util.Optional;

public interface GetPatientUseCase {

    Optional<PatientEntity> getByFirstName(String firstName);
    List<PatientEntity> getAll();
    Optional<PatientEntity> getByFullName(String firstName, String lastName);
    List<PatientEntity> getAllByTerritory(String territory);
    List<PatientEntity> getAllByInfection(String infection);
    List<PatientEntity> getAllByTerritoryInfectedBy(String territory, String infection);
}
