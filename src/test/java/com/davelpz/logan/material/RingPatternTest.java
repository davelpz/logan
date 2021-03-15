package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.material.pattern.Pattern;
import com.davelpz.logan.material.pattern.RingPattern;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class RingPatternTest {

    @Test
    public void pattern_at() {
        Pattern pattern = new RingPattern(Color.WHITE, Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,0))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(1,0,0))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(0,0,1))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(0.708,0,0.708))));
    }
}