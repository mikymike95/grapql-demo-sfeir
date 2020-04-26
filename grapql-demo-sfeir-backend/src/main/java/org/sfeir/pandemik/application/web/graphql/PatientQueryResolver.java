package org.sfeir.pandemik.application.web.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.PatientAdapter;
import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientQueryResolver implements GraphQLQueryResolver {

    private final PatientAdapter patientAdapter;

    public Optional<PatientEntity> patient(String name) {
        return patientAdapter.fetchByName(name);
    }

    public List<PatientEntity> patients() {
        return patientAdapter.fetchAll();
    }

    public Optional<PatientEntity> patientsWithFullName(String firstName, String lastName) {
        return patientAdapter.fetchByFullName(firstName, lastName);
    }

    public List<PatientEntity> patientsByCountry(String territory) {
        return patientAdapter.fetchByTerritory(territory);
    }

    public List<PatientEntity> patientsInfectedBy(String infection) {
        return patientAdapter.fetchByInfection(infection);
    }

    public List<PatientEntity> patientsByCountryInfectedBy(String territory, String infection) {
        return patientAdapter.fetchByTerritoryInfectedBy(territory, infection);
    }
}
