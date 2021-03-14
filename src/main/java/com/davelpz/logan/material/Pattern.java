package com.davelpz.logan.material;

import com.davelpz.logan.matrix.Matrix;

public abstract class Pattern {
    private Matrix transform = Matrix.identity4;

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }
}
