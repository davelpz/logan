package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatternTest {

    @Test
    public void test1() {
        Pattern pattern = new TestPattern();
        assertTrue(pattern.getTransform().equals(Matrix.identity4));
    }

    @Test
    public void test2() {
        Pattern pattern = new TestPattern();
        pattern.setTransform(Matrix.translation(1,2,3));
        assertTrue(pattern.getTransform().equals(Matrix.translation(1,2,3)));
    }

    @Test
    public void test3() {
        Shape shape = new Sphere();
        shape.setTransform(Matrix.scaling(2,2,2));
        Pattern pattern = new TestPattern();
        Color c = pattern.pattern_at_shape(shape, Tuple.point(2,3,4));
        assertTrue(c.equals(new Color(1,1.5,2)));
    }

    @Test
    public void test4() {
        Shape shape = new Sphere();
        Pattern pattern = new TestPattern();
        pattern.setTransform(Matrix.scaling(2,2,2));
        Color c = pattern.pattern_at_shape(shape, Tuple.point(2,3,4));
        assertTrue(c.equals(new Color(1,1.5,2)));
    }

    @Test
    public void test5() {
        Shape shape = new Sphere();
        shape.setTransform(Matrix.scaling(2,2,2));
        Pattern pattern = new TestPattern();
        pattern.setTransform(Matrix.translation(0.5,1,1.5));
        Color c = pattern.pattern_at_shape(shape, Tuple.point(2.5,3,3.5));
        assertTrue(c.equals(new Color(0.75,0.5,0.25)));
    }
}