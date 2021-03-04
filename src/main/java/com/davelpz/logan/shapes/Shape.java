package com.davelpz.logan.shapes;

import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;

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
}
