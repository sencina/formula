package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

public class Mul implements Visitable {

    private final Visitable a;
    private final Visitable b;

    // a * b
    public Mul(Visitable a, Visitable b) {
        this.a = a;
        this.b = b;
    }

    public Visitable getA() {
        return a;
    }

    public Visitable getB() {
        return b;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
