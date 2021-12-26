package com.shved.storage.dto.army;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Army {

    private String name;

    private ArmyType type;

}
