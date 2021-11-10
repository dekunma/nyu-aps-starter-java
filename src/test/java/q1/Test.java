package q1;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import util.TestGenerator;

import java.util.List;

public class Test {
    @TestFactory
    List<DynamicTest> runTests() {
        return TestGenerator.getAllTests(Main.class);
    }
}
