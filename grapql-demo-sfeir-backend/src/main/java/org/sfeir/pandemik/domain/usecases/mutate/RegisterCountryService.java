package org.sfeir.pandemik.domain.usecases.mutate;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.CountryPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterCountryService implements RegisterCountryUseCase {

    private final CountryPersistenceAdapter countryPersistenceAdapter;

    @Override
    public CountryEntity register(CountryEntity entity) {
        return countryPersistenceAdapter.saveCountry(entity).orElseThrow();
    }
}
