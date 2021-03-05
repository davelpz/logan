package com.davelpz.logan;

import com.davelpz.logan.camera.Camera;
import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.material.Material;
import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import com.davelpz.logan.util.PixelStream;
import com.davelpz.logan.util.Ticker;
import com.davelpz.logan.world.World;

import java.io.IOException;
import java.util.Optional;

public class Renderer {

    public static Canvas render(Camera camera, World world) {
        Canvas image = new Canvas(camera.getHsize(), camera.getVsize());
        Ticker ticker = new Ticker(camera.getHsize()*camera.getVsize(), 1);

        PixelStream.genStream(camera.getHsize(),camera.getVsize()).sequential().forEach(p -> {
            Ray ray = camera.rayForPixel(p.x,p.y);
            Color color = world.color_at(ray);
            image.writePixel(color,p.x,p.y);
            ticker.tick();
        });

        ticker.end();
        return image;
    }

    public void renderOld() throws IOException {
        Tuple ray_origin = Tuple.point(0, 0, -5);
        double wall_z = 10;
        double wall_size = 7.0;
        double canvas_pixels = 500;
        double pixel_size = wall_size / canvas_pixels;
        double half = wall_size / 2;
        Canvas canvas = new Canvas(canvas_pixels, canvas_pixels);
        Color color = new Color(1, 0, 0);
        Sphere shape = new Sphere();
        //shape.setTransform(Matrix.multiply(Matrix.shearing(1,0,0,0,0,0),Matrix.scaling(0.5,1,1)));
        shape.material.getColor().set(1,0.2,1);

        Tuple light_position = Tuple.point(-10,10,-10);
        Color light_color = new Color(1,1,1);
        PointLight light = new PointLight(light_color,light_position);

        PixelStream.genStream(canvas_pixels,canvas_pixels).parallel().forEach(p -> {
            double world_y = half - pixel_size * p.y;
            double world_x = -half + pixel_size * p.x;
            Tuple position = Tuple.point(world_x, world_y, wall_z);
            Ray r = new Ray(ray_origin, position.subtract(ray_origin).normalize());
            Intersection[] xs = r.intersect(shape);
            Optional<Intersection> hitOpt = Intersection.hit(xs);
            if (hitOpt.isPresent()) {
                Intersection hit = hitOpt.get();
                Tuple point = r.position(hit.t);
                Tuple normal = hit.object.normalAt(point);
                Tuple eye = r.direction.negate();
                Color adjustedColor = Material.lighting(hit.object.material,light,point,eye,normal);
                canvas.writePixel(adjustedColor, p.x, p.y);
            }

        });

        /*
        for (int y = 0; y < canvas_pixels; y++) {
            double world_y = half - pixel_size * y;

            for (int x = 0; x < canvas_pixels; x++) {
                double world_x = -half + pixel_size * x;
                Tuple position = Tuple.point(world_x, world_y, wall_z);
                Ray r = new Ray(ray_origin, Tuple.subtract(position, ray_origin).normalize());
                Intersection[] xs = r.intersects(shape);
                Optional<Intersection> hitOpt = Intersection.hit(xs);
                if (hitOpt.isPresent()) {
                    Intersection hit = hitOpt.get();
                    Tuple point = r.position(hit.t);
                    Tuple normal = hit.object.normalAt(point);
                    Tuple eye = r.direction.negate();
                    Color adjustedColor = Material.lighting(hit.object.material,light,point,eye,normal);
                    canvas.writePixel(adjustedColor, x, y);
                }
            }
        }*/

        canvas.canvasToPPMFile("output.ppm");
    }
}
