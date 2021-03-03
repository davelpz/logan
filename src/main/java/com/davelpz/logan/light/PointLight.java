package com.davelpz.logan.light;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

public class PointLight extends Light {
    private Tuple position;

    public PointLight(Color intensity, Tuple position) {
        super(intensity);
        this.position = position;
    }

    public Tuple getPosition() {
        return position;
    }

    public void setPosition(Tuple position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PointLight that = (PointLight) o;
        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position);
    }
}
