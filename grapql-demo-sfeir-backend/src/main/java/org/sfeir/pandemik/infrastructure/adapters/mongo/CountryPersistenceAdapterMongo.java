package org.sfeir.pandemik.infrastructure.adapters.mongo;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.CountryPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.sfeir.pandemik.infrastructure.adapters.mongo.repository.CountryRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class CountryPersistenceAdapterMongo implements CountryPersistenceAdapter {

    private final CountryRepository countryRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public Optional<CountryEntity> getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public Optional<CountryEntity> saveCountry(CountryEntity entity) {
        if (!countryRepository.existsByName(entity.getName())) {
            return Optional.of(countryRepository.save(entity));
        }
        return countryRepository.findByName(entity.getName());
    }

    @Override
    public List<CountryEntity> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public List<CountryEntity> getAllByInfection(String infection) {
        return countryRepository.findAllByInfectionsContains(infection);
    }

    @Override
    public void addInfectionToCountry(String countryName, String infection) {
        if (countryRepository.existsByName(countryName)) {
            Optional<CountryEntity> entity = countryRepository.findByName(countryName);
            if (entity.isPresent()) {
                CountryEntity countryEntity = entity.get();
                boolean infectionExists = !isEmpty(countryEntity.getInfections()) && countryEntity.getInfections().stream().anyMatch(i -> i.equalsIgnoreCase(infection));
                if (!infectionExists) {
                   List<String> infections = isEmpty(countryEntity.getInfections()) ? new ArrayList<>() : countryEntity.getInfections();
                   infections.add(infection);
                    countryEntity.setInfections(infections);
                   countryRepository.save(countryEntity);
                }

            }
        } else {
            countryRepository.save(CountryEntity.builder().name(countryName).infections(List.of(infection)).build());
        }
    }

}
