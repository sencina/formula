package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Function {

    double evaluate(Map<String, Double> variables);

    default double evaluate(){
        return evaluate(Map.of());
    }

    String toString();

    List<String> getChildren(List<String> list);

    List<String> listVariables(List<String> list);

}