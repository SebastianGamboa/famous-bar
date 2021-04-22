package com.sgb.famousbar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    
    public static List<Integer> stringToArray(String inputArray) {
        return Arrays.stream(inputArray.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }
}
