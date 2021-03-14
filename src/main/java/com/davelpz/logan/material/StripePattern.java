package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.tuple.Tuple;

public class StripePattern extends Pattern {
    public Color a;
    public Color b;

    public StripePattern(Color a, Color b) {
        this.a = a;
        this.b = b;
    }

    public Color pattern_at(Tuple point) {
        double x = point.x();
        if ( ( ((int)Math.floor(x)) % 2) == 0) {
            return a;
        } else {
            return b;
        }
    }
}
