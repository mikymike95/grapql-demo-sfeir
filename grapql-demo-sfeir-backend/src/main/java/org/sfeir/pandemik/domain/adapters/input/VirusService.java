package org.sfeir.pandemik.domain.adapters.input;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.sfeir.pandemik.domain.usecases.fetch.GetVirusUseCase;
import org.sfeir.pandemik.domain.usecases.mutate.RegisterVirusUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VirusService implements VirusAdapter {

    private final RegisterVirusUseCase registerVirusUseCase;
    private final GetVirusUseCase getVirusUseCase;

    @Override
    public Optional<VirusEntity> fetchByName(String name) {
        return getVirusUseCase.getByName(name);
    }

    @Override
    public List<VirusEntity> fetchAll() {
        return getVirusUseCase.getAll();
    }

    @Override
    public VirusEntity save(VirusEntity entity) {
        return registerVirusUseCase.register(entity);
    }
}
