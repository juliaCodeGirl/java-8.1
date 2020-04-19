package ru.netology.domain;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/dataForInc.csv")
    void increaseCurrentTemperature(boolean on, int currentTemperature, int maxTemperature, int expected) {
        Condition conditioner = new Condition();
        conditioner.setOn(on);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.increaseCurrentTemperature();

        assertEquals(expected, conditioner.getCurrentTemperature());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataForDec.csv")
    void decreaseCurrentTemperature(boolean on, int currentTemperature, int minTemperature, int expected) {
        Condition conditioner = new Condition();
        conditioner.setOn(on);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.setMinTemperature(minTemperature);
        conditioner.decreaseCurrentTemperature();

        assertEquals(expected, conditioner.getCurrentTemperature());
    }
}