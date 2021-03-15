package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

public class CheckerPattern extends AbstractPattern {
    public Pattern a;
    public Pattern b;

    public CheckerPattern(Pattern a, Pattern b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Color pattern_at(Tuple point) {
        double x = Math.floor(point.x());
        double y = Math.floor(point.y());
        double z = Math.floor(point.z());

        if (((x+y+z) % 2) == 0) {
            return a.pattern_at_object_point(point);
        }
        return b.pattern_at_object_point(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CheckerPattern that = (CheckerPattern) o;
        return a.equals(that.a) && b.equals(that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b);
    }
}
