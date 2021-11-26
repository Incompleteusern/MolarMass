package me.NotAURL.Nodes;

import java.util.Deque;
import java.util.Objects;

public class NodeValue extends Node<NodeValue> {

    @Override
    public NodeValue takeValue(Deque<Token> input) {
        Token taken = input.pop();

        switch (taken.type) {
            case LeftParentheses -> {
                children.add(new NodeFormula().takeValue(input));
                Token rightParentheses = input.pop();
                assert Objects.equals(rightParentheses.type, Token.TokenType.RightParentheses);
                production = 0;
            }
            case Element -> {
                children.add(taken);
                production = 1;
            }
            case Digit, RightParentheses, End -> throw new UnsupportedOperationException("Could not parse value");
        }

        return this;
    }

    @Override
    public double getMolarMass() {
        return switch (production) {
            case 0, 1 -> children.get(0).getMolarMass();
            default -> throw new UnsupportedOperationException("Could not parse value");
        };
    }
}
