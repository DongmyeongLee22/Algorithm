package com.company.huffmanRunlength;

public class Run implements Comparable<Run> {

    private Byte symbol;

    private Integer length;

    private Integer frequency;

    public Run left;

    public Run right;

    public int codeword;

    public int codewordLen;

    public Run(Byte symbol, Integer length, Integer frequency) {
        this.symbol = symbol;
        this.length = length;
        this.frequency = frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public boolean equals(Run run) {
        return (this.symbol == run.symbol) && (this.length == run.length);
    }

    @Override
    public String toString() {
        return "" + frequency;
    }

    @Override
    public int compareTo(Run o) {
        return o.frequency - this.frequency;
    }

    public Byte getSymbol() {
        return symbol;
    }

    public Integer getLength() {
        return length;
    }
}
