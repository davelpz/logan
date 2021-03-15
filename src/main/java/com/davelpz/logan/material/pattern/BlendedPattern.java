package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

public class BlendedPattern extends AbstractPattern {
    public Pattern a;
    public Pattern b;

    public BlendedPattern(Pattern a, Pattern b) {
        this.a = a;
        this.b = b;
    }

    @Override public Color pattern_at(Tuple point) {
        Color colorA = a.pattern_at_object_point(point);
        Color colorB = b.pattern_at_object_point(point);
        return colorA.add(colorB).div(2.0);
    }
}
