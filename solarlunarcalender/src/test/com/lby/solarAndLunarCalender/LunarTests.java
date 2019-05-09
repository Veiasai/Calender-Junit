package com.lby.solarAndLunarCalender;

import com.lby.solarAndLunarCalender.Utils.LunarConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LunarTests {
    @ParameterizedTest
    @CsvSource({"2018-11-30, 2018-11-30",
                "2020-12-01, 2020-12-01"})
    void equals(@ConvertWith(LunarConverter.class) Lunar a,
                @ConvertWith(LunarConverter.class) Lunar b){
        assertTrue(a.equals(b));
    }

    @ParameterizedTest
    @CsvSource({"2018, 11, 30, false"})
    void constructor(int y, int m, int d, boolean isleap){
        Lunar lunar = new Lunar(isleap, y, m, d);
        assertEquals(isleap, lunar.isleap);
        assertEquals(y, lunar.lunarYear);
        assertEquals(m, lunar.lunarMonth);
        assertEquals(d, lunar.lunarDay);
    }

    @ParameterizedTest
    @CsvSource({"2018-05-30, Lunar Date: 2018-05-30",
                "2018-01-03, Lunar Date: 2018-01-03"})
    void toString(@ConvertWith(LunarConverter.class) Lunar lunar, String str){
        assertEquals(lunar.toString(), str);
    }
}
