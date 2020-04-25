package org.sfeir.pandemik.domain.usecases.fetch;

import org.sfeir.pandemik.domain.entities.CountryEntity;

import java.util.List;
import java.util.Optional;

public interface GetCountryUseCase {

    Optional<CountryEntity> getByName(String name);
    List<CountryEntity> getAll();
    List<CountryEntity> getAllByInfection(String name);
}
