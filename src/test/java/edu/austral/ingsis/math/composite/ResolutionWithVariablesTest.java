package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.function.*;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Double result = new Sum(new Number(1), new Variable("x")).evaluate(Collections.singletonMap("x", 3.0));

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Double result = new Div(new Number(12), new Variable("div")).evaluate(Collections.singletonMap("div", 4d));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {

        final Map<String,Double> map = new HashMap<>();
        map.put("x", 3d);
        map.put("y", 4d);
        final Double result = new Mul(new Div(new Number(9), new Variable("x")), new Variable("y")).evaluate(map);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {

        final Map<String,Double> map = new HashMap<>();
        map.put("a", 9d);
        map.put("b", 3d);

        final Double result = new Pow(new Div(new Number(27), new Variable("a")), new Variable("b")).evaluate(map);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {

        final Double result = new Root(new Variable("z"), new Number(2)).evaluate(Collections.singletonMap("z", 36d));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Double result = new Sub(new Abs(new Variable("value")), new Number(8)).evaluate(Collections.singletonMap("value", 8d));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Double result = new Sub(new Abs(new Variable("value")), new Number(8)).evaluate(Collections.singletonMap("value", -8d));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Double result = new Mul(new Sub(new Number(5), new Variable("i")), new Number(8)).evaluate(Collections.singletonMap("i", 2d));

        assertThat(result, equalTo(24d));
    }
}
