package q1;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import util.TestBase;

import java.util.List;

public class Test {
    @TestFactory
    List<DynamicTest> runTests() {
        return TestBase.getAllTests(1, Main.class);
    }
}