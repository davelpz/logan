package com.davelpz.tuple;

import org.junit.Test;

import static org.junit.Assert.*;

public class TupleTest {

    @Test
    public void setXYZW() {
        Tuple a = new Tuple(0, 1, 2, 3);
        assertEquals(0.0, a.x(), Tuple.EPSILON);
        assertEquals(1.0, a.y(), Tuple.EPSILON);
        assertEquals(2.0, a.z(), Tuple.EPSILON);
        assertEquals(3.0, a.w(), Tuple.EPSILON);
        a.setX(4);
        assertEquals(4.0, a.x(), Tuple.EPSILON);
        a.setY(5);
        assertEquals(5.0, a.y(), Tuple.EPSILON);
        a.setZ(6);
        assertEquals(6.0, a.z(), Tuple.EPSILON);
        a.setW(7);
        assertEquals(7.0, a.w(), Tuple.EPSILON);
    }

    @Test
    public void add() {
        Tuple a = new Tuple(0, 1, 2, 3);
        Tuple b = new Tuple(1, 1, 1, 1);
        a.add(b);
        assertEquals(1.0, a.x(), Tuple.EPSILON);
        assertEquals(2.0, a.y(), Tuple.EPSILON);
        assertEquals(3.0, a.z(), Tuple.EPSILON);
        assertEquals(4.0, a.w(), Tuple.EPSILON);
    }

    @Test
    public void sub() {
        Tuple a = new Tuple(0, 1, 2, 3);
        Tuple b = new Tuple(1, 1, 1, 1);
        a.subtract(b);
        assertEquals(-1.0, a.x(), Tuple.EPSILON);
        assertEquals(0.0, a.y(), Tuple.EPSILON);
        assertEquals(1.0, a.z(), Tuple.EPSILON);
        assertEquals(2.0, a.w(), Tuple.EPSILON);
    }

    @Test
    public void negate() {
        Tuple a = new Tuple(4, 1, 2, 3);
        a = a.negate();
        assertEquals(-4.0, a.x(), Tuple.EPSILON);
        assertEquals(-1.0, a.y(), Tuple.EPSILON);
        assertEquals(-2.0, a.z(), Tuple.EPSILON);
        assertEquals(-3.0, a.w(), Tuple.EPSILON);
    }

    @Test
    public void mul() {
        Tuple a = new Tuple(4, 1, 2, 3);
        a.mul(2.0);
        assertEquals(8.0, a.x(), Tuple.EPSILON);
        assertEquals(2.0, a.y(), Tuple.EPSILON);
        assertEquals(4.0, a.z(), Tuple.EPSILON);
        assertEquals(6.0, a.w(), Tuple.EPSILON);
    }

    @Test
    public void div() {
        Tuple a = new Tuple(4, 1, 2, 8);
        a.div(2);
        assertEquals(2.0, a.x(), Tuple.EPSILON);
        assertEquals(0.5, a.y(), Tuple.EPSILON);
        assertEquals(1.0, a.z(), Tuple.EPSILON);
        assertEquals(4.0, a.w(), Tuple.EPSILON);
    }

}