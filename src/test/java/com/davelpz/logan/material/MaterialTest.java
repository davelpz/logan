package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaterialTest {

    @Test
    public void lighting() {
        Shape object = new Sphere();
        Material m = new Material();
        m.setPattern(new StripePattern(Color.WHITE,Color.BLACK));
        m.setAmbient(1);
        m.setDiffuse(0);
        m.setSpecular(0);
        Tuple eyev = Tuple.vector(0,0,-1);
        Tuple normalv = Tuple.vector(0,0,-1);
        PointLight light = new PointLight(Color.WHITE, Tuple.point(0,0,-10));
        Color c1 = m.lighting(object,light,Tuple.point(0.9,0,0),eyev,normalv,false);
        Color c2 = m.lighting(object,light,Tuple.point(1.1,0,0),eyev,normalv,false);
        assertTrue(Color.WHITE.equals(c1));
        assertTrue(Color.BLACK.equals(c2));
    }
}