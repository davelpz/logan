package com.davelpz.logan.ray;

import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

public class Ray {
    public Tuple origin;
    public Tuple direction;

    public Ray(Tuple origin, Tuple direction) {
        this.origin = origin;
        this.direction = direction;
    }

    private static Tuple position(Ray r, double t) {
        return r.origin.add(r.direction.mul(t));
    }

    public Ray transform(Matrix m) {
        return new Ray(m.multiply(this.origin), m.multiply(this.direction));
    }

    public Intersection[] intersect(Shape s) {
        Ray r = this.transform(s.transform.inverse());
        return s.intersect(r);
    }

    public Tuple getOrigin() {
        return origin;
    }

    public void setOrigin(Tuple origin) {
        this.origin = origin;
    }

    public Tuple getDirection() {
        return direction;
    }

    public void setDirection(Tuple direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return origin.equals(ray.origin) && direction.equals(ray.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, direction);
    }

    public Tuple position(double t) {
        return position(this, t);
    }
}
