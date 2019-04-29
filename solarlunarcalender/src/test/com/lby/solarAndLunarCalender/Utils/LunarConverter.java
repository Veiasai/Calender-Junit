package com.lby.solarAndLunarCalender.Utils;


import com.lby.solarAndLunarCalender.Lunar;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class LunarConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        checkSource(source);

        String sourceString = (String) source;
        String[] paramList = sourceString.split("-");
        Lunar res = new Lunar();
        res.lunarYear = Integer.parseInt(paramList[0]);
        res.lunarMonth = Integer.parseInt(paramList[1]);
        res.lunarDay = Integer.parseInt(paramList[2]);
        return res;
    }

    private void checkSource(Object source) {
        if (source == null) {
            throw new ArgumentConversionException("Cannot convert null source object");
        }

        if (!source.getClass().equals(String.class)) {
            throw new ArgumentConversionException(
                    "Cannot convert source object because it's not a string"
            );
        }

        String sourceString = (String) source;
        if (sourceString.trim().isEmpty()) {
            throw new ArgumentConversionException(
                    "Cannot convert an empty source string"
            );
        }
    }
}
