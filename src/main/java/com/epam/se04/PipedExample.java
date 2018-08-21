package com.epam.se04;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class PipedExample {
    @SneakyThrows
    public static void main(String... __) {

        @Cleanup PipedInputStream pipeIn = new PipedInputStream();
        @Cleanup PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);
        for (int i = 0; i < 20; i++)
            pipeOut.write(i);

        int willRead = pipeIn.available();
        int[] toRead = new int[willRead];

        for (int i = 0; i < willRead; i++) {
            toRead[i] = pipeIn.read();
            System.out.print(toRead[i] + " ");
        }
    }
}
