package org.sfeir.pandemik.domain.adapters.output;

import org.sfeir.pandemik.domain.entities.CountryEntity;

import java.util.List;
import java.util.Optional;

public interface CountryPersistenceAdapter {

    void addInfectionToCountry(String territoryName, String infection);
    Optional<CountryEntity> getCountryByName(String name);
    Optional<CountryEntity> saveCountry(CountryEntity entity);
    List<CountryEntity> getAll();
    List<CountryEntity> getAllByInfection(String infection);
}
