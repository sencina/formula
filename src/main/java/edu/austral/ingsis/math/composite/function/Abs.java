package edu.austral.ingsis.math.composite.function;

import edu.austral.ingsis.math.composite.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Abs implements Function {

    private final Function a;

    // |a|
    public Abs(Function a) {
        this.a = a;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.abs(a.evaluate(map));
    }

    @Override
    public String toString() {
        return "|" + a.toString() + "|";
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(a.getChildren(copy));
        return copy;
    }

    @Override
    public List<String> listVariables(List<String> list) {
        return a.listVariables(list);
    }

}
