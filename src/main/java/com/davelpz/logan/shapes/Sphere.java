package com.davelpz.logan.shapes;

import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

public class Sphere {
    public Tuple center;
    public double radius;
    public Matrix transform = Matrix.identity4;

    public Sphere() {
        this.center = Tuple.point(0,0,0);
        this.radius = 1;
    }

    public Sphere(Tuple center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Tuple getCenter() {
        return center;
    }

    public void setCenter(Tuple center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 && center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
