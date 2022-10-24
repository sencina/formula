package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.function.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = new Sum(new Number(1), new Number(6)).toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final String result = new Div(new Number(12), new Number(2)).toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final String result = new Mul(new Parentesis(new Div(new Number(9),new Number(2))), new Number(3)).toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final String result = new Pow(new Parentesis(new Div(new Number(27),new Number(6))), new Number(2)).toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final String result = new Sub(new Abs(new Variable("value")), new Number(8)).toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final String result = new Sub(new Abs(new Variable("value")), new Number(8)).toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final String result = new Mul(new Parentesis(new Sub(new Number(5), new Variable("i"))), new Number(8)).toString();

        assertThat(result, equalTo(expected));
    }
}
