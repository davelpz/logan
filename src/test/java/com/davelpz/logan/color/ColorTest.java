package com.davelpz.logan.color;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void clamp() {
        Color c = new Color(-1,-1,-1);
        c.clamp(0,100);
        assertTrue(Color.BLACK.equals(c));
        c = new Color(255,255,255);
        c.clamp(0,100);
        assertTrue(new Color(100,100,100).equals(c));
    }

    @Test
    public void testToString() {
        assertEquals("Color{values=[0.0, 0.0, 0.0]}",(Color.BLACK).toString());
    }
}