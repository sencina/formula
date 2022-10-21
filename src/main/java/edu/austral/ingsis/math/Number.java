package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Number implements Function{

    private final double val;

    public Number (double val) {this.val = val;}

    @Override
    public double evaluate (Map<String, Double> map) {return val;}

    @Override
    public String toString () {return (val % 1 != 0) ? Double.toString(val) : Integer.toString((int) val);}

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.add(toString());
        return copy;
    }

    @Override
    public List<String> listVariables(List<String> list) {
        return List.of();
    }
}
