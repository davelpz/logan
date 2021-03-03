package com.davelpz.logan.camera;

import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.tuple.Tuple;

public class Camera {
    private int hsize;
    private int vsize;
    private double field_of_view;
    private Matrix transform;
    private double pixel_size,half_width,half_height;

    public Camera(int hsize, int vsize, double field_of_view) {
        this.hsize = hsize;
        this.vsize = vsize;
        this.field_of_view = field_of_view;
        this.transform = Matrix.identity4;
        double half_view = Math.tan(field_of_view/2.0);
        double aspect = (double)hsize/(double)vsize;

        if (aspect >= 1) {
            this.half_width = half_view;
            this.half_height = half_view/aspect;
        } else {
            this.half_height = half_view;
            this.half_width = half_view * aspect;
        }

        this.pixel_size = (this.half_width*2) / (hsize);
    }

    public Ray rayForPixel(int x, int y) {
        // the offset from the edge of the canvas to the pixel's center
        double xoffset = (x + 0.5) * pixel_size;
        double yoffset = (y + 0.5) * pixel_size;

        // the untransformed coordinates of the pixel in world space.
        // (remember that the camera looks toward -z, so +x is to the left)
        double world_x = half_width - xoffset;
        double world_y = half_height - yoffset;

        // using the camera matrix, transform the canvas point and the origin
        // and then compute the ray's direction vector
        // (remember that canvas is at z=-1
        Tuple pixel = transform.inverse().multiply(Tuple.point(world_x, world_y, -1));
        Tuple origin = transform.inverse().multiply(Tuple.point(0,0,0));
        Tuple direction = pixel.subtract(origin).normalize();
        return new Ray(origin,direction);
    }

    public int getHsize() {
        return hsize;
    }

    public void setHsize(int hsize) {
        this.hsize = hsize;
    }

    public int getVsize() {
        return vsize;
    }

    public void setVsize(int vsize) {
        this.vsize = vsize;
    }

    public double getField_of_view() {
        return field_of_view;
    }

    public void setField_of_view(double field_of_view) {
        this.field_of_view = field_of_view;
    }

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    public double getPixel_size() {
        return pixel_size;
    }

    public void setPixel_size(double pixel_size) {
        this.pixel_size = pixel_size;
    }

    public double getHalf_width() {
        return half_width;
    }

    public void setHalf_width(double half_width) {
        this.half_width = half_width;
    }

    public double getHalf_height() {
        return half_height;
    }

    public void setHalf_height(double half_height) {
        this.half_height = half_height;
    }
}
