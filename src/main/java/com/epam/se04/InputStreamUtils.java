package com.epam.se04;

import io.vavr.CheckedConsumer;
import io.vavr.CheckedFunction1;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;

public interface InputStreamUtils {

    @SneakyThrows
    static <T> T mapFileInputStream(@NotNull String fileName,
                                    @NotNull CheckedFunction1<InputStream, T> mapper) {
        @Cleanup val inputStream =
                InputStreamUtils.class.getResourceAsStream("/" + fileName);
        return mapper.apply(inputStream);
    }

    @SneakyThrows
    static void withFileInputStream(@NotNull String fileName,
                                    @NotNull CheckedConsumer<InputStream> consumer) {
        @Cleanup val inputStream =
                InputStreamUtils.class.getResourceAsStream("/" + fileName);
        consumer.accept(inputStream);
    }


}
