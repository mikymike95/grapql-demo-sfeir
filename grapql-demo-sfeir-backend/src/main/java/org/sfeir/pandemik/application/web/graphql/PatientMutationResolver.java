package org.sfeir.pandemik.application.web.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.PatientAdapter;
import org.sfeir.pandemik.domain.common.composites.City;
import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientMutationResolver implements GraphQLMutationResolver {

    private final PatientAdapter patientAdapter;

    public PatientEntity registerPatient(String firstName, String lastName, String city, String country, String infection) {
        return patientAdapter.save(
                PatientEntity.builder().firstName(firstName)
                .lastName(lastName)
                .address(new City(city, country)).infection(infection).build()
        );
    }
}
