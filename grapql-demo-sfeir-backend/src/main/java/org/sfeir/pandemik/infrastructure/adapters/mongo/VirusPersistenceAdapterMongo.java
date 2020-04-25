package org.sfeir.pandemik.infrastructure.adapters.mongo;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.VirusPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.sfeir.pandemik.infrastructure.adapters.mongo.repository.VirusRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VirusPersistenceAdapterMongo implements VirusPersistenceAdapter {

    private final VirusRepository virusRepository;

    @Override
    public VirusEntity registerVirus(VirusEntity entity) {
        if (!virusRepository.exists(Example.of(entity))) {
            return virusRepository.save(entity);
        }
        return virusRepository.findByName(entity.getName()).orElseThrow();
    }

    @Override
    public Optional<VirusEntity> getVirusByName(String name) {
        return virusRepository.findByName(name);
    }

    @Override
    public List<VirusEntity> getAllVirus() {
        return virusRepository.findAll();
    }
}
