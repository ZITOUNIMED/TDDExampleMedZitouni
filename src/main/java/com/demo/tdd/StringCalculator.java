package com.demo.tdd;


import java.util.Arrays;

public class StringCalculator {
    private char delimiter = ','; // default delimiter
    public static final String NEGATIVE_NUMBERS_EXCEPTION_MESSAGE = "Les nombres négatifs ne sont pas autorisés";

    public int Add(String numbers){
        if(numbers == null || numbers.isEmpty()){
            return 0;
        }

        if(numbers.length() > 2 && "//".equals(numbers.substring(0, 2))){
            return Add(numbers.split("\n")[1], numbers.charAt(2));
        }

        String[] array = numbers.split("\n");
        if(array != null && array.length == 2){
            return Integer.parseInt(array[0]) + Add(array[1]);
        }

        String[] numbersArray = numbers.split(delimiter + "");
        return Arrays.stream(numbersArray)
                .mapToInt(number -> {
                    int value = Integer.parseInt(number);
                    if(value<0){
                        throw new RuntimeException(NEGATIVE_NUMBERS_EXCEPTION_MESSAGE);
                    }
                    return value > 1000 ? 0 : value;
                })
                .sum();
    }

    private int Add(String numbers, char delimiter){
        this.delimiter = delimiter;
        int result = Add(numbers);
        this.delimiter = ','; // set to default delimiter
        return result;
    }
}
