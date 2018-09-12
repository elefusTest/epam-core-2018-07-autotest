package com.epam.se11;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

@Tag("super-class")
@DisplayName("Демонстрация возможностей JUnit5")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SimpleTest {

    private Object object;

    public SimpleTest(TestInfo info) {
        System.out.println("SimpleTest::ctr: " + info.getTestClass().orElseThrow());
    }

    @BeforeAll
    void initClass(TestInfo info) {
        object = createObject();
        System.out.println("Before all: " + info.getTags());
    }

    @AfterAll
    void destruction() {
        System.out.println("After all");
    }

    @BeforeEach
    void initMethod(TestInfo info) {
        System.out.println("Before each: " + info.getTags());
    }

    @AfterEach
    void destroyMethod() {
        System.out.println("After each");
    }

    @SneakyThrows
    private Object createObject() {
        TimeUnit.SECONDS.sleep(5);
        return new Object();
    }

    @Test
    void sumTwoPositiveValues() {
        // Prepare
        Summator summator = new Summator();

        // Run
        int result = summator.sum(1, 1);

        // Assertions
        assertEquals(2, result);
    }

    @DisplayName("Проверка суммирования с нулем (не должно измениться)")
    @Test
    void sumWithZero() {
        Summator summator = new Summator();

        int result = summator.sum(1, 0);

        assertEquals(1, result);
    }

    @Test
    void assertAllExample() {
        assertAll(() -> {
            assertTrue(false, "1");
        }, () -> {
            assertTrue(true, "2");
        }, () -> {
            assertTrue(true, "3");
        });
    }

    @Test
    void assertThrowsExampleShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            throw new RuntimeException();
        });
    }

    @Test
    void assertThrowsExampleShouldComplete() {
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException();
        });
    }

    @Tags({
        @Tag("slow"),
        @Tag("slow1")
    })
    @Test
    void assertTimeoutExampleShouldFail() {
        assertTimeout(Duration.ofSeconds(1), () -> TimeUnit.SECONDS.sleep(2));
    }

    @Tag("slow")
    @Test
    void assertTimeoutPreemptivelyExampleShouldFail() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> TimeUnit.SECONDS.sleep(10));
    }

    @Test
    void failedAssumptionExample() {
        String fileName = "/file1.txt";
        InputStream input = SimpleTest.class.getResourceAsStream(fileName);

        assumeTrue(input != null);

//        int numberLines = 0;
//        try (Scanner scanner = new Scanner(input)) {
//            while (scanner.hasNextLine()) {
//                scanner.nextLine();
//                ++numberLines;
//            }
//        }
        long numberLines = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            numberLines = reader.lines().count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(3, numberLines);
    }
}
