package org.sfeir.pandemik.domain.usecases.mutate;

import org.sfeir.pandemik.domain.entities.CountryEntity;

public interface RegisterCountryUseCase {

    CountryEntity register(CountryEntity entity);
}
