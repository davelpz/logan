package com.davelpz.logan.shapes;

import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.tuple.Tuple;

public class Plane extends Shape {
    @Override public Intersection[] intersect(Ray ray) {
        if (Math.abs(ray.direction.y()) < Tuple.EPSILON) {
            return new Intersection[0];
        }

        double t = -ray.origin.y() / ray.direction.y();

        return new Intersection[] { new Intersection(t, this) };
    }

    @Override public Tuple localNormalAt(Tuple local_point) {
        return Tuple.vector(0, 1, 0);
    }
}
