package org.sfeir.pandemik.domain.usecases.fetch;

import org.sfeir.pandemik.domain.entities.VirusEntity;

import java.util.List;
import java.util.Optional;

public interface GetVirusUseCase {

    Optional<VirusEntity> getByName(String name);
    List<VirusEntity> getAll();
}
