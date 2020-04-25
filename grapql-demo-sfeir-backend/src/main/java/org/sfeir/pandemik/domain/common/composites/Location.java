package org.sfeir.pandemik.domain.common.composites;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Location {
    private final Float longitude;
    private final Float latitude;
}
