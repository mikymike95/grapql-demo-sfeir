package org.sfeir.pandemik.domain.usecases.mutate;

import org.sfeir.pandemik.domain.entities.VirusEntity;

public interface RegisterVirusUseCase {

    VirusEntity register(VirusEntity entity);
}
