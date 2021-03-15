package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.material.pattern.AbstractPattern;
import com.davelpz.logan.material.pattern.Pattern;
import com.davelpz.logan.tuple.Tuple;

public class TestPattern extends AbstractPattern {

    @Override
    public Color pattern_at(Tuple point) {
        return new Color(point.x(),point.y(),point.z());
    }
}
