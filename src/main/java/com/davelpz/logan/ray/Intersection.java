package com.davelpz.logan.ray;

import com.davelpz.logan.shapes.Sphere;

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
}
