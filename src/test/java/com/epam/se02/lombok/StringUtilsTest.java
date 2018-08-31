package com.epam.se02.lombok;// import com.epam.se02.lombok.StringUtils

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class StringUtilsTest {
    @Test
    @SneakyThrows
    @DisplayName("\"WithSymbol\" method works correctly")
    void testWithSymbol() {
        // given, when, then
        assertThat(StringUtils.withSymbol("jhgasdf", '?'))
                .isEqualTo("jhgasdf?");
    }

}