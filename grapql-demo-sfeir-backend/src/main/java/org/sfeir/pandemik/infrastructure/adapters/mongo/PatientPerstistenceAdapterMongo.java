package org.sfeir.pandemik.infrastructure.adapters.mongo;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.PatientPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.sfeir.pandemik.infrastructure.adapters.mongo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientPerstistenceAdapterMongo  implements PatientPersistenceAdapter {

    private final PatientRepository patientRepository;
    @Override
    public Optional<PatientEntity> registerPatient(PatientEntity patient) {
        return Optional.of(patientRepository.save(patient));
    }

    @Override
    public Optional<PatientEntity> getPatientByName(String name) {
        return patientRepository.getByFirstName(name);
    }

    @Override
    public Optional<PatientEntity> getByFullName(String firstName, String lastName) {
        return patientRepository.getByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<PatientEntity> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public List<PatientEntity> getAllByCountry(String territory) {
        return patientRepository.findAllByAddress_Country(territory);
    }

    @Override
    public List<PatientEntity> getAllByInfection(String infection) {
        return patientRepository.findAllByInfection(infection);
    }

    @Override
    public List<PatientEntity> getAllByCountryInfectedBy(String territory, String infection) {
        return patientRepository.findByAddress_CountryAndInfection(territory, infection);
    }
}
