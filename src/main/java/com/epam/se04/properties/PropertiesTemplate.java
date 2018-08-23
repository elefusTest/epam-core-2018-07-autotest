package com.epam.se04.properties;

import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.function.Supplier;

import static com.epam.se04.InputStreamUtils.withFileInputStream;

@FunctionalInterface
public interface PropertiesTemplate extends Supplier<Properties> {

    @NotNull
    static PropertiesTemplate from(String fileName) {
        val properties = new Properties(4);
        withFileInputStream(fileName + ".properties", properties::load);
        return () -> properties;
    }

    default Optional<String> getAndRemove(String key) {
        return Optional.ofNullable((String) get().remove(key));
    }

    default boolean containsOnlyKeys(String... keys) {
        val properties = get();
        return properties.size() == keys.length
//                && properties.keySet().containsAll(Set.of(keys)); // Java 9+
                && properties.keySet().containsAll(Arrays.asList(keys)); // Java 8+
    }
}
