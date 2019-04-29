package com.lby.solarAndLunarCalender.Utils;


import com.lby.solarAndLunarCalender.Solar;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class SolarConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        checkSource(source);

        String sourceString = (String) source;
        sourceString = sourceString.replaceAll(" ","");
        int len = sourceString.length();
        if (sourceString.charAt(0) == '['
                && sourceString.charAt(len-1) == ']'){
            sourceString = sourceString.substring(1, len-1);
            String[] dates = sourceString.split(",");
            Solar[] res = new Solar[dates.length];
            int i = 0;
            for (String date: dates){
                String[] paramList = date.split("-");
                Solar solar = new Solar();
                solar.solarYear = Integer.parseInt(paramList[0]);
                solar.solarMonth = Integer.parseInt(paramList[1]);
                solar.solarDay = Integer.parseInt(paramList[2]);
                res[i] = solar;
                ++i;
            }
            return res;
        }
        else{
            String[] paramList = sourceString.split("-");
            Solar res = new Solar();
            res.solarYear = Integer.parseInt(paramList[0]);
            res.solarMonth = Integer.parseInt(paramList[1]);
            res.solarDay = Integer.parseInt(paramList[2]);
            return res;
        }
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
