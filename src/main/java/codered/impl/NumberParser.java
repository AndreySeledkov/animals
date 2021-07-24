package codered.impl;

import codered.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberParser extends Parser {

    protected static final String NUMBERS = "NUMBERS";
    private Map<String, Long> numbers;

    public NumberParser(String path) {
        categories = loadCategories(new ArrayList<String>(Arrays.asList(NUMBERS)), path);
    }

    @Override
    public NumberParser parse() {
        numbers = categories.get(NUMBERS).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return this;
    }

    @Override
    public void print() {
        numbers.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }
}
