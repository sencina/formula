package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

public class Abs implements Visitable {

    private final Visitable a;

    // |a|
    public Abs(Visitable a) {
        this.a = a;
    }

    public Visitable getA() {
        return a;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
