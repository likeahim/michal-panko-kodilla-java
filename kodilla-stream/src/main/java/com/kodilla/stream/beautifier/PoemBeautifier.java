package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String toDecorate, PoemDecorator poemDecorator) {
        return poemDecorator.decorate(toDecorate);
    }
}
