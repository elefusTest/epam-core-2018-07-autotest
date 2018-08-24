package com.epam.se04.properties;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static com.epam.se04.InputStreamUtils.withFileInputStream;
import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(level = PRIVATE, makeFinal = true)
final class PropertiesTest {
    static String PROPS_FILE_NAME = "props.properties";
    static Properties properties = new Properties();

    @BeforeAll
    static void setUp() {
        withFileInputStream(PROPS_FILE_NAME, properties::load);
    }

    @Test
    @DisplayName("getProperties method works correctly")
    void getProperties() {
        assertThat(properties.getProperty("prop1")).isEqualTo("50");
        assertThat(properties.getProperty("prop2", "3")).isEqualTo("qwerty!");
        assertThat(properties.getProperty("prop3", "3")).isEqualTo("3");
    }

}
