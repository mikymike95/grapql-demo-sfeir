package org.sfeir.pandemik.domain.usecases.mutate;

import org.sfeir.pandemik.domain.entities.PatientEntity;

public interface RegisterPatientUseCase {

    PatientEntity register(PatientEntity entity);
}
