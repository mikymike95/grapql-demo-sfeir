package org.sfeir.pandemik.domain.adapters.input;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.sfeir.pandemik.domain.usecases.fetch.GetPatientUseCase;
import org.sfeir.pandemik.domain.usecases.mutate.RegisterPatientUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientService implements PatientAdapter {

    private final RegisterPatientUseCase registerPatientUseCase;
    private final GetPatientUseCase getPatientUseCase;

    @Override
    public Optional<PatientEntity> fetchByName(String name) {
        return getPatientUseCase.getByFirstName(name);
    }

    @Override
    public List<PatientEntity> fetchAll() {
        return getPatientUseCase.getAll();
    }

    @Override
    public PatientEntity save(PatientEntity entity) {
        return registerPatientUseCase.register(entity);
    }

    @Override
    public Optional<PatientEntity> fetchByFullName(String firstName, String lastName) {
        return getPatientUseCase.getByFullName(firstName, lastName);
    }

    @Override
    public List<PatientEntity> fetchByTerritory(String territory) {
        return getPatientUseCase.getAllByTerritory(territory);
    }

    @Override
    public List<PatientEntity> fetchByInfection(String infection) {
        return getPatientUseCase.getAllByInfection(infection);
    }

    @Override
    public List<PatientEntity> fetchByTerritoryInfectedBy(String territory, String infection) {
        return getPatientUseCase.getAllByTerritoryInfectedBy(territory, infection);
    }
}
