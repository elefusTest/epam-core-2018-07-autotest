package com.epam.se04.properties;

import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class PropertiesTemplateTest {

    PropertiesTemplate propertiesTemplate = PropertiesTemplate.of("props");

    Properties properties = propertiesTemplate.get();

    @Test
    @DisplayName("\"getAndRemove\" method works correctly")
    void testGetAndRemove() {
        // given
        assertThat(properties.size()).isEqualTo(4);
        assertThat(properties).containsOnlyKeys(
                "prop1", "prop2", "p3.p1", "p3.p2");

        // then
        assertThat(propertiesTemplate.getAndRemove("prop1"))
                .isPresent()
                .contains("50");

        assertThat(properties.size()).isEqualTo(3);
        assertThat(properties).containsOnlyKeys("prop2", "p3.p1", "p3.p2");
    }

    @Test
    @DisplayName("\"containsOnlyKeys\" method works correctly")
    void testContainsOnlyKeys() {
        // given
        assertThat(properties.size()).isEqualTo(4);
        assertThat(properties).containsOnlyKeys("prop1", "prop2", "p3.p1", "p3.p2");

        // then
        assertTrue(propertiesTemplate.containsOnlyKeys("prop1", "prop2", "p3.p1", "p3.p2"));
        assertFalse(propertiesTemplate.containsOnlyKeys("prop1", "p3.p1", "p3.p2"));
    }

    @Test
    @DisplayName("From method works correctly")
    void testFrom() {
        val props = PropertiesTemplate.from(Props.class);
        MatcherAssert.assertThat(props.getProp1(), is(50));
        MatcherAssert.assertThat(props.getProp2(), is("qwerty!"));
        Props2 p3 = props.getP3();
        MatcherAssert.assertThat(p3.getP1(), is(2));
        MatcherAssert.assertThat(p3.getP2(), is("qwerty!!!"));
    }
}

@Value
class Props {
    int prop1;
    String prop2;
    Props2 p3;
}

@Value
class Props2 {
    int p1;
    String p2;
}