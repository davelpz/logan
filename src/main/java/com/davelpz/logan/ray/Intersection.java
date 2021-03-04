package com.davelpz.logan.ray;

import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;

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

    public Computation prepare_computations(Ray r) {
        Computation comps = new Computation();

        // copy the intersections properties, for convenience
        comps.t = this.t;
        comps.object = this.object;

        // precompute some useful values
        comps.point = r.position(comps.t);
        comps.eyev = r.direction.negate();
        comps.normalv = comps.object.normalAt(comps.point);

        if (comps.normalv.dot(comps.eyev) < 0) {
            comps.inside = true;
            comps.normalv = comps.normalv.negate();
        } else {
            comps.inside = false;
        }

        // after computing and (if appropriate) negating
        // the normal vector...
        comps.over_point = comps.point.add(comps.normalv.mul(Tuple.EPSILON));

        return comps;
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
