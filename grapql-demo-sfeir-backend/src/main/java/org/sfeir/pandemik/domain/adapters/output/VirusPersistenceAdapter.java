package org.sfeir.pandemik.domain.adapters.output;

import org.sfeir.pandemik.domain.entities.VirusEntity;

import java.util.List;
import java.util.Optional;

public interface VirusPersistenceAdapter {

    VirusEntity registerVirus(VirusEntity entity);
    Optional<VirusEntity> getVirusByName(String name);
    List<VirusEntity> getAllVirus();
}
