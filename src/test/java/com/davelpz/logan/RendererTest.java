package com.davelpz.logan;

import com.davelpz.logan.camera.Camera;
import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.material.GradientPattern;
import com.davelpz.logan.material.Material;
import com.davelpz.logan.material.RingPattern;
import com.davelpz.logan.material.StripePattern;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.shapes.Plane;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import com.davelpz.logan.world.World;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RendererTest {

    @Test
    public void testRender() {
        World w = World.defaultWorld();
        Camera c = new Camera(11,11,Math.PI/2.0);
        Tuple from = Tuple.point(0,0,-5);
        Tuple to = Tuple.point(0,0,0);
        Tuple up = Tuple.vector(0,1,0);
        c.setTransform(World.view_transform(from,to,up));
        Canvas image = Renderer.render(c,w);
        assertTrue(image.pixelAt(5,5).equals(new Color(0.38066,0.47583,0.2855)));
    }

    @Test
    public void testRender2() throws IOException {
        Sphere floor = new Sphere();
        floor.setTransform(Matrix.scaling(10,0.01,10));
        floor.setMaterial(new Material());
        floor.getMaterial().getColor().set(1,0.9,0.9);
        floor.getMaterial().setSpecular(0);

        Sphere left_wall = new Sphere();
        left_wall.setTransform(Matrix.translation(0,0,5)
                .multiply(Matrix.rotationY(-Math.PI/4.0))
                .multiply(Matrix.rotationX(Math.PI/2.0))
                .multiply(Matrix.scaling(10,0.01,10)));
        left_wall.setMaterial(floor.getMaterial());

        Sphere right_wall = new Sphere();
        right_wall.setTransform(Matrix.translation(0,0,5)
                .multiply(Matrix.rotationY(Math.PI/4.0))
                .multiply(Matrix.rotationX(Math.PI/2.0))
                .multiply(Matrix.scaling(10,0.01,10)));
        right_wall.setMaterial(floor.getMaterial());

        double specular = 0.3;
        double diffuse = 0.7;

        Sphere middle = new Sphere();
        middle.setTransform(Matrix.translation(-0.5,1,0.5));
        middle.setMaterial(new Material());
        middle.getMaterial().setColor(new Color(0.1,1,0.5));
        middle.getMaterial().setDiffuse(diffuse);
        middle.getMaterial().setSpecular(specular);

        Sphere right = new Sphere();
        right.setTransform(Matrix.translation(1.5,0.5,-0.5)
                .multiply(Matrix.scaling(0.5,0.5,0.5)));
        right.setMaterial(new Material());
        right.getMaterial().setColor(new Color(0.5,1,0.1));
        right.getMaterial().setDiffuse(diffuse);
        right.getMaterial().setSpecular(specular);

        Sphere left = new Sphere();
        left.setTransform(Matrix.translation(-1.5,0.33,-0.75)
                .multiply(Matrix.scaling(0.33,0.33,0.33)));
        left.setMaterial(new Material());
        left.getMaterial().setColor(new Color(1,0.8,0.1));
        left.getMaterial().setDiffuse(diffuse);
        left.getMaterial().setSpecular(specular);

        World world = new World();
        world.getLights().add(new PointLight(Color.WHITE, Tuple.point(-10,10,-10)));

        world.getObjects().add(floor);
        world.getObjects().add(left_wall);
        world.getObjects().add(right_wall);
        world.getObjects().add(middle);
        world.getObjects().add(right);
        world.getObjects().add(left);

        Camera c = new Camera(100,50,Math.PI/3.0);
        c.setTransform(World.view_transform(Tuple.point(0,1.5,-5),
                Tuple.point(0,1,0),
                Tuple.vector(0,1,0)));

        Canvas canvas = Renderer.render(c,world);
        canvas.canvasToPPMFile("output.ppm");
    }

    // chapter 9
    @Test
    public void testRender3() throws IOException {
        Plane floor = new Plane();
        //floor.setTransform(Matrix.scaling(10,0.01,10));
        //floor.setTransform(Matrix.translation(0,0.0,0));
        //floor.setTransform(Matrix.rotationX(-Math.PI/16.0));
        floor.setMaterial(new Material());
        floor.getMaterial().getColor().set(1,0.9,0.9);
        floor.getMaterial().setSpecular(0);
        //GradientPattern pattern1 = new GradientPattern(Color.WHITE,Color.BLACK);
        //pattern1.setTransform(Matrix.translation(4,0,0).multiply(Matrix.scaling(8,8,8)));
        //floor.getMaterial().setPattern(pattern1);
        RingPattern pattern3 = new RingPattern(Color.WHITE,Color.BLACK);
        floor.getMaterial().setPattern(pattern3);

        Plane wall = new Plane();
        wall.setTransform(Matrix.translation(0,0,3).multiply(Matrix.rotationX(-Math.PI/2)));
        wall.setMaterial(new Material());
        wall.getMaterial().getColor().set(1,0.9,0.9);
        wall.getMaterial().setSpecular(0);
        StripePattern pattern = new StripePattern(new Color(.5,.5,.5),Color.WHITE);
        pattern.setTransform(Matrix.scaling(.1,.1,.1).multiply(Matrix.rotationY(Math.PI/2.0)));
        wall.getMaterial().setPattern(pattern);

        double specular = 0.3;
        double diffuse = 0.7;

        Sphere middle = new Sphere();
        middle.setTransform(Matrix.translation(-0.5,1,0.5));
        middle.setMaterial(new Material());
        middle.getMaterial().setColor(new Color(0.1,1,0.5));
        middle.getMaterial().setDiffuse(diffuse);
        middle.getMaterial().setSpecular(specular);
        StripePattern pattern2 = new StripePattern(new Color(.5,.5,.5),new Color(0.1,1,0.5));
        pattern2.setTransform(Matrix.scaling(.03,.03,.03).multiply(Matrix.rotationX(Math.PI/2.0)));
        middle.getMaterial().setPattern(pattern2);

        Sphere right = new Sphere();
        right.setTransform(Matrix.translation(1.5,0.5,-0.5)
                .multiply(Matrix.scaling(0.5,0.5,0.5)));
        right.setMaterial(new Material());
        right.getMaterial().setColor(new Color(0.5,1,0.1));
        right.getMaterial().setDiffuse(diffuse);
        right.getMaterial().setSpecular(specular);

        Sphere left = new Sphere();
        left.setTransform(Matrix.translation(-1.5,0.33,-0.75)
                .multiply(Matrix.scaling(0.33,0.33,0.33)));
        left.setMaterial(new Material());
        left.getMaterial().setColor(new Color(1,0.8,0.1));
        left.getMaterial().setDiffuse(diffuse);
        left.getMaterial().setSpecular(specular);

        World world = new World();
        world.getLights().add(new PointLight(Color.WHITE, Tuple.point(-10,10,-10)));

        world.getObjects().add(floor);
        world.getObjects().add(wall);
        world.getObjects().add(middle);
        world.getObjects().add(right);
        world.getObjects().add(left);

        Camera c = new Camera(300,150,Math.PI/3.0);
        c.setTransform(World.view_transform(Tuple.point(0,1.5,-5),
                Tuple.point(0,1,0),
                Tuple.vector(0,1,0)));

        Canvas canvas = Renderer.render(c,world);
        canvas.canvasToPPMFile("output.ppm");
    }
}