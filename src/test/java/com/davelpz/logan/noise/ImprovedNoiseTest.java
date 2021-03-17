package com.davelpz.logan.noise;

import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImprovedNoiseTest {

    @Test
    public void noise() {
        ImprovedNoise improvedNoise = new ImprovedNoise();
        double value = improvedNoise.noise(Tuple.point(2.1,1.2,1.3));
        System.out.println(value);
    }
}