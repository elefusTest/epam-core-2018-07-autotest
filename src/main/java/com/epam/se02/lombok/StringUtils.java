package com.epam.se02.lombok;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public char SYMBOL = '!';

    public String withSymbol(String s, char symbol) {
        return s + symbol;
    }
}