package com.shved.second.service.impl;

import com.shved.second.service.ArmyProcessor;
import com.shved.second.service.ArmySenderService;
import com.shved.storage.dto.army.Army;
import com.shved.storage.dto.army.ArmyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArmySenderServiceImpl implements ArmySenderService {

    private final List<ArmyProcessor> armyProcessors;

    @Override
    public void sendArmy(Army army) {
        ArmyType typeOfArmy = getIncorrectTypeOfArmy(army);
        processArmy(army, typeOfArmy);
    }

    private void processArmy(Army army, ArmyType typeOfArmy) {
        armyProcessors.stream()
                .filter(armyProcessor -> armyProcessor.isSupports(typeOfArmy))
                .findFirst()
                .ifPresent(resolver -> resolver.processArmy(army));
    }

    private ArmyType getIncorrectTypeOfArmy(Army army) {
        return Optional.ofNullable(army)
                .map(Army::getType)
                .orElseGet(() -> {
                    log.error("incorrect type of army");
                    //TO DO made custom exception
                    throw new RuntimeException();
                });
    }

}
