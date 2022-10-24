package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.function.*;

import java.util.Map;

public class EvaluateVisitor implements Visitor<Double> {

    private final Map<String,Double> variables;

    public EvaluateVisitor(Map<String,Double> variables) {
        this.variables = variables;
    }

    public EvaluateVisitor() {
        this(Map.of());
    }

    @Override
    public Double visit(Sum sum) {
        return sum.getA().accept(this) + sum.getB().accept(this);
    }

    @Override
    public Double visit(Sub sub) {
        return sub.getA().accept(this) - sub.getB().accept(this);
    }

    @Override
    public Double visit(Mul mul) {
        return mul.getA().accept(this) * mul.getB().accept(this);
    }

    @Override
    public Double visit(Div div) {
        return div.getA().accept(this) / div.getB().accept(this);
    }

    @Override
    public Double visit(Pow pow) {
        return Math.pow(pow.getA().accept(this), pow.getB().accept(this));
    }

    @Override
    public Double visit(Abs abs) {
        return Math.abs(abs.getA().accept(this));
    }

    @Override
    public Double visit(Root root) {
        return Math.pow(root.getA().accept(this), 1 / root.getB().accept(this));
    }

    @Override
    public Double visit(Parentesis parentesis) {
        return parentesis.getA().accept(this);
    }

    @Override
    public Double visit(Number number) {
        return number.getValue();
    }

    @Override
    public Double visit(Variable variable) {
        return variables.containsKey(variable.getName()) ? variables.get(variable.getName()) : 0;
    }
}
