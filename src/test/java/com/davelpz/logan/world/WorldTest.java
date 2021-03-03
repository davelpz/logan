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
}