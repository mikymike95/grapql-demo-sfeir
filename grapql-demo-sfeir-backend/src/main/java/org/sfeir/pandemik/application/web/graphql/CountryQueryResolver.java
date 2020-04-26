package org.sfeir.pandemik.application.web.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.CountryAdapter;
import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CountryQueryResolver implements GraphQLQueryResolver {

    private final CountryAdapter countryAdapter;

    public Optional<CountryEntity> country(String name) {
        return countryAdapter.fetchByName(name);
    }

    public List<CountryEntity> countries() {
        return countryAdapter.fetchAll();
    }

    public List<CountryEntity> countriesInfectedBy(String infection) {
        return countryAdapter.fetchAllByInfection(infection);
    }
}
