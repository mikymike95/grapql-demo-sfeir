package org.sfeir.pandemik.domain.adapters.input;

import org.sfeir.pandemik.domain.entities.PatientEntity;

import java.util.List;
import java.util.Optional;

public interface PatientAdapter extends CommonAdapter<PatientEntity> {

    Optional<PatientEntity> fetchByFullName(String firstName, String lastName);
    List<PatientEntity> fetchByTerritory(String territory);
    List<PatientEntity> fetchByInfection(String infection);
    List<PatientEntity> fetchByTerritoryInfectedBy(String territory, String infection);
}
