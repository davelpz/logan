package com.davelpz.logan.material.pattern;

import com.davelpz.logan.matrix.Matrix;

public abstract class AbstractPattern implements Pattern {
    private Matrix transform = Matrix.identity4;

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

}
