import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Level {

    Map<String, List<String>> loadCategoriesMap(List<String> categories , String path) {
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

    public abstract void resolve();
}
