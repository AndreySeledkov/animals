package com.test.coding.task.src.core;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Level3 extends Level1 {
    protected static final String input_path2 = "YOUR_PATH\\data\\input2.txt";
    protected static final String CARS = "CARS";

    static {
        categories.add(CARS);
    }

    @Override
    public void resolve() {
        resolve(loadCategoriesMap(input_path2));
    }

    @Override
    public void resolve(Map<String, List<String>> categoriesMap) {
        super.resolve(categoriesMap);

        var cars = categoriesMap.get(CARS).stream().map(String::toLowerCase).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (var car : cars) {
            System.out.println(car + " (" + Utils.md5(car) + ")");
        }
    }

    public static void main(String[] args) {
        new Level3().resolve();
    }
}
