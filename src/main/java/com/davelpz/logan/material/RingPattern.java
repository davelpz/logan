package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

public class RingPattern extends Pattern {
    public Color a;
    public Color b;

    public RingPattern(Color a, Color b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Color pattern_at(Tuple point) {
        double dist = Math.sqrt(point.x()*point.x() + point.z()*point.z());
        if ((Math.floor(dist) % 2) == 0) {
            return a;
        }
        return b;
    }
}
