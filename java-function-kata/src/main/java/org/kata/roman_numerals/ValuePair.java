package org.kata.roman_numerals;


public class ValuePair {

    private int calculatedValue;
    private int substractionValue;

    public ValuePair(int calculatedValue, int substractionValue) {
        this.calculatedValue = calculatedValue;
        this.substractionValue = substractionValue;
    }

    public int getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(int calculatedValue) {
        this.calculatedValue = calculatedValue;
    }

    public int getSubstractionValue() {
        return substractionValue;
    }

    public void setSubstractionValue(int substractionValue) {
        this.substractionValue = substractionValue;
    }

}
