package com.test.coding.task.src.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level1 {
    protected static final String input_path = "YOUR_PATH\\data\\input.txt";
    protected static final String ANIMALS = "ANIMALS";
    protected static final String NUMBERS = "NUMBERS";
    protected static final List<String> categories = new ArrayList<>() {{
        add(ANIMALS);
        add(NUMBERS);
    }};

    public Map<String, List<String>> loadCategoriesMap(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            var lines = stream.collect(Collectors.toList());
            String currentCategory = null;

            var categoriesMap = new HashMap<String, List<String>>();
            for (String el : lines) {
                if (categories.contains(el)) currentCategory = el;
                else categoriesMap.computeIfAbsent(currentCategory, s -> new ArrayList<>()).add(el);
            }

            return categoriesMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_MAP;
    }

    public void resolve() {
        resolve(loadCategoriesMap(input_path));
    }

    public void resolve(Map<String, List<String>> categoriesMap) {
        var sortedAnimals = categoriesMap.get(ANIMALS).stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(ANIMALS + ":");
        sortedAnimals.forEach(System.out::println);

        System.out.println(NUMBERS + ":");
        var counted = categoriesMap.get(NUMBERS).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        counted.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }


    public static void main(String[] args) {
        new Level1().resolve();
    }
}
