package com.davelpz.logan.light;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;

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
}
