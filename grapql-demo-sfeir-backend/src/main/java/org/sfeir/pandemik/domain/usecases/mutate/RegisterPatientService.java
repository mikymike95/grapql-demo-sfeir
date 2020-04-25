package org.sfeir.pandemik.domain.usecases.mutate;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.PatientPersistenceAdapter;
import org.sfeir.pandemik.domain.adapters.output.CountryPersistenceAdapter;
import org.sfeir.pandemik.domain.adapters.output.VirusPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class RegisterPatientService implements RegisterPatientUseCase {

    private final PatientPersistenceAdapter patientPersistenceAdapter;
    private final CountryPersistenceAdapter countryPersistenceAdapter;
    private final VirusPersistenceAdapter virusPersistenceAdapter;

    @Override
    public PatientEntity register(PatientEntity entity) {
        Function<PatientEntity, Optional<PatientEntity>> registerPatient =
                patient -> patientPersistenceAdapter.registerPatient(entity);

        Consumer<PatientEntity> registerInfectionToTerritory =
                patient -> countryPersistenceAdapter.addInfectionToCountry(
                        patient.getAddress().getCountry(), patient.getInfection());

        Consumer<PatientEntity> registerInfection =
                patient -> virusPersistenceAdapter.registerVirus(
                        VirusEntity.builder().name(patient.getInfection()).build());

        Optional<PatientEntity> saveEntity = registerPatient.apply(entity);
        saveEntity.ifPresent(registerInfectionToTerritory);
        saveEntity.ifPresent(registerInfection);
        return saveEntity.orElseThrow();
    }
}
