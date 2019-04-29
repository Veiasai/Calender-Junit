package com.lby.solarAndLunarCalender;

import com.lby.solarAndLunarCalender.Utils.LunarConverter;
import com.lby.solarAndLunarCalender.Utils.SolarConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SolarTests {
    @ParameterizedTest
    @CsvSource({"2018-11-30, 2018-11-30",
            "2020-12-01, 2020-12-01"})
    void equals(@ConvertWith(SolarConverter.class) Solar a,
                @ConvertWith(SolarConverter.class) Solar b){
        assertTrue(a.equals(b));
    }

    @ParameterizedTest
    @CsvSource({"2018, 11, 30"})
    void constructor(int y, int m, int d){
        Solar solar = new Solar(d, m, y);
        assertEquals(y, solar.solarYear);
        assertEquals(m, solar.solarMonth);
        assertEquals(d, solar.solarDay);
    }
}
