package org.sfeir.pandemik.domain.adapters.input;

import org.sfeir.pandemik.domain.entities.CountryEntity;

import java.util.List;

public interface CountryAdapter extends CommonAdapter<CountryEntity> {

    List<CountryEntity> fetchAllByInfection(String infection);
}
