package org.sfeir.pandemik.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "virus")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VirusEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String vaccine;
    @Indexed
    private String origin;
}
