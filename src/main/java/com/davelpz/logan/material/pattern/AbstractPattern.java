package com.davelpz.logan.material.pattern;

import com.davelpz.logan.matrix.Matrix;

import java.util.Objects;

public abstract class AbstractPattern implements Pattern {
    private Matrix transform = Matrix.identity4;

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPattern that = (AbstractPattern) o;
        return transform.equals(that.transform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transform);
    }
}
