package com.davelpz.logan.shapes;

import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test public void localNormalAt() {
        Plane p = new Plane();
        Tuple n1 = p.localNormalAt(Tuple.point(0,0,0));
        Tuple n2 = p.localNormalAt(Tuple.point(10,0,-10));
        Tuple n3 = p.localNormalAt(Tuple.point(-5,0,150));
        assertTrue(Tuple.vector(0,1,0).equals(n1));
        assertTrue(Tuple.vector(0,1,0).equals(n2));
        assertTrue(Tuple.vector(0,1,0).equals(n3));
    }

    @Test public void intersect() {
        Plane p = new Plane();
        Ray r = new Ray(Tuple.point(0,10,0), Tuple.vector(0,0,1));
        Intersection[] xs = p.intersect(r);
        assertEquals(0, xs.length);
    }

    @Test public void intersect2() {
        Plane p = new Plane();
        Ray r = new Ray(Tuple.point(0,0,0), Tuple.vector(0,0,1));
        Intersection[] xs = p.intersect(r);
        assertEquals(0, xs.length);
    }

    @Test public void intersect3() {
        Plane p = new Plane();
        Ray r = new Ray(Tuple.point(0,1,0), Tuple.vector(0,-1,0));
        Intersection[] xs = p.intersect(r);
        assertEquals(1, xs.length);
        assertEquals(1, xs[0].t,Tuple.EPSILON);
        assertTrue(p.equals(xs[0].object));
    }

    @Test public void intersect4() {
        Plane p = new Plane();
        Ray r = new Ray(Tuple.point(0,-1,0), Tuple.vector(0,1,0));
        Intersection[] xs = p.intersect(r);
        assertEquals(1, xs.length);
        assertEquals(1, xs[0].t,Tuple.EPSILON);
        assertTrue(p.equals(xs[0].object));
    }
}