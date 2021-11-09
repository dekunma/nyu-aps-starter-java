package q3;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import q1.Main;
import util.TestBase;

import java.util.List;

public class Test {
    @TestFactory
    List<DynamicTest> runTests() {
        return TestBase.getAllTests(3, Main.class);
    }
}
