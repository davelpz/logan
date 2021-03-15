package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.material.pattern.Pattern;
import com.davelpz.logan.tuple.Tuple;

public class StripePattern extends AbstractPattern {
    public Color a;
    public Color b;

    public StripePattern(Color a, Color b) {
        this.a = a;
        this.b = b;
    }

    public Color pattern_at(Tuple point) {
        double x = point.x();
        if ( ( (Math.floor(x)) % 2) == 0) {
            return a;
        } else {
            return b;
        }
    }
}
