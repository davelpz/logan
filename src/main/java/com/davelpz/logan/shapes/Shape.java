package com.davelpz.logan.shapes;

import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.tuple.Tuple;

public abstract class Shape {
    public Matrix transform = Matrix.identity4;
    public Material material = new Material();

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public abstract Intersection[] intersect(Ray ray);

    public Tuple normalAt(Tuple world_point) {
        Tuple object_point = this.transform.inverse().multiply(world_point);
        Tuple object_normal = localNormalAt(object_point);
        Tuple world_normal = transform.inverse().transpose().multiply(object_normal);
        world_normal.setW(0);
        return world_normal.normalize();
    }

    public abstract Tuple localNormalAt(Tuple local_point);
}
