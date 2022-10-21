package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Variable implements Function {

    private String name;

    public Variable (String name) {this.name = name;}

    @Override
    public double evaluate(Map<String, Double> map) {
        return map.get(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.add(name);
        return copy;
    }

    @Override
    public List<String> listVariables(List<String> list) {
        List<String> names = new ArrayList<>();
        names.add(name);
        return Stream.concat(list.stream(), names.stream()).collect(Collectors.toList());
    }
}
