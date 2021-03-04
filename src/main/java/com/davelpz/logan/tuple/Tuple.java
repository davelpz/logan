package com.davelpz.logan.tuple;

import java.util.Arrays;

public class Tuple {
    public static final double EPSILON = 0.00001;

    private final double[] values = new double[4];

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

    private static Tuple add(Tuple a, Tuple b) {
        return new Tuple(a.x() + b.x(), a.y() + b.y(), a.z() + b.z(), a.w() + b.w());
    }

    private static Tuple subtract(Tuple a, Tuple b) {
        return new Tuple(a.x() - b.x(), a.y() - b.y(), a.z() - b.z(), a.w() - b.w());
    }

    private static Tuple negate(Tuple a) {
        return new Tuple(-a.x(), -a.y(), -a.z(), -a.w());
    }

    private static Tuple mul(Tuple a, double b) {
        return new Tuple(a.x() * b, a.y() * b,
                a.z() * b, a.w() * b);
    }

    public static Tuple mul(double b, Tuple a) {
        return new Tuple(a.x() * b, a.y() * b,
                a.z() * b, a.w() * b);
    }

    private static Tuple div(Tuple a, double b) {
        return new Tuple(a.x() / b, a.y() / b,
                a.z() / b, a.w() / b);
    }

    private static double dot(Tuple a, Tuple b) {
        return a.x() * b.x()
                + a.y() * b.y()
                + a.z() * b.z()
                + a.w() * b.w();
    }

    private static Tuple cross(Tuple a, Tuple b) {
        return Tuple.vector(a.y() * b.z() - a.z() * b.y(),
                a.z() * b.x() - a.x() * b.z(),
                a.x() * b.y() - a.y() * b.x());
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

    public Tuple add(Tuple b) {
        return add(this, b);
    }

    public Tuple subtract(Tuple b) {
        return subtract(this, b);
    }

    public Tuple negate() {
        return new Tuple(-x(), -y(), -z(), -w());
    }

    public Tuple mul(double b) {
        return mul(this, b);
    }

    public Tuple div(double b) {
        return div(this, b);
    }

    public double dot(Tuple b) {
        return dot(this,b);
    }

    public Tuple cross(Tuple b) {
        return cross(this,b);
    }

    public double magnitude() {
        return Math.sqrt(x() * x() + y() * y() + z() * z() + w() * w());
    }

    public Tuple normalize() {
        return new Tuple(x() / magnitude(),
                y() / magnitude(),
                z() / magnitude(),
                w() / magnitude());
    }

    public Tuple reflect(Tuple normal) {
        return this.subtract(normal.mul(2 * dot(this, normal)));
    }

    public boolean equals(Tuple b) {
        return equals(b, EPSILON);
    }

    public boolean equals(Tuple b, double delta) {
        return (Math.abs(x() - b.x()) < delta) && (Math.abs(y() - b.y()) < delta) && (Math.abs(z() - b.z()) < delta) && (Math.abs(w() - b.w())
                < delta);
    }

    @Override
    public String toString() {
        return "Tuple{" + "values=" + Arrays.toString(values) + '}';
    }
}
