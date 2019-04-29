package com.lby.solarAndLunarCalender.Utils;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements ArgumentConverter {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        checkSource(source);

        String sourceString = (String) source;
        try{
            Date d = format.parse(sourceString);
            return d;
        }
        catch(ParseException e){
            return null;
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
