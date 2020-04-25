package org.sfeir.pandemik.domain.usecases.fetch;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.CountryPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetCountryService implements GetCountryUseCase {

    private final CountryPersistenceAdapter countryPersistenceAdapter;

    @Override
    public Optional<CountryEntity> getByName(String name) {
        return countryPersistenceAdapter.getCountryByName(name);
    }

    @Override
    public List<CountryEntity> getAll() {
        return countryPersistenceAdapter.getAll();
    }

    @Override
    public List<CountryEntity> getAllByInfection(String infection) {
        return countryPersistenceAdapter.getAllByInfection(infection);
    }
}
