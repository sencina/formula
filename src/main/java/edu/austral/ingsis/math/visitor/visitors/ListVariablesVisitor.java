package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.function.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListVariablesVisitor implements Visitor<List<String>> {


    @Override
    public List<String> visit(Sum sum) {
        return merge(sum.getA().accept(this), sum.getB().accept(this));
    }

    @Override
    public List<String> visit(Sub sub) {
        return merge(sub.getA().accept(this), sub.getB().accept(this));
    }

    @Override
    public List<String> visit(Mul mul) {
        return merge(mul.getA().accept(this), mul.getB().accept(this));
    }

    @Override
    public List<String> visit(Div div) {
        return merge(div.getA().accept(this), div.getB().accept(this));
    }

    @Override
    public List<String> visit(Pow pow) {
        return merge(pow.getA().accept(this), pow.getB().accept(this));
    }

    @Override
    public List<String> visit(Abs abs) {
        return abs.getA().accept(this);
    }

    @Override
    public List<String> visit(Root root) {
        return merge(root.getA().accept(this), root.getB().accept(this));
    }

    @Override
    public List<String> visit(Parentesis parentesis) {
        return parentesis.getA().accept(this);
    }

    @Override
    public List<String> visit(Number number) {
        return new ArrayList<>();
    }

    @Override
    public List<String> visit(Variable variable) {
        return new ArrayList<>(Collections.singleton(variable.getName()));
    }

    private List<String> merge(List<String> a, List<String> b) {
        return Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
    }
}
