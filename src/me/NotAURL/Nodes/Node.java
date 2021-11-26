package me.NotAURL.Nodes;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public abstract class Node<T> {
    int production = -1;
    List<Node<?>> children = new ArrayList<>();

    public abstract T takeValue(Deque<Token> input);

    public abstract double getMolarMass();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                //"production=" + production +
                "children=" + children +
                '}';
    }
}
