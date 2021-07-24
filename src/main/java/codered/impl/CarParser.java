package codered.impl;

import codered.Parser;
import codered.Utils;
import java.util.*;
import java.util.stream.Collectors;

public class CarParser extends Parser {

    protected static final String CARS = "CARS";
    private List<String> cars;

    public CarParser(String path) {
      categories = loadCategories(new ArrayList<String>(Arrays.asList(CARS)), path);
    }

    @Override
    public CarParser parse() {
        cars = categories.get(CARS).stream().map(String::toLowerCase).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return this;
    }

    @Override
    public void print() {
        cars.forEach( car -> System.out.println(car + " (" + Utils.md5(car) + ")"));
    }
}
