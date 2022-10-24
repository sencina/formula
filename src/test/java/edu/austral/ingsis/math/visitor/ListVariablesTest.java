package edu.austral.ingsis.math.visitor;
import edu.austral.ingsis.math.visitor.function.*;
import edu.austral.ingsis.math.visitor.visitors.ListVariablesVisitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListVariablesTest {

    final private static Visitor<List<String>> visitor = new ListVariablesVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = visitor.visit(new Sum(new Number(1), new Number(6)));
        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = visitor.visit(new Div(new Number(12), new Variable("div")));

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final List<String> result = visitor.visit(new Mul(new Div(new Number(9), new Variable("x")), new Variable("y")));

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final List<String> result = visitor.visit(new Pow(new Div(new Number(27), new Variable("a")), new Variable("b")));

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = visitor.visit(new Pow(new Variable("z"), new Div(new Number(1), new Number(2))));

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result = visitor.visit(new Sub(new Abs(new Variable("value")), new Number(8)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final List<String> result = visitor.visit(new Sub(new Abs(new Variable("value")), new Number(8)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final List<String> result = visitor.visit(new Mul(new Sub(new Number(5), new Variable("i")), new Number(8)));

        assertThat(result, containsInAnyOrder("i"));
    }

}
