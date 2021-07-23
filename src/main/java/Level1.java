import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Level1 extends  Level {
    protected static final String input = "YOUR_PATH\\src\\main\\resources\\input.txt";
    protected static final String ANIMALS = "ANIMALS";
    protected static final String NUMBERS = "NUMBERS";

    @Override
    public void resolve() {
        Map<String, List<String>> categories = loadCategoriesMap(new ArrayList<String>(Arrays.asList(ANIMALS,NUMBERS)), input);
        var sortedAnimals = categories.get(ANIMALS).stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(ANIMALS + ":");
        sortedAnimals.forEach(System.out::println);

        System.out.println(NUMBERS + ":");
        var counted = categories.get(NUMBERS).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        counted.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }
}
