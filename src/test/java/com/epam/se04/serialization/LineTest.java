package com.epam.se04.serialization;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class LineTest {

    @Test
    @SneakyThrows
    @DisplayName("Serialization & Deserialization works correctly")
    void testSerializationAndDeserializationWorksCorrectly() {
        // given

        // when

        // then
    }
}
