package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.tuple.Tuple;

public abstract class Pattern {
    private Matrix transform = Matrix.identity4;

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    public Color pattern_at_shape(Shape object, Tuple world_point) {
        Tuple object_point = object.transform.inverse().multiply(world_point);
        Tuple pattern_point = this.getTransform().inverse().multiply(object_point);
        return pattern_at(pattern_point);
    }

    public abstract Color pattern_at(Tuple point);

}
