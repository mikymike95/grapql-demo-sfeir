package org.sfeir.pandemik.domain.usecases.fetch;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.PatientPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetPatientService implements GetPatientUseCase {

    private final PatientPersistenceAdapter patientPersistenceAdapter;

    @Override
    public Optional<PatientEntity> getByFirstName(String firstName) {
        return patientPersistenceAdapter.getPatientByName(firstName);
    }

    @Override
    public List<PatientEntity> getAll() {
        return patientPersistenceAdapter.getAll();
    }

    @Override
    public Optional<PatientEntity> getByFullName(String firstName, String lastName) {
        return patientPersistenceAdapter.getByFullName(firstName, lastName);
    }

    @Override
    public List<PatientEntity> getAllByTerritory(String territory) {
        return patientPersistenceAdapter.getAllByCountry(territory);
    }

    @Override
    public List<PatientEntity> getAllByInfection(String infection) {
        return patientPersistenceAdapter.getAllByInfection(infection);
    }

    @Override
    public List<PatientEntity> getAllByTerritoryInfectedBy(String territory, String infection) {
        return patientPersistenceAdapter.getAllByCountryInfectedBy(territory, infection);
    }
}
