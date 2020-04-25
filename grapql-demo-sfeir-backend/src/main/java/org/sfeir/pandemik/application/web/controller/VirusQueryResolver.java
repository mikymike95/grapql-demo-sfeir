package org.sfeir.pandemik.application.web.controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.VirusAdapter;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VirusQueryResolver implements GraphQLQueryResolver {

    private final VirusAdapter virusAdapter;

    public Optional<VirusEntity> virus(String name) {
        return virusAdapter.fetchByName(name);
    }

    public List<VirusEntity> allVirus() {
        return virusAdapter.fetchAll();
    }

}
