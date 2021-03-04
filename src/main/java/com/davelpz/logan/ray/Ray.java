package com.davelpz.logan.ray;

import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.shapes.Sphere;
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

    public Intersection[] intersects(Sphere s) {
        Ray r = this.transform(s.transform.inverse());
        Tuple sphere_to_ray = r.origin.subtract(Tuple.point(0, 0, 0));
        double a = r.direction.dot(r.direction);
        double b = 2 * r.direction.dot(sphere_to_ray);
        double c = sphere_to_ray.dot(sphere_to_ray) - 1;
        double discriminant = (b * b) - 4 * a * c;

        if (discriminant < 0) {
            return new Intersection[0];
        }

        double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
        double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);

        if (t1 < t2) {
            return Intersection.intersections(new Intersection(t1, s), new Intersection(t2, s));
        } else {
            return Intersection.intersections(new Intersection(t2, s), new Intersection(t1, s));
        }
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
