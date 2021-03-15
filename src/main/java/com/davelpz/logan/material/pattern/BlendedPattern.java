package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.tuple.Tuple;

public class BlendedPattern extends AbstractPattern {
    public Pattern a;
    public Pattern b;

    public BlendedPattern(Pattern a, Pattern b) {
        this.a = a;
        this.b = b;
    }

    /*
    @Override public Color pattern_at_shape(Shape object, Tuple world_point) {
        Color colorA = a.pattern_at_shape(object,world_point);
        Color colorB = b.pattern_at_shape(object,world_point);
        Color blendedColor = colorA.add(colorB).div(2.0);
        return blendedColor;
    }*/

    @Override public Color pattern_at(Tuple point) {
        Color colorA = a.pattern_at_object_point(point);
        Color colorB = b.pattern_at_object_point(point);
        return colorA.add(colorB).div(2.0);
    }
}
