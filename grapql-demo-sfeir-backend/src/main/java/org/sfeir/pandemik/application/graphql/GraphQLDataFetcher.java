package org.sfeir.pandemik.application.graphql;

import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.PatientAdapter;
import org.sfeir.pandemik.domain.adapters.input.CountryAdapter;
import org.sfeir.pandemik.domain.adapters.input.VirusAdapter;
import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GraphQLDataFetcher {

    private final PatientAdapter patientAdapter;
    private final VirusAdapter virusAdapter;
    private final CountryAdapter countryAdapter;

    public DataFetcher<Optional<PatientEntity>> getPatientByName() {
        return fetcher -> patientAdapter.fetchByName(fetcher.getArgument("name"));
    }

    public DataFetcher<Optional<VirusEntity>> getVirusByName() {
        return fetcher -> virusAdapter.fetchByName(fetcher.getArgument("name"));
    }

    public DataFetcher<Optional<CountryEntity>> getTerritoryByName() {
        return fetcher -> countryAdapter.fetchByName(fetcher.getArgument("name"));
    }
}
