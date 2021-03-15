package com.davelpz.logan.color;

import com.davelpz.logan.material.pattern.Pattern;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.tuple.Tuple;

import java.util.Arrays;

public class Color implements Pattern {
    public static final Color BLACK = new Color(0,0,0);
    public static final Color WHITE = new Color(1,1,1);
    public static final double EPSILON = Tuple.EPSILON;

    private final double[] values = new double[3];

    public Color(double x, double y, double z) {
        values[0] = x;
        values[1] = y;
        values[2] = z;
    }

    public Color(Color c) {
        values[0] = c.red();
        values[1] = c.green();
        values[2] = c.blue();
    }

    private static Color add(Color a, Color b) {
        return new Color(a.red() + b.red(), a.green() + b.green(), a.blue() + b.blue());
    }

    private static Color subtract(Color a, Color b) {
        return new Color(a.red() - b.red(), a.green() - b.green(), a.blue() - b.blue());
    }

    private static Color mul(Color a, Color b) {
        return new Color(a.red() * b.red(), a.green() * b.green(), a.blue() * b.blue());
    }

    private static Color mul(Color a, double b) {
        return new Color(a.red() * b, a.green() * b, a.blue() * b);
    }

    private static Color mul(double b, Color a) {
        return new Color(a.red() * b, a.green() * b, a.blue() * b);
    }

    public static double clamp(double value, double min, double max) {
        if (value < min)
            value = min;
        else if (value > max)
            value = max;
        return value;
    }

    public double red() {
        return values[0];
    }

    public double green() {
        return values[1];
    }

    public double blue() {
        return values[2];
    }

    public Color setRed(double x) {
        values[0] = x;
        return this;
    }

    public Color setGreen(double y) {
        values[1] = y;
        return this;
    }

    public Color setBlue(double z) {
        values[2] = z;
        return this;
    }

    public void set(double r, double g, double b) {
        values[0] = r;
        values[1] = g;
        values[2] = b;
    }

    public Color add(Color b) {
        return add(this, b);
    }

    public Color subtract(Color b) {
        return subtract(this, b);
    }

    public Color mul(double b) {
        return mul(this, b);
    }

    public Color mul(Color b) {
        return mul(this, b);
    }

    public void clamp(double min, double max) {
        if (values[0] < min)
            values[0] = min;
        else if (values[0] > max)
            values[0] = max;

        if (values[1] < min)
            values[1] = min;
        else if (values[1] > max)
            values[1] = max;

        if (values[2] < min)
            values[2] = min;
        else if (values[2] > max)
            values[2] = max;
    }

    public boolean equals(Color b) {
        return equals(b, EPSILON);
    }

    public boolean equals(Color b, double delta) {
        return (Math.abs(red() - b.red()) < delta) && (Math.abs(green() - b.green()) < delta) && (Math.abs(blue() - b.blue()) < delta);
    }

    @Override public String toString() {
        return "Color{" + "values=" + Arrays.toString(values) + '}';
    }

    @Override
    public Matrix getTransform() {
        return Matrix.identity4;
    }

    @Override
    public Color pattern_at(Tuple point) {
        return this;
    }
}
