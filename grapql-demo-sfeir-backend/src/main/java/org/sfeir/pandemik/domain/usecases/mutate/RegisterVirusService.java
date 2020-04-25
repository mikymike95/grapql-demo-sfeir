package org.sfeir.pandemik.domain.usecases.mutate;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.output.VirusPersistenceAdapter;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterVirusService implements RegisterVirusUseCase {

    private final VirusPersistenceAdapter virusPersistenceAdapter;

    @Override
    public VirusEntity register(VirusEntity entity) {
        return virusPersistenceAdapter.registerVirus(entity);
    }
}
