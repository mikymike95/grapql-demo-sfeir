package org.sfeir.pandemik.domain.adapters.input;

import java.util.List;
import java.util.Optional;

public interface CommonAdapter<T> {

    Optional<T> fetchByName(String name);
    List<T> fetchAll();
    T save(T entity);
}
