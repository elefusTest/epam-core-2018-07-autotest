package com.epam.se04;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.InputStream;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public final class NonCloseableInputStream extends InputStream {

    @Delegate(excludes = AutoCloseable.class)
    InputStream inputStream;

    @Override
    public void close() {
    }
}
