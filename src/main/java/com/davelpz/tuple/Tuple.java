package com.davelpz.tuple;

public class Tuple {
    private static double EPSILON = 0.00001;

    private double[] values = new double[4];

    public Tuple(double x, double y, double z, double w) {
        values[0] = x;
        values[1] = y;
        values[2] = z;
        values[3] = w;
    }

    public static Tuple point(double x, double y, double z) {
        return new Tuple(x, y, z, 1.0);
    }

    public static Tuple vector(double x, double y, double z) {
        return new Tuple(x, y, z, 0.0);
    }

    public double x() {
        return values[0];
    }

    public double y() {
        return values[1];
    }

    public double z() {
        return values[2];
    }

    public double w() {
        return values[3];
    }

    public Tuple setX(double x) {
        values[0] = x;
        return this;
    }

    public Tuple setY(double y) {
        values[1] = y;
        return this;
    }

    public Tuple setZ(double z) {
        values[2] = z;
        return this;
    }

    public Tuple setW(double w) {
        values[3] = w;
        return this;
    }

    public boolean isPoint() {
        return w() == 1.0;
    }

    public boolean isVector() {
        return w() == 0.0;
    }

    public static Tuple add(Tuple a, Tuple b) {
        return new Tuple(a.x() + b.x(), a.y() + b.y(), a.z() + b.z(), a.w() + b.w());
    }

    public Tuple add(Tuple b) {
        values[0] += b.x();
        values[1] += b.y();
        values[2] += b.z();
        values[3] += b.w();
        return this;
    }

    public static Tuple subtract(Tuple a, Tuple b) {
        return new Tuple(a.x() - b.x(), a.y() - b.y(), a.z() - b.z(), a.w() - b.w());
    }

    public Tuple subtract(Tuple b) {
        values[0] -= b.x();
        values[1] -= b.y();
        values[2] -= b.z();
        values[3] -= b.w();
        return this;
    }

    public boolean equals(Tuple b) {
        return equals(b, EPSILON);
    }

    public boolean equals(Tuple b, double delta) {
        return (Math.abs(x() - b.x()) < delta) && (Math.abs(y() - b.y()) < delta) && (Math.abs(z() - b.z()) < delta) && (Math.abs(w() - b.w())
                < delta);
    }
}
