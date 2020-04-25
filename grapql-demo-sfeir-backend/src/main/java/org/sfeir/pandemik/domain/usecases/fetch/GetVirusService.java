package org.sfeir.pandemik.domain.usecases.fetch;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.VirusPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetVirusService implements GetVirusUseCase {

    private final VirusPersistenceAdapter virusPersistenceAdapter;

    @Override
    public Optional<VirusEntity> getByName(String name)
    {
        return virusPersistenceAdapter.getVirusByName(name);
    }

    @Override
    public List<VirusEntity> getAll() {
        return virusPersistenceAdapter.getAllVirus();
    }
}
