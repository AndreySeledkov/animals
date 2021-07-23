import java.util.*;
import java.util.stream.Collectors;

public class Level3 extends Level {
    protected static final String input = "YOUR_PATH\\src\\main\\resources\\input2.txt";
    protected static final String CARS = "CARS";

    @Override
    public void resolve() {
        Map<String, List<String>> categories = loadCategoriesMap(new ArrayList<String>(Arrays.asList(CARS)), input);

        var cars = categories.get(CARS).stream().map(String::toLowerCase).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (var car : cars) {
            System.out.println(car + " (" + Utils.md5(car) + ")");
        }
    }
}
