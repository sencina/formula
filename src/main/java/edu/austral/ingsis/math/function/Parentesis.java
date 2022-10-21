package edu.austral.ingsis.math.function;

import edu.austral.ingsis.math.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parentesis implements Function {

        private final Function a;

        public Parentesis(Function a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "(" + a.toString() + ")";
        }

        @Override
        public double evaluate(Map<String, Double> map) {
            return a.evaluate(map);
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
