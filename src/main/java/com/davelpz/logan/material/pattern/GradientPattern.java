package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

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
