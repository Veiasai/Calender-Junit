package com.lby.solarAndLunarCalender;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LunarSolarConverterTest {

    static LunarSolarConverter lunarSolarConverter;

    @BeforeAll
    static void Initialization() {
        lunarSolarConverter = new LunarSolarConverter();
    }

    @Nested
    class LunarYearToGanZhi{
        @ParameterizedTest
        @CsvSource({"5,乙丑年", "8,戊辰年"})
        void normal(int input, String output) {
            String r = lunarSolarConverter.lunarYearToGanZhi(input);

            // In a grouped assertion all assertions are executed, and any
            // failures will be reported together.
            assertEquals(output, r);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        void outOfBound(int input) {
            assertThrows(ArrayIndexOutOfBoundsException.class, ()->{lunarSolarConverter.lunarYearToGanZhi(input);});
        }
    }

    @Test
    void lunarToSolar() {

    }

    @Test
    void solarToLunar() {
    }

}