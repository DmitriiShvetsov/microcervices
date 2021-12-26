package com.shved.second.service;

import com.shved.storage.dto.army.Army;
import com.shved.storage.dto.army.ArmyType;

public interface ArmyProcessor {

    void processArmy(Army army);

    boolean isSupports(ArmyType army);

}
