package com.davelpz.logan.shapes;

import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTest {

    @Test public void test1() {
        Shape s = new TestShape();
        assertTrue(s.getTransform().equals(Matrix.identity4));
    }

    @Test public void test2() {
        Shape s = new TestShape();
        s.setTransform(Matrix.translation(2,3,4));
        assertTrue(s.getTransform().equals(Matrix.translation(2,3,4)));
    }

    @Test public void test3() {
        Shape s = new TestShape();
        assertTrue(s.getMaterial().equals(new Material()));
    }

    @Test public void test4() {
        Shape s = new TestShape();
        Material m = new Material();
        m.setAmbient(1);
        s.setMaterial(m);
        assertTrue(s.getMaterial().equals(m));
    }

    @Test public void test5() {
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,0,1));
        TestShape s = new TestShape();
        s.setTransform(Matrix.scaling(2,2,2));
        Intersection[] xs = r.intersect(s);
        assertTrue(s.saved_ray.origin.equals(Tuple.point(0,0,-2.5)));
        assertTrue(s.saved_ray.direction.equals(Tuple.vector(0,0,0.5)));
    }

    @Test public void test6() {
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,0,1));
        TestShape s = new TestShape();
        s.setTransform(Matrix.translation(5,0,0));
        Intersection[] xs = r.intersect(s);
        assertTrue(s.saved_ray.origin.equals(Tuple.point(-5,0,-5)));
        assertTrue(s.saved_ray.direction.equals(Tuple.vector(0,0,1)));
    }

    @Test public void test7() {
        TestShape s = new TestShape();
        s.setTransform(Matrix.translation(0,1,0));
        Tuple n = s.normalAt(Tuple.point(0,1.70711, -0.70711));
        assertTrue(n.equals(Tuple.vector(0, 0.70711, -0.70711)));
    }
}