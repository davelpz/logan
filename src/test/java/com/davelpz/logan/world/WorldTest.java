package com.davelpz.logan.world;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.ray.Computation;
import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import io.cucumber.java.sl.In;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void createAWorld() {
        World w = new World();
        assertEquals(0,w.getLights().size());
        assertEquals(0,w.getObjects().size());
    }

    @Test
    public void defaultWorld() {
        World w = World.defaultWorld();

        PointLight light = new PointLight(new Color(1, 1, 1), Tuple.point(-10, 10, -10));
        Sphere s = new Sphere();
        Material m = new Material();
        m.setColor(new Color(0.8, 1.0, 0.6));
        m.setDiffuse(0.7);
        m.setSpecular(0.2);

        Sphere s2 = new Sphere();
        s2.setTransform(Matrix.scaling(0.5,0.5,0.5));

        assertTrue(light.equals(w.getLights().get(0)));
        assertTrue(w.getObjects().contains(s));
        assertTrue(w.getObjects().contains(s2));
    }

    @Test
    public void intersectWorld() {
        World w = World.defaultWorld();
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,0,1));
        Intersection[] xs = w.intersect_world(r);

        assertEquals(4,xs.length);
        assertEquals(4,xs[0].t,0.00001);
        assertEquals(4.5,xs[1].t,0.00001);
        assertEquals(5.5,xs[2].t,0.00001);
        assertEquals(6,xs[3].t,0.00001);
    }

    @Test
    public void shade_hit() {
        World w = World.defaultWorld();
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,0,1));
        Sphere shape = w.getObjects().get(0);
        Intersection i = new Intersection(4,shape);
        Computation comps = i.prepare_computations(r);
        Color c = w.shade_hit(comps);
        assertTrue(c.equals(new Color(0.38066,0.47583,0.2855)));
    }

    @Test
    public void color_at() {
        World w = World.defaultWorld();
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,1,0));
        Color c = w.color_at(r);
        assertTrue(c.equals(new Color(0,0,0)));
    }

    @Test
    public void color_at2() {
        World w = World.defaultWorld();
        Ray r = new Ray(Tuple.point(0,0,-5), Tuple.vector(0,0,1));
        Color c = w.color_at(r);
        assertTrue(c.equals(new Color(0.38066,0.47583,0.2855)));
    }

    @Test
    public void color_at3() {
        World w = World.defaultWorld();
        Sphere outer = w.getObjects().get(0);
        outer.material.setAmbient(1);
        Sphere inner = w.getObjects().get(1);
        inner.material.setAmbient(1);
        Ray r = new Ray(Tuple.point(0,0,0.75), Tuple.vector(0,0,-1));
        Color c = w.color_at(r);
        assertTrue(c.equals(inner.material.getColor()));
    }

    @Test
    public void view_transform() {
        Tuple from = Tuple.point(0,0,0);
        Tuple to = Tuple.point(0,0,-1);
        Tuple up = Tuple.vector(0,1,0);
        Matrix t = World.view_transform(from,to,up);
        assertTrue(t.equals(Matrix.identity4));
    }

    @Test
    public void view_transform2() {
        Tuple from = Tuple.point(0,0,0);
        Tuple to = Tuple.point(0,0,1);
        Tuple up = Tuple.vector(0,1,0);
        Matrix t = World.view_transform(from,to,up);
        assertTrue(t.equals(Matrix.scaling(-1,1,-1)));
    }

    @Test
    public void view_transform3() {
        Tuple from = Tuple.point(0,0,8);
        Tuple to = Tuple.point(0,0,0);
        Tuple up = Tuple.vector(0,1,0);
        Matrix t = World.view_transform(from,to,up);
        assertTrue(t.equals(Matrix.translation(0,0,-8)));
    }

    @Test
    public void view_transform4() {
        Tuple from = Tuple.point(1,3,2);
        Tuple to = Tuple.point(4,-2,8);
        Tuple up = Tuple.vector(1,1,0);
        Matrix t = World.view_transform(from,to,up);
        Matrix expected = new Matrix(4);
        expected.set(0,0, -0.50709);
        expected.set(0,1, 0.50709);
        expected.set(0,2, 0.67612);
        expected.set(0,3, -2.36643);
        expected.set(1,0, 0.76772);
        expected.set(1,1, 0.60609);
        expected.set(1,2, 0.12122);
        expected.set(1,3, -2.82843);
        expected.set(2,0, -0.35857);
        expected.set(2,1, 0.59761);
        expected.set(2,2, -0.71714);
        expected.set(2,3, 0.00000);
        expected.set(3,0, 0.00000);
        expected.set(3,1, 0.00000);
        expected.set(3,2, 0.00000);
        expected.set(3,3, 1.00000);

        assertTrue(t.equals(expected));
    }

    @Test
    public void test1() {
        World w = World.defaultWorld();
        Tuple p = Tuple.point(0,10,0);
        assertFalse(w.is_shadowed(p));
    }

    @Test
    public void test2() {
        World w = World.defaultWorld();
        Tuple p = Tuple.point(10,-10,10);
        assertTrue(w.is_shadowed(p));
    }

    @Test
    public void test3() {
        World w = World.defaultWorld();
        Tuple p = Tuple.point(-20,20,-20);
        assertFalse(w.is_shadowed(p));
    }

    @Test
    public void test4() {
        World w = World.defaultWorld();
        Tuple p = Tuple.point(-2,2,-2);
        assertFalse(w.is_shadowed(p));
    }


}