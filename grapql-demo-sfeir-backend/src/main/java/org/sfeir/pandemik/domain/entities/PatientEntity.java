package org.sfeir.pandemik.domain.entities;

import lombok.*;
import org.sfeir.pandemik.domain.common.composites.City;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@CompoundIndex(def = "{'firstName': 1, 'lastName': 1}", unique = true)
public class PatientEntity {

    @Id
    private String id;
    @Indexed
    private String firstName;
    @Indexed
    private String lastName;
    private City address;
    @Indexed
    private String infection;
}
