package codered.impl;

import codered.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalParser extends Parser {

    protected static final String ANIMALS = "ANIMALS";
    private List<String> animals;

    public AnimalParser(String path) {
        categories = loadCategories(new ArrayList<String>(Arrays.asList(ANIMALS)), path);
    }

    @Override
    public AnimalParser parse() {
        animals = categories.get(ANIMALS).stream().distinct().sorted().collect(Collectors.toList());
        return this;
    }

    @Override
    public void print() {
        animals.forEach(System.out::println);
    }
}
