package me.Incompleteusern.MolarMass.Nodes;

import java.util.Deque;

public class NodeTerm extends Node<NodeTerm> {
    @Override
    public NodeTerm takeValue(Deque<Token> input) {
        Token taken = input.peek();

        switch (taken.type) {
            case Element, LeftParentheses -> {
                children.add(new NodeValue().takeValue(input));
                children.add(new NodeSubscript().takeValue(input));
                production = 0;
            }
            case Digit, RightParentheses, End -> throw new UnsupportedOperationException("Could not parse term");
        }

        return this;
    }

    @Override
    public double getMolarMass() {
        return switch (production) {
            case 0 -> children.get(0).getMolarMass() * children.get(1).getMolarMass();
            default -> throw new UnsupportedOperationException("Could not parse term");
        };
    }
}
