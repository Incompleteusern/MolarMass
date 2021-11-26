package me.Incompleteusern.MolarMass.Nodes;

import java.util.Deque;

public class NodeSubscript extends Node<NodeSubscript> {
    @Override
    public NodeSubscript takeValue(Deque<Token> input) {
        Token taken = input.peek();

        switch (taken.type) {
            case Digit -> {
                children.add(taken);
                input.pop();
                production = 0;
            }
            case LeftParentheses, RightParentheses, Element, End -> {
                production = 1;
            }
        }

        return this;
    }

    @Override
    public double getMolarMass() {
        return switch (production) {
            case 0 -> children.get(0).getMolarMass();
            case 1 -> 1;
            default -> throw new UnsupportedOperationException("Could not parse term");
        };
    }
}
