package edu.austral.ingsis.math.visitor;
import edu.austral.ingsis.math.visitor.function.*;
import edu.austral.ingsis.math.visitor.visitors.EvaluateVisitor;
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
        final Visitor<Double> visitor = new EvaluateVisitor(Collections.singletonMap("x",3d));
        final Double result = visitor.visit(new Sum(new Number(1), new Variable("x")));

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Visitor<Double> visitor = new EvaluateVisitor(Collections.singletonMap("div",4d));
        final Double result = visitor.visit(new Div(new Number(12), new Variable("div")));

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

        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Mul(new Div(new Number(9), new Variable("x")), new Variable("y")));

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

        final Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Pow(new Div(new Number(27), new Variable("a")), new Variable("b")));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {

        final Visitor<Double> visitor = new EvaluateVisitor(Collections.singletonMap("z",36d));
        final Double result = visitor.visit(new Pow(new Variable("z"), new Div(new Number(1), new Number(2))));
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {

        final Visitor<Double> visitor = new EvaluateVisitor(Collections.singletonMap("value",8d));
        final Double result = visitor.visit(new Sub(new Abs(new Variable("value")), new Number(8)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {

        final Visitor<Double> visitor = new EvaluateVisitor(Collections.singletonMap("value",8d));
        final Double result = visitor.visit(new Sub(new Abs(new Variable("value")), new Number(8)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {

        final Visitor<Double> visitor = new EvaluateVisitor(Collections.singletonMap("i",2d));
        final Double result = visitor.visit(new Mul(new Sub(new Number(5), new Variable("i")), new Number(8)));

        assertThat(result, equalTo(24d));
    }
}
