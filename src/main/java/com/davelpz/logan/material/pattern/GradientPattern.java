package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

public class GradientPattern extends AbstractPattern {
    public Color a;
    public Color b;

    public GradientPattern(Color a, Color b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Color pattern_at(Tuple point) {
        Color distance = b.subtract(a);
        double fraction = point.x() - Math.floor(point.x());
        return a.add(distance.mul(fraction));
    }
}
