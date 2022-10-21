package edu.austral.ingsis.math;

import edu.austral.ingsis.math.function.*;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;




public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Function one = new Number(1);
        final Function six = new Number(6);
        final Function function = new Sum(one, six);
        final Double result = function.evaluate();
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {

        Function twelve = new Number(12);
        Function two = new Number(2);

        Function div = new Div(twelve, two);

        final Double result = div.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {

        Function nine = new Number(9);
        Function two = new Number(2);
        Function three = new Number(3);

        Function div = new Div(nine, two);
        Function mul = new Mul(div, three);

        final Double result = mul.evaluate();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {

        Function twentySeven = new Number(27);
        Function six = new Number(6);
        Function two = new Number(2);

        Function div = new Div(twentySeven, six);
        Function pow = new Pow(div, two);
        final Double result = pow.evaluate();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {

        Function thirtySix = new Number(36);
        Function two = new Number(2);

        Function root = new Root(thirtySix, two);

        final Double result = root.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {

        Function oneHundredThirtySix = new Number(136);

        final Double result = oneHundredThirtySix.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {

        Function oneHundredThirtySix = new Number(-136);

        Function abs = new Abs(oneHundredThirtySix);
        final Double result = abs.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {

        Function five = new Number(5);
        Function eight = new Number(8);

        Function sub = new Sub(five, five);
        Function mul = new Mul(sub, eight);
        final Double result = mul.evaluate();

        assertThat(result, equalTo(0d));
    }

}
