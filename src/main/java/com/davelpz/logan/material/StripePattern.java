package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.tuple.Tuple;

public class StripePattern extends Pattern {
    public Color a;
    public Color b;

    public StripePattern(Color a, Color b) {
        this.a = a;
        this.b = b;
    }

    public Color stripe_at(Tuple point) {
        double x = point.x();
        if ( ( ((int)Math.floor(x)) % 2) == 0) {
            return a;
        } else {
            return b;
        }
    }

    public Color stripe_at_object(Shape object, Tuple world_point) {
        Tuple object_point = object.transform.inverse().multiply(world_point);
        Tuple pattern_point = this.getTransform().inverse().multiply(object_point);
        return stripe_at(pattern_point);
    }
}
