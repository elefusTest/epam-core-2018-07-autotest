package com.epam.se04.properties;

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import static com.epam.se04.InputStreamUtils.withFileInputStream;
import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.core.Is.is;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class PropertiesHW {

    @Test
    @SneakyThrows
    @DisplayName("\"Name\" method works correctly")
    void testName() {
        // given
        assertTrue(new File("./src/test/resources/props.properties").exists());

        // when
        val properties = new Properties(4);
        withFileInputStream("props.properties", properties::load);

        // then
        assertThat(properties.getProperty("prop1"))
                .isEqualTo("50");

        assertThat(properties.getProperty("prop3", "jlhqgsf"))
                .isEqualTo("jlhqgsf");
    }
}
