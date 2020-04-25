package org.sfeir.pandemik.domain.adapters.input;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.sfeir.pandemik.domain.usecases.fetch.GetCountryUseCase;
import org.sfeir.pandemik.domain.usecases.mutate.RegisterCountryUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CountryService implements CountryAdapter {

    private final GetCountryUseCase getCountryUseCase;
    private final RegisterCountryUseCase registerCountryUseCase;

    @Override
    public Optional<CountryEntity> fetchByName(String name) {
        return getCountryUseCase.getByName(name);
    }

    @Override
    public List<CountryEntity> fetchAll() {
        return getCountryUseCase.getAll();
    }

    @Override
    public CountryEntity save(CountryEntity entity) {
        return registerCountryUseCase.register(entity);
    }

    @Override
    public List<CountryEntity> fetchAllByInfection(String infection) {
        return getCountryUseCase.getAllByInfection(infection);
    }
}
