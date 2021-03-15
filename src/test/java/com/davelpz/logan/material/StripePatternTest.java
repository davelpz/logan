package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.material.pattern.StripePattern;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class StripePatternTest {

    @Test
    public void test1() {
        StripePattern pattern = new StripePattern(Color.WHITE, Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.a));
        assertTrue(Color.BLACK.equals(pattern.b));
    }

    @Test
    public void test2() {
        StripePattern pattern = new StripePattern(Color.WHITE, Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,0))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,1,0))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,2,0))));
    }

    @Test
    public void test3() {
        StripePattern pattern = new StripePattern(Color.WHITE, Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,0))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,1))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,2))));
    }

    @Test
    public void test4() {
        StripePattern pattern = new StripePattern(Color.WHITE, Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0,0,0))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(0.9,0,0))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(1,0,0))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(-0.1,0,0))));
        assertTrue(Color.BLACK.equals(pattern.pattern_at(Tuple.point(-1,0,0))));
        assertTrue(Color.WHITE.equals(pattern.pattern_at(Tuple.point(-1.1,0,0))));
    }

    @Test
    public void test5() {
        Shape object = new Sphere();
        object.setTransform(Matrix.scaling(2,2,2));
        StripePattern pattern = new StripePattern(Color.WHITE, Color.BLACK);
        assertTrue(Color.WHITE.equals(pattern.pattern_at_shape(object, Tuple.point(1.5,0,0))));
    }

    @Test
    public void test6() {
        Shape object = new Sphere();
        StripePattern pattern = new StripePattern(Color.WHITE, Color.BLACK);
        pattern.setTransform(Matrix.scaling(2,2,2));
        assertTrue(Color.WHITE.equals(pattern.pattern_at_shape(object, Tuple.point(1.5,0,0))));
    }

    @Test
    public void test7() {
        Shape object = new Sphere();
        object.setTransform(Matrix.scaling(2,2,2));
        StripePattern pattern = new StripePattern(Color.WHITE, Color.BLACK);
        pattern.setTransform(Matrix.translation(0.5,0,0));
        assertTrue(Color.WHITE.equals(pattern.pattern_at_shape(object, Tuple.point(2.5,0,0))));
    }
}