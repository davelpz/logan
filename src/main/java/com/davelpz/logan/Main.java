package com.davelpz.logan;

import com.davelpz.logan.camera.Camera;
import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import com.davelpz.logan.world.World;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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

        Sphere middle = new Sphere();
        middle.setTransform(Matrix.translation(-0.5,1,0.5));
        middle.setMaterial(new Material());
        middle.getMaterial().setColor(new Color(0.1,1,0.5));
        middle.getMaterial().setDiffuse(0.7);
        middle.getMaterial().setSpecular(0.3);

        Sphere right = new Sphere();
        right.setTransform(Matrix.translation(1.5,0.5,-0.5)
                .multiply(Matrix.scaling(0.5,0.5,0.5)));
        right.setMaterial(new Material());
        right.getMaterial().setColor(new Color(0.5,1,0.1));
        right.getMaterial().setDiffuse(0.7);
        right.getMaterial().setSpecular(0.3);

        Sphere left = new Sphere();
        left.setTransform(Matrix.translation(-1.5,0.33,-0.75)
                .multiply(Matrix.scaling(0.33,0.33,0.33)));
        left.setMaterial(new Material());
        left.getMaterial().setColor(new Color(1,0.8,0.1));
        left.getMaterial().setDiffuse(0.7);
        left.getMaterial().setSpecular(0.3);

        World world = new World();
        world.getLights().add(new PointLight(new Color(1,1,1), Tuple.point(-10,10,-10)));

        world.getObjects().add(floor);
        world.getObjects().add(left_wall);
        world.getObjects().add(right_wall);
        world.getObjects().add(middle);
        world.getObjects().add(right);
        world.getObjects().add(left);

        Camera c = new Camera(800,400,Math.PI/3.0);
        c.setTransform(World.view_transform(Tuple.point(0,1.5,-5),
                Tuple.point(0,1,0),
                Tuple.vector(0,1,0)));

        Canvas canvas = Renderer.render(c,world);
        canvas.canvasToPPMFile("output.ppm");
    }
}
