package com.lby.solarAndLunarCalender;

import com.lby.solarAndLunarCalender.Utils.DateConverter;
import com.lby.solarAndLunarCalender.Utils.LunarConverter;
import com.lby.solarAndLunarCalender.Utils.SolarConverter;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateSolarLunarTest {

    @Nested
    class Date2Lunar{
        @ParameterizedTest
        @CsvSource({"2019-01-05, 2018-11-30",
                "2020-02-29, 2020-02-07",
                "2019-02-30, 2020-02-07"})
        void normal(@ConvertWith(DateConverter.class) Date input,
                        @ConvertWith(LunarConverter.class) Lunar expected) {

            Lunar res = DateSolarLunar.date2Lunar(input);
            System.out.println(DateSolarLunar.dump(res));
            assertEquals(expected, res);
        }

        @ParameterizedTest
        @CsvSource({"2019-02-30", "2019-13-20"})
        void outOfBound(@ConvertWith(DateConverter.class) Date input) {
            assertThrows(Exception.class, ()-> DateSolarLunar.dump(input));
        }
    }


    @Nested
    class Date2Solar{
        @ParameterizedTest
        @CsvSource({"2019-01-05, 2019-01-05"})
        void normal(@ConvertWith(DateConverter.class) Date input,
                        @ConvertWith(SolarConverter.class) Solar expected) {
            Solar res = DateSolarLunar.date2Solar(input);
            assertEquals(expected, res);
        }

        @ParameterizedTest
        @CsvSource({"2019-02-30", "2019-13-20"})
        void outOfBound(@ConvertWith(DateConverter.class) Date input) {
            assertThrows(Exception.class, ()-> DateSolarLunar.dump(input));
        }
    }


    @Nested
    class dump{
        @ParameterizedTest
        @CsvSource(delimiter = ':', value = {"2019-01-05: {isleap=false,lunarDay=5,lunarMonth=1,lunarYear=2019}"})
        void lunar(@ConvertWith(LunarConverter.class) Lunar input, String expected) {
            String res = DateSolarLunar.dump(input);
            assertEquals(expected, res);
        }

        @ParameterizedTest
        @CsvSource(delimiter = ':', value = {"2019-01-05: {solarDay=5,solarMonth=1,solarYear=2019}"})
        void solar(@ConvertWith(SolarConverter.class) Solar input, String expected) {
            String res = DateSolarLunar.dump(input);
            assertEquals(expected, res);
        }

        @ParameterizedTest
        @CsvSource(delimiter = ':', value = {"[2019-01-05, 2019-02-03]: [{isleap=false,lunarDay=5,lunarMonth=1,lunarYear=2019},{isleap=false,lunarDay=3,lunarMonth=2,lunarYear=2019}]"})
        void lunarArray(@ConvertWith(LunarConverter.class) Lunar[] input, String expected){
            String res = DateSolarLunar.dump(input);
            assertEquals(expected, res);
        }

        @ParameterizedTest
        @CsvSource(delimiter = ':', value = {"[2019-01-05, 2019-02-03]: [{solarDay=5,solarMonth=1,solarYear=2019},{solarDay=3,solarMonth=2,solarYear=2019}]"})
        void solarArray(@ConvertWith(SolarConverter.class) Solar[] input, String expected){
            String res = DateSolarLunar.dump(input);
            assertEquals(expected, res);
        }
    }



    @Test
    void getEveryDayLunarSolar() {
    }

    @Test
    void getEveryDayLunarSolar2() {
    }

    @Test
    void getSolarByLunar() {
    }

    @Test
    void getEveryDay() {
    }
}