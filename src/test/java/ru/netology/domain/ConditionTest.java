package ru.netology.domain;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {
    Condition conditioner = new Condition();

    @ParameterizedTest
    @CsvFileSource(resources = "/dataForInc.csv")
    void increaseCurrentTemperature(boolean on, int maxTemperature,int minTemperature, int currentTemperature, int expected) {
        conditioner.setOn(on);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.increaseCurrentTemperature();

        assertEquals(expected, conditioner.getCurrentTemperature());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataForDec.csv")
    void decreaseCurrentTemperature(boolean on, int minTemperature,int maxTemperature, int currentTemperature, int expected) {
        conditioner.setOn(on);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.decreaseCurrentTemperature();

        assertEquals(expected, conditioner.getCurrentTemperature());
    }
}