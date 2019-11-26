import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

public class KlarnaTest {

    /****** Tests for maskify method *******/
    @Test
    public void check_trim_for_maskify_method() {
        Assert.assertEquals("123", Klarna.maskify("123      "));
    }

    @Test
    public void check_method_maskify_returns_empty_string_when_parameter_is_null() {
        Assert.assertEquals("", Klarna.maskify(null));
    }

    @Test
    public void check_method_maskify_returns_correct_masked_output_when_digits_are_not_seperated_by_minus_sign() {
        Assert.assertEquals("4###########5616", Klarna.maskify("4556364607935616"));
    }

    @Test
    public void check_method_maskify_returns_correct_masked_output_when_digits_are_seperated_by_minus_sign() {
        Assert.assertEquals("4###-####-####-5616", Klarna.maskify("4556-3646-0793-5616"));
    }

    @Test
    public void check_method_maskify_returns_correct_masked_output_when_number_of_digits_less_than_14() {
        Assert.assertEquals("6######5616", Klarna.maskify("64607935616"));
    }

    @Test
    public void check_method_maskify_returns_the_parameter_itself_when_there_is_no_digit() {
        Assert.assertEquals("ABCD-EFGH-IJKLM-NOPQ", Klarna.maskify("ABCD-EFGH-IJKLM-NOPQ"));
    }

    @Test
    public void check_method_maskify_does_not_mask_nondigit_characters() {
        Assert.assertEquals("A#C#-#FG#-K##M-NOPQ", Klarna.maskify("A2C4-6FG3-K57M-NOPQ"));
    }

    @Test
    public void check_method_maskify_returns_the_parameter_itself_when_parameter_length_is_less_than_6() {
        Assert.assertEquals("SCTYR", Klarna.maskify("SCTYR"));
    }


    /****** Tests for numberToOrdinal method *******/
    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_1() {
        Assert.assertEquals("1st", Klarna.numberToOrdinal(1));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_2() {
        Assert.assertEquals("2nd", Klarna.numberToOrdinal(2));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_3() {
        Assert.assertEquals("3rd", Klarna.numberToOrdinal(3));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_4() {
        Assert.assertEquals("4th", Klarna.numberToOrdinal(4));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_11() {
        Assert.assertEquals("11th", Klarna.numberToOrdinal(11));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_12() {
        Assert.assertEquals("12th", Klarna.numberToOrdinal(12));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_13() {
        Assert.assertEquals("13th", Klarna.numberToOrdinal(13));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_19() {
        Assert.assertEquals("19th", Klarna.numberToOrdinal(19));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_21() {
        Assert.assertEquals("21st", Klarna.numberToOrdinal(21));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_102() {
        Assert.assertEquals("102nd", Klarna.numberToOrdinal(102));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_111() {
        Assert.assertEquals("111th", Klarna.numberToOrdinal(111));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_112() {
        Assert.assertEquals("112th", Klarna.numberToOrdinal(112));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_113() {
        Assert.assertEquals("113th", Klarna.numberToOrdinal(113));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_2500() {
        Assert.assertEquals("2500th", Klarna.numberToOrdinal(2500));
    }

    @Test
    public void check_method_maskify_returns_the_correct_suffix_for_10003() {
        Assert.assertEquals("10003rd", Klarna.numberToOrdinal(10003));
    }


    /****** Tests for reversePolishNotation method *******/
    @Test
    public void check_trim_for_reversePolishNotation_method() {
        Assert.assertEquals(14, Klarna.reversePolishNotation("    5 1 2 + 4 * + 3 -      "));
    }

    @Test
    public void check_method_reversePolishNotation_returns_zero_when_parameter_is_null() {
        Assert.assertEquals(0, Klarna.reversePolishNotation(null));
    }

    @Test
    public void check_method_reversePolishNotation_returns_zero_when_parameter_is_empty() {
        Assert.assertEquals(0, Klarna.reversePolishNotation(""));
    }

    @Test
    public void check_method_reversePolishNotation_returns_correct_value_when_number_of_digits_is_equal_to_number_of_operators_plus_one() {
        Assert.assertEquals(45, Klarna.reversePolishNotation("3 13 5 2 / + *"));
    }

    @Test(expected = EmptyStackException.class)
    public void check_method_reversePolishNotation_throws_EmptyStackException_when_operators_are_more_than_numbers() {
        Klarna.reversePolishNotation("3 13 5 - / + *");
    }

    @Test
    public void check_method_reversePolishNotation_returns_minus_one_when_there_numbers_but_no_operators_left_in_the_stack() {
        Assert.assertEquals(-1, Klarna.reversePolishNotation("3 15 5 2 - /"));
    }

    @Test(expected = EmptyStackException.class)
    public void check_method_reversePolishNotation_throws_EmptyStackException_when_there_is_no_digit_in_the_expression() {
        Klarna.reversePolishNotation("- / + *");
    }

    @Test
    public void check_method_reversePolishNotation_returns_minus_one_when_there_is_no_operators_in_the_expression() {
        Assert.assertEquals(-1, Klarna.reversePolishNotation("3 15 5 2"));
    }
}
