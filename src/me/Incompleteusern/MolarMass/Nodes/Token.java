package me.Incompleteusern.MolarMass.Nodes;

import java.util.Deque;

public class Token extends Node {
    public String value;
    public TokenType type;

    public Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public Object takeValue(Deque input) {
        throw new UnsupportedOperationException("Taking value of Token");
    }

    @Override
    public double getMolarMass() {
        return switch (type) {
            case Element -> Terminals.elements.get(value);
            case Digit -> Integer.parseInt(value);
            default -> 0;
        };
    }

    public enum TokenType {
        Element, Digit, LeftParentheses, RightParentheses, End
    }
}
