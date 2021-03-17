package com.davelpz.logan.material.pattern;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.noise.Perlin;
import com.davelpz.logan.tuple.Tuple;

public class Perturb extends AbstractPattern {
    Perlin noise = new Perlin();
    Pattern a;
    double scale;

    public Perturb(Pattern a, double scale) {
        this.a = a;
        this.scale = scale;
    }

    @Override
    public Color pattern_at(Tuple point) {
        double jitter = turb(point) * scale;
        Color colorA = a.pattern_at_object_point(point.add(jitter));
        return colorA;
    }

    public double turb(final Tuple p) {
        return turb(p, 7);
    }

    double turb(final Tuple p, int depth) {
        double accum = 0;
        Tuple temp_p = p;
        double weight = 1.0f;
        for (int i = 0; i < depth; i++) {
            accum += weight * noise.noise(temp_p);
            weight *= 0.5;
            temp_p = temp_p.mul(2);
        }

        return Math.abs(accum);
    }

}
