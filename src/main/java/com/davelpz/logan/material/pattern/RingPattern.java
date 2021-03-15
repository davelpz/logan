package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.material.pattern.Pattern;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

public class RingPattern extends AbstractPattern {
    public Pattern a;
    public Pattern b;

    public RingPattern(Pattern a, Pattern b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Color pattern_at(Tuple point) {
        double dist = Math.sqrt(point.x()*point.x() + point.z()*point.z());
        if ((Math.floor(dist) % 2) == 0) {
            return a.pattern_at(point);
        }
        return b.pattern_at(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RingPattern that = (RingPattern) o;
        return a.equals(that.a) && b.equals(that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b);
    }

}
