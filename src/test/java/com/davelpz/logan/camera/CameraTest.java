package com.davelpz.logan.camera;

import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class CameraTest {

    @Test public void test1() {
        Camera camera = new Camera(160,120,Math.PI/2.0);
        assertEquals(160,camera.getHsize());
        assertEquals(120,camera.getVsize());
        assertEquals(Math.PI/2.0,camera.getField_of_view(),0.00001);
        assertTrue(Matrix.identity4.equals(camera.getTransform()));
    }

    @Test public void test2() {
        Camera camera = new Camera(200, 125, Math.PI / 2.0);
        assertEquals(0.01, camera.getPixel_size(),0.0001);
    }

    @Test public void test3() {
        Camera camera = new Camera(125, 200, Math.PI / 2.0);
        assertEquals(0.01, camera.getPixel_size(),0.0001);
    }

    @Test public void test4() {
        Camera camera = new Camera(201, 101, Math.PI / 2.0);
        Ray r = camera.rayForPixel(100,50);
        assertTrue(r.origin.equals(Tuple.point(0,0,0)));
        assertTrue(r.direction.equals(Tuple.vector(0,0,-1)));
    }

    @Test public void test5() {
        Camera camera = new Camera(201, 101, Math.PI / 2.0);
        Ray r = camera.rayForPixel(0,0);
        assertTrue(r.origin.equals(Tuple.point(0,0,0)));
        assertTrue(r.direction.equals(Tuple.vector(0.66519,0.33259,-0.66851)));
    }

    @Test public void test6() {
        Camera camera = new Camera(201, 101, Math.PI / 2.0);
        camera.setTransform(Matrix.rotationY(Math.PI/4.0).multiply(Matrix.translation(0,-2,5)));
        Ray r = camera.rayForPixel(100,50);
        assertTrue(r.origin.equals(Tuple.point(0,2,-5)));
        assertTrue(r.direction.equals(Tuple.vector(Math.sqrt(2)/2.0,0.0,-Math.sqrt(2)/2.0)));
    }
}