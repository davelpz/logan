package com.davelpz.tuple;

public class Color {
    public static final double EPSILON = 0.00001;

    private final double[] values = new double[3];

    public Color(double x, double y, double z) {
        values[0] = x;
        values[1] = y;
        values[2] = z;
    }

    public static Color add(Color a, Color b) {
        return new Color(a.red() + b.red(), a.green() + b.green(), a.blue() + b.blue());
    }

    public static Color subtract(Color a, Color b) {
        return new Color(a.red() - b.red(), a.green() - b.green(), a.blue() - b.blue());
    }

    public static Color mul(Color a, Color b) {
        return new Color(a.red() * b.red(), a.green() * b.green(),
                a.blue() * b.blue());
    }

    public static Color mul(Color a, double b) {
        return new Color(a.red() * b, a.green() * b,
                a.blue() * b);
    }

    public static Color mul(double b, Color a) {
        return new Color(a.red() * b, a.green() * b,
                a.blue() * b);
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

    public Color add(Color b) {
        values[0] += b.red();
        values[1] += b.green();
        values[2] += b.blue();
        return this;
    }

    public Color subtract(Color b) {
        values[0] -= b.red();
        values[1] -= b.green();
        values[2] -= b.blue();
        return this;
    }

    public Color mul(double b) {
        setRed(red() * b);
        setGreen(green() * b);
        setBlue(blue() * b);
        return this;
    }

    public Color mul(Color b) {
        setRed(red() * b.red());
        setGreen(green() * b.green());
        setBlue(blue() * b.blue());
        return this;
    }

    public boolean equals(Color b) {
        return equals(b, EPSILON);
    }

    public boolean equals(Color b, double delta) {
        return (Math.abs(red() - b.red()) < delta) && (Math.abs(green() - b.green()) < delta) && (Math.abs(blue() - b.blue()) < delta);
    }
}
