package com.epam.s06;// import com.epam.s06.MapUtils

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.epam.s06.MapUtils.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MapUtilsTest {
    @Test
    @SneakyThrows
    @DisplayName("\"Of\" method works correctly")
    void testOf() {
        // given
        // when
        java.util.Map<Object, Object> map = MapUtils.of();

        // then
        assertThrows(UnsupportedOperationException.class, () -> {
            //noinspection ConstantConditions
            map.put(1, 1);
        });

        assertThat(map.size()).isEqualTo(0);
    }

    @Test
    @SneakyThrows
    @DisplayName("\"Of1\" method works correctly")
    void testOf1() {
        // given// when
        Map<Integer, Integer> map = MapUtils.of(1, 1);

        // then
        assertThrows(UnsupportedOperationException.class, () -> {
            //noinspection ConstantConditions
            map.put(1, 1);
        });

        assertThat(map.size()).isEqualTo(1);
    }

    @Test
    @SneakyThrows
    @DisplayName("\"Of2\" method works correctly")
    void testOf2() {
        // given
        // when
        Map<Integer, Integer> map = MapUtils.of(
                entry(1, 1),
                entry(2, 2),
                entry(3, 3));

        // then
        // then
        assertThrows(UnsupportedOperationException.class, () -> {
            //noinspection ConstantConditions
            map.put(1, 1);
        });

        assertThat(map.size()).isEqualTo(3);

        assertThat(map.get(1)).isEqualTo(1);
        assertThat(map.get(2)).isEqualTo(2);
        assertThat(map.get(3)).isEqualTo(3);
    }

}