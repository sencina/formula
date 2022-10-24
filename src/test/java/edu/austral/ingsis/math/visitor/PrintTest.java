package edu.austral.ingsis.math.visitor;
import edu.austral.ingsis.math.visitor.function.*;
import edu.austral.ingsis.math.visitor.visitors.PrintVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    final private static Visitor<String> visitor = new PrintVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = visitor.visit(new Sum(new Number(1), new Number(6)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final String result = visitor.visit(new Div(new Number(12), new Number(2)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final String result = visitor.visit(new Mul(new Parentesis(new Div(new Number(9),new Number(2))), new Number(3)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final String result = visitor.visit(new Pow(new Parentesis(new Div(new Number(27),new Number(6))), new Number(2)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final String result = visitor.visit(new Sub(new Abs(new Variable("value")), new Number(8)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final String result = visitor.visit(new Sub(new Abs(new Variable("value")), new Number(8)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final String result = visitor.visit(new Mul(new Parentesis(new Sub(new Number(5), new Variable("i"))), new Number(8)));

        assertThat(result, equalTo(expected));
    }
}
