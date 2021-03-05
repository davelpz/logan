package com.davelpz.logan.shapes;

import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

public class Sphere extends Shape {
    public Tuple center;
    public double radius;

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

    @Override
    public Tuple localNormalAt(Tuple local_point) {
        return local_point.subtract(Tuple.point(0,0,0));
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

    @Override
    public Intersection[] intersect(Ray r) {
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
            return Intersection.intersections(new Intersection(t1, this), new Intersection(t2, this));
        } else {
            return Intersection.intersections(new Intersection(t2, this), new Intersection(t1, this));
        }
    }
}
