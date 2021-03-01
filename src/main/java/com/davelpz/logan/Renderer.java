package com.davelpz.logan;

import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;

import java.io.IOException;

public class Renderer {

    public void render() throws IOException {
        Tuple ray_origin = Tuple.point(0, 0, -5);
        double wall_z = 10;
        double wall_size = 7.0;
        double canvas_pixels = 100;
        double pixel_size = wall_size / canvas_pixels;
        double half = wall_size / 2;
        Canvas canvas = new Canvas(canvas_pixels, canvas_pixels);
        Color color = new Color(1, 0, 0);
        Sphere shape = new Sphere();

        for (int y = 0; y < canvas_pixels; y++) {
            double world_y = half - pixel_size * y;

            for (int x = 0; x < canvas_pixels; x++) {
                double world_x = -half + pixel_size * x;
                Tuple position = Tuple.point(world_x, world_y, wall_z);
                Ray r = new Ray(ray_origin, Tuple.subtract(position, ray_origin).normalize());
                Intersection[] xs = r.intersects(shape);
                if (Intersection.hit(xs).isPresent()) {
                    canvas.writePixel(color, x, y);
                }
            }
        }

        canvas.canvasToPPMFile("output.ppm");
    }
}
