package com.lby.solarAndLunarCalender;

import com.lby.solarAndLunarCalender.Utils.LunarConverter;
import com.lby.solarAndLunarCalender.Utils.SolarConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
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
            assertThrows(ArrayIndexOutOfBoundsException.class, ()->lunarSolarConverter.lunarYearToGanZhi(input));
        }
    }

    @Nested
    class LunarToSolar{
        @ParameterizedTest
        @CsvSource({"2018-11-30, 2019-01-05"})
        void normal(@ConvertWith(LunarConverter.class) Lunar input,
                    @ConvertWith(SolarConverter.class) Solar expected){
            Solar res = LunarSolarConverter.LunarToSolar(input);
            assertEquals(expected, res);
        }

        @ParameterizedTest
        @CsvSource({"2018-11-40",
                    "2018-18-20",
                    "2018-13-45"})
        void outOfBound(@ConvertWith(LunarConverter.class) Lunar input){
            assertThrows(Exception.class, ()->LunarSolarConverter.LunarToSolar(input));
        }
    }


    @Nested
    class SolarToLunar{
        @ParameterizedTest
        @CsvSource({"2019-01-05, 2018-11-30"})
        void normal(@ConvertWith(SolarConverter.class) Solar input,
                    @ConvertWith(LunarConverter.class) Lunar expected){
            Lunar res = LunarSolarConverter.SolarToLunar(input);
            assertEquals(expected, res);
        }

        @ParameterizedTest
        @CsvSource({"2018-11-40",
                "2018-18-20",
                "2018-13-45"})
        void outOfBound(@ConvertWith(SolarConverter.class) Solar input){
            assertThrows(Exception.class, ()->LunarSolarConverter.SolarToLunar(input));
        }
    }

}