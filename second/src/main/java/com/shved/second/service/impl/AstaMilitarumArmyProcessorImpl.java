package com.shved.second.service.impl;

import com.shved.second.service.ArmyProcessor;
import com.shved.storage.dto.army.Army;
import com.shved.storage.dto.army.ArmyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AstaMilitarumArmyProcessorImpl implements ArmyProcessor {

    private final static ArmyType ARMY_TYPE = ArmyType.ASTRA_MILITARUM;

    @Override
    public void processArmy(Army army) {

    }

    @Override
    public boolean isSupports(ArmyType armyType) {
        return ARMY_TYPE.equals(armyType);
    }

}
