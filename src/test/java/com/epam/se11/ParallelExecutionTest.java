package com.epam.se11;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class ParallelExecutionTest {

    @Test
    void test1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    void test2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    void test3() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    void test4() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }
}
