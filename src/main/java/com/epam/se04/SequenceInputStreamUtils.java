package com.epam.se04;

import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.io.SequenceInputStream;

@UtilityClass
public class SequenceInputStreamUtils {

    public InputStream toStream(String fileName) {
        return SequenceInputStreamUtils.class.getResourceAsStream("/" + fileName);
    }

    public InputStream toStream(String... fileNames) {
        if (fileNames.length <= 1)
            return null;

        InputStream result = toStream(fileNames[0]);
        for (int i = 1; i < fileNames.length; i++)
            result = new SequenceInputStream(result,
                    toStream(fileNames[i]));
        return result;
    }
}
