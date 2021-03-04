package com.davelpz.logan.shapes;

import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;
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
}