package org.sfeir.pandemik.domain.common.composites;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private String name;
    private String country;
}
