package com.epam.se04.properties;

import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class PropertiesTemplateTest {

//    PropertiesTemplate propertiesTemplate = PropertiesTemplate.from("props");

//    Properties properties = propertiesTemplate.get();

    @Test
    @DisplayName("\"getAndRemove\" method works correctly")
    void testGetAndRemove() {
        // given
//        assertThat(properties.size()).isEqualTo(4);
//        assertThat(properties).containsOnlyKeys(
//                "prop1", "prop2", "p3.p1", "p3.p2");

        // then
//        assertThat(propertiesTemplate.getAndRemove("prop1"))
//                .isPresent()
//                .contains("50");

//        assertThat(properties.size()).isEqualTo(3);
//        assertThat(properties).containsOnlyKeys("prop2", "p3.p1", "p3.p2");
    }

    @Test
    @DisplayName("\"containsOnlyKeys\" method works correctly")
    void testContainsOnlyKeys() {
        // given
//        assertThat(properties.size()).isEqualTo(4);
//        assertThat(properties).containsOnlyKeys("prop1", "prop2", "p3.p1", "p3.p2");

        // then
//        assertTrue(propertiesTemplate.containsOnlyKeys("prop1", "prop2", "p3.p1", "p3.p2"));
//        assertFalse(propertiesTemplate.containsOnlyKeys("prop1", "p3.p1", "p3.p2"));
    }
}
