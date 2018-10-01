package com.epam.se10;

import lombok.SneakyThrows;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class Launcher {

    private static final Logger LOG = LogManager.getLogger(Launcher.class);
//    private static final Logger LOG = LogManager.getLogger("com.epam.se10.Launcher");

    public static void main(String[] args) throws InterruptedException {

        LOG.trace(Launcher::prepareTraceMethod);
        LOG.log(Level.TRACE, "trace message");
        LOG.log(Level.INFO, "info message");
        LOG.log(Level.FATAL, "fatal message");
        LOG.fatal("fatal message 2");



        //       ""
        // com
        // com.epam
        // com.epam.se10
        // com.epam.se10.Launhcer
        //
        //
    }

    @SneakyThrows
    private static String prepareTraceMethod() {
        Thread.sleep(100000);
        return "hello from trace";
    }
}
