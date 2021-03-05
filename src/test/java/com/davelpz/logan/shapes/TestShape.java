package com.davelpz.logan.shapes;

import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.tuple.Tuple;

public class TestShape extends Shape {
    public Ray saved_ray;

    @Override
    public Intersection[] intersect(Ray ray) {
        saved_ray = ray;
        return new Intersection[0];
    }

    @Override
    public Tuple localNormalAt(Tuple local_point) {
        return Tuple.vector(local_point.x(),local_point.y(),local_point.z());
    }
}
