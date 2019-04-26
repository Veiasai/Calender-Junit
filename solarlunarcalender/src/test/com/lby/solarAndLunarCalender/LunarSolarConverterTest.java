package com.lby.solarAndLunarCalender;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LunarSolarConverterTest {

    static LunarSolarConverter lunarSolarConverter;

    @BeforeAll
    static void Initialization() {
        lunarSolarConverter = new LunarSolarConverter();
    }

    @Test
    void lunarYearToGanZhi() {
        String r = lunarSolarConverter.lunarYearToGanZhi(100);

        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertEquals("Wrong", r);
    }

    @Test
    void lunarToSolar() {
    }

    @Test
    void solarToLunar() {
    }

}