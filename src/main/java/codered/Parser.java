package codered;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Parser {

    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());
    protected Map<String, List<String>> categories;

    protected Map<String, List<String>> loadCategories(List<String> categories, String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            var lines = stream.collect(Collectors.toList());
            String currentCategory = null;

            var categoriesMap = new HashMap<String, List<String>>();
            for (String el : lines) {
                if (categories.contains(el)) currentCategory = el;
                else categoriesMap.computeIfAbsent(currentCategory, s -> new ArrayList<>()).add(el);
            }

            return categoriesMap;
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "loadCategories issue", ex);
        }
        return Collections.EMPTY_MAP;
    }

    public abstract Parser parse();
    public abstract void print();
}
