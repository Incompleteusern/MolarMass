package me.Incompleteusern.MolarMass;

import me.Incompleteusern.MolarMass.Nodes.Terminals;
import me.Incompleteusern.MolarMass.Nodes.NodeFormula;
import me.Incompleteusern.MolarMass.Nodes.Token;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //KAl(Al2Si3O10)
        String input = "C10H4";
        Deque<Token> tokens = generateTokens(input);

        NodeFormula result = new NodeFormula().takeValue(tokens);
        double molarMass = result.getMolarMass();

        BigDecimal bd = new BigDecimal(molarMass);
        bd = bd.round(new MathContext(3));
        double rounded = bd.doubleValue();

        System.out.println(rounded);

    }

    public static Deque<Token> generateTokens(String input) throws Exception {
        Deque<Token> tokens = new ArrayDeque<>();
        int i = 0;

        boolean debug = false;

        while (i < input.length()) {
            if (debug) System.out.printf("Running %s%n", i);

            switch (input.charAt(i)) {
                case '(':
                    tokens.add(new Token("(", Token.TokenType.LeftParentheses));
                    if (debug) System.out.println("Matched (");
                    i++;
                    continue;
                case ')':
                    tokens.add(new Token(")", Token.TokenType.RightParentheses));
                    if (debug) System.out.println("Matched )");
                    i++;
                    continue;
                default:
                    break;
            }

            String tryElement = Terminals.getElement(input, i);

            if (!tryElement.equals("")) {
                tokens.add(new Token(tryElement, Token.TokenType.Element));
                if (debug) System.out.printf("Matched %s%n", tryElement);
                i += tryElement.length();
                continue;
            }

            String tryDigit = Terminals.getDigit(input, i);

            if (!tryDigit.equals("")) {
                tokens.add(new Token(tryDigit, Token.TokenType.Digit));
                if (debug) System.out.printf("Matched %s%n", tryDigit);
                i += tryDigit.length();
                continue;
            }

            throw new Exception(String.format("Invalid token to be parsed at index %s", i));
        }

        tokens.add(new Token("$", Token.TokenType.End));

        if (debug) System.out.println(tokens);

        return tokens;
    }
}
