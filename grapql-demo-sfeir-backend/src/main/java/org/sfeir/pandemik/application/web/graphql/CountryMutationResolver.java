package org.sfeir.pandemik.application.web.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.CountryAdapter;
import org.sfeir.pandemik.domain.common.composites.Location;
import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryMutationResolver implements GraphQLMutationResolver {

    private final CountryAdapter countryAdapter;

    public CountryEntity registerCountry(String name, Float longitude, Float latitude) {
        return countryAdapter.save(new CountryEntity(name, new Location(longitude, latitude)));
    }
}
