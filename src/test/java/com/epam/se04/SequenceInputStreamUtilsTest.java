package com.epam.se04;// import com.epam.se04.SequenceInputStreamUtils

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.epam.se04.SequenceInputStreamUtils.toStream;
import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class SequenceInputStreamUtilsTest {

    @Test
    @SneakyThrows
    @DisplayName("\"ToStream\" method works correctly")
    void testToStream() {
        // given
        @Cleanup val reader = new BufferedReader(
                new InputStreamReader(
                        toStream(
                                "file1.txt",
                                "file2.txt",
                                "file3.txt")));

        // when, then
        assertThat(reader.lines().reduce("", (s, s2) -> s + s2))
                .isEqualTo("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

    }
}