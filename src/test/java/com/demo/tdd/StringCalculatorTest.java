package com.demo.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Before
    public void setUp(){
        calculator= new StringCalculator();
    }

    @Test
    public void when_one_empty_param_should_return_zero(){
      assertEquals(0, calculator.Add(""));
    }

    @Test
    public void when_one_param_equal_to_1_should_return_1_as_a_number() {
        assertEquals(1, calculator.Add("1"));
    }

    @Test
    public void when_params_equal_to_1_comma_2_should_return_3(){
        assertEquals(3, calculator.Add("1,2"));
    }

    @Test
    public void should_manage_any_numbers(){
        assertEquals(9, calculator.Add("1,2,2,4"));
        assertEquals(21, calculator.Add("5,2,6,0,7,1"));
    }

    @Test
    public void should_handle_line_breaks(){
        assertEquals(6, calculator.Add("1\n2,3"));
    }

    @Test
    public void should_manage_customized_delimiter(){
        assertEquals(6, calculator.Add("//;\n1;2;3"));
    }

    @Test
    public void should_thow_exception_when_a_number_is_negative(){
        try {
            calculator.Add("-5,2,-10,9");
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), StringCalculator.NEGATIVE_NUMBERS_EXCEPTION_MESSAGE) ;
        }
    }

    @Test
    public void should_ignore_numbers_more_than_1000(){
        assertEquals(15, calculator.Add("5,10,1664"));
    }
}
