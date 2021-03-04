package com.davelpz.logan.tuple;

import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TupleTest {

    @Test
    public void setXYZW() {
        Tuple a = new Tuple(0, 1, 2, 3);
        assertEquals(0.0, a.x(), Tuple.EPSILON);
        assertEquals(1.0, a.y(), Tuple.EPSILON);
        assertEquals(2.0, a.z(), Tuple.EPSILON);
        assertEquals(3.0, a.w(), Tuple.EPSILON);
        Tuple x = a.setX(4);
        assertEquals(4.0, a.x(), Tuple.EPSILON);
        Tuple y = a.setY(5);
        assertEquals(5.0, a.y(), Tuple.EPSILON);
        Tuple z = a.setZ(6);
        assertEquals(6.0, a.z(), Tuple.EPSILON);
        Tuple w = a.setW(7);
        assertEquals(7.0, a.w(), Tuple.EPSILON);
        assertEquals("Tuple{values=[4.0, 5.0, 6.0, 7.0]}",w.toString());
    }

    @Test
    public void add() {
        Tuple a = new Tuple(0, 1, 2, 3);
        Tuple b = new Tuple(1, 1, 1, 1);
        a = a.add(b);
        assertEquals(1.0, a.x(), Tuple.EPSILON);
        assertEquals(2.0, a.y(), Tuple.EPSILON);
        assertEquals(3.0, a.z(), Tuple.EPSILON);
        assertEquals(4.0, a.w(), Tuple.EPSILON);
    }

    @Test
    public void sub() {
        Tuple a = new Tuple(0, 1, 2, 3);
        Tuple b = new Tuple(1, 1, 1, 1);
        a = a.subtract(b);
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
        a = a.mul(2.0);
        assertEquals(8.0, a.x(), Tuple.EPSILON);
        assertEquals(2.0, a.y(), Tuple.EPSILON);
        assertEquals(4.0, a.z(), Tuple.EPSILON);
        assertEquals(6.0, a.w(), Tuple.EPSILON);
    }

    @Test
    public void div() {
        Tuple a = new Tuple(4, 1, 2, 8);
        a = a.div(2);
        assertEquals(2.0, a.x(), Tuple.EPSILON);
        assertEquals(0.5, a.y(), Tuple.EPSILON);
        assertEquals(1.0, a.z(), Tuple.EPSILON);
        assertEquals(4.0, a.w(), Tuple.EPSILON);
    }


    class Projectile {
        public Tuple position;
        public Tuple velocity;
    }

    class Environment {
        public Tuple gravity;
        public Tuple wind;
    }

    Projectile tick(Environment env, Projectile projectile) {
        Tuple position = projectile.position.add(projectile.velocity);
        Tuple velocity = projectile.velocity.add(env.gravity).add(env.wind);
        Projectile newProjectile = new Projectile();
        newProjectile.position = position;
        newProjectile.velocity = velocity;
        return newProjectile;
    }

    @Test
    public void game() throws IOException {
        Projectile p = new Projectile();
        p.position = Tuple.point(0,1,0);
        p.velocity = Tuple.vector(1,1.8,0).normalize().mul(11.25);

        Environment e = new Environment();
        e.gravity = Tuple.vector(0,-0.1,0);
        e.wind = Tuple.vector(-0.01,0,0);

        Canvas c = new Canvas(900,550);

        for (int i=0;i<195;i++) {
            c.writePixel(new Color(1,1,1), p.position.x(), 550 - p.position.y());
            p = tick(e,p);
        }

        c.canvasToPPMFile("output.ppm");
    }
}