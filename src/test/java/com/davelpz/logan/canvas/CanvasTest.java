package com.davelpz.logan.canvas;

import com.davelpz.logan.color.Color;
import org.junit.Test;

import java.io.IOException;
import java.io.Writer;

import static org.junit.Assert.*;

public class CanvasTest {

    @Test()
    public void canvasToPPM() {
        Canvas c = new Canvas(10.0,10.0);
        c.canvasToPPM(new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {
                throw new IOException();
            }

            @Override
            public void flush() throws IOException {
                throw new IOException();
            }

            @Override
            public void close() throws IOException {
                throw new IOException();
            }
        });
    }

    @Test
    public void getBuffer() {
        Canvas c = new Canvas(10,10);
        Color[][] buf = c.getBuffer();
        assertNotNull(buf);
    }
}