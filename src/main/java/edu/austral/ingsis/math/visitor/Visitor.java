package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.function.*;

public interface Visitor<T> {

    T visit(Sum sum);
    T visit(Sub sub);
    T visit(Mul mul);
    T visit(Div div);
    T visit(Pow pow);
    T visit(Abs abs);
    T visit(Root root);
    T visit(Parentesis parentesis);
    T visit(Number number);
    T visit(Variable variable);

}
