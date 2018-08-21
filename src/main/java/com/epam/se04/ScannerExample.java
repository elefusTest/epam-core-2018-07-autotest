package com.epam.se04;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.io.InputStream;
import java.util.Scanner;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class ScannerExample {

    @SneakyThrows
    public static void main(String... __) { //"1,3;2,0; 8,5; 4,8; 9,0; 1; 10"
//        double sum = 0.0;
//        val scan = new Scanner(System.in);
////        scan.useDelimiter(";\\s*");
//        while (scan.hasNext())
//            if (scan.hasNextDouble())
//                sum += scan.nextDouble();
//            else
//                System.out.println(scan.next());
//        System.out.printf("Сумма чисел = " + sum);

        readFromScanner();

        System.out.write(104); // ASCII 'h'
        System.out.write('\n');

        byte[] b1 = new byte[5];
        System.in.read(b1);
        System.out.write(b1);
        System.out.write('\n');

        byte[] b2 = new byte[System.in.available()];
        int len = b2.length;
        for (int i = 0; i < len; i++)
            b2[i] = (byte) System.in.read();
        System.out.println(b2[0]);

    }

    public static void readFromScanner() {
        InputStream in = new CloseableInputStream(System.in);
        @Cleanup val scanner = new Scanner(in);
        while ((scanner.hasNext())) {
            String next = scanner.next();
            if (next.equals("C")) {
                return;
            }
            System.out.println(next);
        }
    }

}
