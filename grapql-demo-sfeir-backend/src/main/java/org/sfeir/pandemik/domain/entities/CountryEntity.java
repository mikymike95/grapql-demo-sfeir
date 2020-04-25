package org.sfeir.pandemik.domain.entities;

import lombok.*;
import org.sfeir.pandemik.domain.common.composites.Location;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "country")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CountryEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Location location;
    private List<String> infections;

    public CountryEntity(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
