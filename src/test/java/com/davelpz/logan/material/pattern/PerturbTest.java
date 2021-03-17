package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerturbTest {

    @Test
    public void pattern_at() {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        Perturb perturb = new Perturb(Color.WHITE, 1.0);
        double value = perturb.turb(Tuple.point(-3, 2, 1));
    }
}