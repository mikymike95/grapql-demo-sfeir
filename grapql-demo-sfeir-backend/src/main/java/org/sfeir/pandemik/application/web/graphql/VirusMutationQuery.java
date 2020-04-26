package org.sfeir.pandemik.application.web.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.VirusAdapter;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VirusMutationQuery implements GraphQLMutationResolver {

    private final VirusAdapter virusAdapter;

    public VirusEntity registerVirus(String name, String origin, String vaccine) {
        return virusAdapter.save(
                VirusEntity.builder().name(name).origin(origin).vaccine(vaccine).build());
    }
}
