package com.epam.se04;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class FileIOExample {

    @SneakyThrows
    public static void main(String... __) {
//        @Cleanup FileInputStream inFile1 = new FileInputStream("file1.txt");
//        @Cleanup FileInputStream inFile2 = new FileInputStream("file3.txt");
        // ClassLoaderUsage
        @Cleanup InputStream sequenceStream = toStream("file1.txt",
                "file2.txt", "file3.txt");

        @Cleanup val outFile = new FileOutputStream("file4.txt");
        int readedByte = sequenceStream.read();
        while (readedByte != -1) {
            outFile.write(readedByte);
            readedByte = sequenceStream.read();
        }
    }

    public static InputStream toStream(String fileName) {
        return FileIOExample.class.getResourceAsStream("/" + fileName);
    }

    public static InputStream toStream(String... fileNames) {
        if (fileNames.length <= 1)
            return null;

        InputStream result = toStream(fileNames[0]);
        for (int i = 1; i < fileNames.length; i++)
            result = new SequenceInputStream(result, toStream(fileNames[i]));
        return result;
    }
}
