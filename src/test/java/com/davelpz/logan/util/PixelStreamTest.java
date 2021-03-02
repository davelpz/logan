package com.davelpz.logan.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class PixelStreamTest {

    @Test public void genStream() {
        AtomicInteger count = new AtomicInteger();
        PixelStream.genStream(10, 10).forEach(p -> {
            System.out.println(p);
            count.getAndIncrement();
        });
        assertEquals(100, count.get());
    }
}