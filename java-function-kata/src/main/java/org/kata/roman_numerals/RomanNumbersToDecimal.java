package org.kata.roman_numerals;


public class RomanNumbersToDecimal {

    public static void main(String[] args) {
        RomanNumbersToDecimalParser parser = new RomanNumbersToDecimalParser();
        if (args.length < 1) {
            System.err.println("Shortage of parameters");
        } else {
            System.out.println(String.format("Roman number: %s is in decimal: %d", args[0], parser.parse(args[0])));
        }
    }
}
