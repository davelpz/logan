package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

public class GradientPattern extends AbstractPattern {
    public Pattern a;
    public Pattern b;

    public GradientPattern(Pattern a, Pattern b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Color pattern_at(Tuple point) {
        Color ca = a.pattern_at(point);
        Color cb = b.pattern_at(point);
        Color distance = cb.subtract(ca);
        double fraction = point.x() - Math.floor(point.x());
        return ca.add(distance.mul(fraction));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GradientPattern that = (GradientPattern) o;
        return a.equals(that.a) && b.equals(that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b);
    }

}
