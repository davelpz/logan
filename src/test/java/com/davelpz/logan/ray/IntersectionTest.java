package com.davelpz.logan.ray;

import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.shapes.Plane;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import io.cucumber.java.sl.In;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionTest {

    @Test
    public void prepare_computations() {
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,0,1));
        Sphere shape = new Sphere();
        Intersection i = new Intersection(4,shape);
        Computation comps = i.prepare_computations(r);

        assertEquals(i.t,comps.t,0.00001);
        assertTrue(i.object.equals(comps.object));
        assertTrue(comps.point.equals(Tuple.point(0,0,-1)));
        assertTrue(comps.eyev.equals(Tuple.vector(0,0,-1)));
        assertTrue(comps.normalv.equals(Tuple.vector(0,0,-1)));
    }

    @Test
    public void prepare_computations2() {
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,0,1));
        Sphere shape = new Sphere();
        Intersection i = new Intersection(4,shape);
        Computation comps = i.prepare_computations(r);

        assertFalse(comps.inside);
    }

    @Test
    public void prepare_computations3() {
        Ray r = new Ray(Tuple.point(0,0,0), Tuple.vector(0,0,1));
        Sphere shape = new Sphere();
        Intersection i = new Intersection(1,shape);
        Computation comps = i.prepare_computations(r);

        assertTrue(comps.point.equals(Tuple.point(0,0,1)));
        assertTrue(comps.eyev.equals(Tuple.vector(0,0,-1)));
        assertTrue(comps.inside);
        assertTrue(comps.normalv.equals(Tuple.vector(0,0,-1)));
    }

    @Test
    public void prepare_computations4() {
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,0,1));
        Sphere shape = new Sphere();
        shape.setTransform(Matrix.translation(0,0,1));
        Intersection i = new Intersection(5,shape);
        Computation comps = i.prepare_computations(r);

        assertTrue(comps.over_point.z() < (Tuple.EPSILON/2.0));
        assertTrue(comps.point.z() > comps.over_point.z());
    }

    @Test
    public void testPrepare_computations() {
        Shape shape = new Plane();
        Ray r = new Ray(Tuple.point(0,1,-1), Tuple.vector(0,-Math.sqrt(2)/2.0,Math.sqrt(2)/2.0));
        Intersection i = new Intersection(Math.sqrt(2),shape);
        Computation comps = i.prepare_computations(r);
        assertTrue(comps.reflectv.equals(Tuple.vector(0,Math.sqrt(2)/2.0,Math.sqrt(2)/2.0),0.0001));
    }
}