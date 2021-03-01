package com.davelpz.logan.ray;

import com.davelpz.logan.shapes.Sphere;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Intersection {
    public double t;
    public Sphere object;

    public Intersection(double t1, Sphere object) {
        this.t = t1;
        this.object = object;
    }

    public static Intersection[] intersections(Intersection ...vals) {
        Arrays.sort(vals);
        return vals;
    }

    public static Optional<Intersection> hit(Intersection[] xs) {
        Intersection found = null;
        for (Intersection i: xs) {
            if ( (i.t > 0.0) && ((found == null) || (i.t < found.t)) ) {
                    found = i;
            }
        }

        return Optional.ofNullable(found);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return Double.compare(that.t, t) == 0 && object.equals(that.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, object);
    }
}
