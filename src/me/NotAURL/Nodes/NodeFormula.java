package me.NotAURL.Nodes;

import java.util.Deque;

public class NodeFormula extends Node<NodeFormula> {
    @Override
    public NodeFormula takeValue(Deque<Token> input) {
        Token taken = input.peek();

        switch (taken.type) {
            case Element, LeftParentheses -> {
                children.add(new NodeTerm().takeValue(input));
                children.add(new NodeFormula().takeValue(input));
                production = 0;
            }
            case Digit -> throw new UnsupportedOperationException("Could not parse formula");
            case RightParentheses, End -> production = 1;
        }

        return this;
    }

    @Override
    public double getMolarMass() {
        return switch (production) {
            case 0 -> children.get(0).getMolarMass() + children.get(1).getMolarMass();
            case 1 -> 0;
            default -> throw new UnsupportedOperationException("Could not parse formula");
        };
    }
}
