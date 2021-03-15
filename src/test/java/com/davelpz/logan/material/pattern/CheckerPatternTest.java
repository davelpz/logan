package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckerPatternTest {

    @Test
    public void pattern_at() {
        AbstractPattern pattern = new CheckerPattern(Color.WHITE,Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,0))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0.99,0,0))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(1.01,0,0))));
    }

    @Test
    public void pattern_at2() {
        AbstractPattern pattern = new CheckerPattern(Color.WHITE,Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,0))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0, 0.99,0))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(0, 1.01,0))));
    }

    @Test
    public void pattern_at3() {
        AbstractPattern pattern = new CheckerPattern(Color.WHITE,Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,0))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0, 0, 0.99))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(0, 0, 1.01))));
    }
}