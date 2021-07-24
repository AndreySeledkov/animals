import codered.Parser;
import codered.impl.AnimalParser;
import codered.impl.CarParser;
import codered.impl.NumberParser;

public class CodingTask {

    public static void main(String[] args) {

        String path = "YOUR_PATH\\src\\main\\resources\\input.txt";

        Parser animal = new AnimalParser(path);
        animal.parse().print();

        Parser parser = new NumberParser(path);
        parser.parse().print();
    }
}
