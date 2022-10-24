package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.function.*;

public class PrintVisitor implements Visitor<String> {
    @Override
    public String visit(Sum sum) {
        return sum.getA().accept(this) + " + " + sum.getB().accept(this);
    }

    @Override
    public String visit(Sub sub) {
        return sub.getA().accept(this) + " - " + sub.getB().accept(this);
    }

    @Override
    public String visit(Mul mul) {
        return mul.getA().accept(this) + " * " + mul.getB().accept(this);
    }

    @Override
    public String visit(Div div) {
        return div.getA().accept(this) + " / " + div.getB().accept(this);
    }

    @Override
    public String visit(Pow pow) {
        return pow.getA().accept(this) + " ^ " + pow.getB().accept(this);
    }

    @Override
    public String visit(Abs abs) {
        return "|" + abs.getA().accept(this) + "|";
    }

    @Override
    public String visit(Root root) {
        return root.getB().accept(this) + " √ " + root.getA().accept(this);
    }

    @Override
    public String visit(Parentesis parentesis) {
        return "(" + parentesis.getA().accept(this) + ")";
    }

    @Override
    public String visit(Number number) {
        return (number.getValue() % 1 == 0) ? String.valueOf((int) number.getValue()) : String.valueOf(number.getValue());
    }

    @Override
    public String visit(Variable variable) {
        return variable.getName();
    }
}
