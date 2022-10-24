package edu.austral.ingsis.math.visitor;
import edu.austral.ingsis.math.visitor.function.*;
import edu.austral.ingsis.math.visitor.visitors.EvaluateVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

    private final static Visitor<Double> visitor = new EvaluateVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {

        final Double result = visitor.visit(new Sum(new Number(1), new Number(6)));
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {

        final Double result = visitor.visit(new Div(new Number(12), new Number(2)));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {

        final Double result = visitor.visit(new Mul(new Div(new Number(9), new Number(2)), new Number(3)));

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {

        final Double result = visitor.visit(new Pow(new Div(new Number(27), new Number(6)), new Number(2)));

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {

        final Double result = visitor.visit(new Root(new Number(36), new Number(2)));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {

        final Double result = visitor.visit(new Abs(new Number(136)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {

        final Double result =  visitor.visit(new Abs(new Number(-136)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {

        final Double result = visitor.visit(new Mul(new Sub(new Number(5), new Number(5)), new Number(8)));

        assertThat(result, equalTo(0d));
    }

}
