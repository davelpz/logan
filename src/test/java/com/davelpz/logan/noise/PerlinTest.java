package com.davelpz.logan.noise;

import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerlinTest {

    @Test
    public void noise() {
        Perlin perlin = new Perlin();
        double value = perlin.noise(Tuple.point(2.1,1.2,1.3));
        System.out.println(value);

    }
}