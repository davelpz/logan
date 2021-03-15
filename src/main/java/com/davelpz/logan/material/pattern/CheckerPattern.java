package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

public class CheckerPattern extends AbstractPattern {
    public Color a;
    public Color b;

    public CheckerPattern(Color a, Color b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Color pattern_at(Tuple point) {
        double x = Math.floor(point.x());
        double y = Math.floor(point.y());
        double z = Math.floor(point.z());

        if (((x+y+z) % 2) == 0) {
            return a;
        }
        return b;
    }
}
