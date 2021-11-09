package util;

import org.junit.jupiter.api.DynamicTest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBase {

    public static List<DynamicTest> getAllTests(int questionNum, Class<?> main) {
        List<DynamicTest> list = new ArrayList<>();
        try {
            List<Path> casePaths = Files.walk(Paths.get("src/test/resources/q" + questionNum + "/cases"))
                    .filter(path -> path.getFileName().toString().endsWith(".txt"))
                    .collect(Collectors.toList());

            List<Path> expectedPaths = Files.walk(Paths.get("src/test/resources/q" + questionNum + "/expected"))
                    .filter(path -> path.getFileName().toString().endsWith(".txt"))
                    .collect(Collectors.toList());

            assertEquals(expectedPaths.size(), casePaths.size());

            for (int ii = 0; ii < casePaths.size(); ii++) {
                Path casePath = casePaths.get(ii);
                Path expectedPath = expectedPaths.get(ii);

                list.add(
                        DynamicTest.dynamicTest(
                                casePath.getFileName().toString(),
                                () -> testIoEquals(casePath, expectedPath, main)
                        )
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    static void testIoEquals(Path casePath, Path expectedPath, Class<?> main) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        System.setIn(new FileInputStream(casePath.toFile()));
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Method mainMethod = main.getMethod("main", String[].class);
        mainMethod.invoke(main, (Object) null);
        assertEquals(readFileToString(expectedPath.toString()), outputStreamCaptor.toString());
    }

    // to be compatible with lower version Java
    private static String readFileToString(String filePath) {
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
