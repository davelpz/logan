package com.davelpz.logan.matrix;

import com.davelpz.logan.tuple.Tuple;

import java.util.List;

public class Matrix {
    public static Matrix identity2 = new Matrix(2, new double[][] { new double[] { 1, 0 }, new double[] { 0, 1 }, });
    public static Matrix identity3 = new Matrix(3, new double[][] { new double[] { 1, 0, 0 }, new double[] { 0, 1, 0 }, new double[] { 0, 0, 1 }, });
    public static Matrix identity4 = new Matrix(4,
            new double[][] { new double[] { 1, 0, 0, 0 }, new double[] { 0, 1, 0, 0 }, new double[] { 0, 0, 1, 0 }, new double[] { 0, 0, 0, 1 }, });
    private final int dimension;
    private final double[][] data;

    public Matrix(int dimension) {
        this.dimension = dimension;
        this.data = new double[dimension][dimension];
    }

    public Matrix(int dimension, double[][] data) {
        this.dimension = dimension;
        this.data = data;
    }

    private static Matrix multiply(Matrix a, Matrix b) {
        Matrix m = new Matrix(b.dimension);
        double[][] dataA = a.data;
        double[][] dataB = b.data;

        for (int row = 0; row < dataA.length; row++) {
            for (int col = 0; col < dataB.length; col++) {
                m.data[row][col] =
                        dataA[row][0] * dataB[0][col] + dataA[row][1] * dataB[1][col] + dataA[row][2] * dataB[2][col] + dataA[row][3] * dataB[3][col];
            }
        }

        return m;
    }

    private static Tuple multiply(Matrix a, Tuple b) {
        Tuple t = new Tuple(0, 0, 0, 0);
        double[][] dataA = a.data;

        t.setX(dataA[0][0] * b.x() + dataA[0][1] * b.y() + dataA[0][2] * b.z() + dataA[0][3] * b.w());
        t.setY(dataA[1][0] * b.x() + dataA[1][1] * b.y() + dataA[1][2] * b.z() + dataA[1][3] * b.w());
        t.setZ(dataA[2][0] * b.x() + dataA[2][1] * b.y() + dataA[2][2] * b.z() + dataA[2][3] * b.w());
        t.setW(dataA[3][0] * b.x() + dataA[3][1] * b.y() + dataA[3][2] * b.z() + dataA[3][3] * b.w());

        return t;
    }

    private static Matrix transpose(Matrix a) {
        Matrix m = new Matrix(a.dimension);

        for (int row = 0; row < a.dimension; row++) {
            for (int col = 0; col < a.dimension; col++) {
                m.data[row][col] = a.data[col][row];
            }
        }

        return m;
    }

    public static Matrix translation(double x, double y, double z) {
        Matrix m = new Matrix(4);
        m.set(0, 3, x);
        m.set(1, 3, y);
        m.set(2, 3, z);

        m.set(0, 0, 1.0);
        m.set(1, 1, 1.0);
        m.set(2, 2, 1.0);
        m.set(3, 3, 1.0);
        return m;
    }

    public static Matrix scaling(double x, double y, double z) {
        Matrix m = new Matrix(4);
        m.set(0, 0, x);
        m.set(1, 1, y);
        m.set(2, 2, z);
        m.set(3, 3, 1.0);
        return m;
    }

    public static Matrix rotationX(double r) {
        Matrix m = new Matrix(4);
        m.set(0, 0, 1.0);
        m.set(1, 1, Math.cos(r));
        m.set(2, 2, Math.cos(r));
        m.set(3, 3, 1.0);
        m.set(2, 1, Math.sin(r));
        m.set(1, 2, -Math.sin(r));
        return m;
    }

    public static Matrix rotationY(double r) {
        Matrix m = new Matrix(4);
        m.set(0, 0, Math.cos(r));
        m.set(1, 1, 1);
        m.set(2, 2, Math.cos(r));
        m.set(3, 3, 1.0);
        m.set(2, 0, -Math.sin(r));
        m.set(0, 2, Math.sin(r));
        return m;
    }

    public static Matrix rotationZ(double r) {
        Matrix m = new Matrix(4);
        m.set(0, 0, Math.cos(r));
        m.set(1, 1, Math.cos(r));
        m.set(2, 2, 1.0);
        m.set(3, 3, 1.0);
        m.set(1, 0, Math.sin(r));
        m.set(0, 1, -Math.sin(r));
        return m;
    }

    public static Matrix shearing(double xy, double xz, double yx, double yz, double zx, double zy) {
        Matrix m = new Matrix(4);
        m.set(0, 0, 1.0);
        m.set(1, 1, 1.0);
        m.set(2, 2, 1.0);
        m.set(3, 3, 1.0);
        m.set(0, 1, xy);
        m.set(0, 2, xz);
        m.set(1, 0, yx);
        m.set(1, 2, yz);
        m.set(2, 0, zx);
        m.set(2, 1, zy);
        return m;
    }

    public Matrix transpose() {
        return Matrix.transpose(this);
    }

    public Matrix multiply(Matrix b) {
        return multiply(this, b);
    }

    public Tuple multiply(Tuple b) {
        return multiply(this, b);
    }

    public double determinant() {
        if (dimension == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        } else {
            double det = 0;
            for (int column = 0; column < dimension; column++) {
                det += data[0][column] * cofactor(0, column);
            }
            return det;
        }
    }

    public Matrix submatrix(int row, int col) {
        Matrix m = new Matrix(this.dimension - 1);

        for (int r = 0, tr = 0; r < m.dimension; r++, tr++) {
            if (tr == row)
                tr++;
            for (int c = 0, tc = 0; c < m.dimension; c++, tc++) {
                if (tc == col)
                    tc++;
                m.data[r][c] = this.data[tr][tc];
            }
        }

        return m;
    }

    public double minor(int row, int col) {
        Matrix sub = submatrix(row, col);
        return sub.determinant();
    }

    public double cofactor(int row, int col) {
        double minor = minor(row, col);
        if (((row + col) % 2) == 0) {
            return minor;
        } else {
            return -minor;
        }
    }

    public boolean isInvertible() {
        return determinant() != 0;
    }

    public Matrix inverse() {
        if (!isInvertible()) {
            throw new InverseException("Matrix not invertible");
        }

        Matrix m2 = new Matrix(dimension);
        double det = determinant();

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                double c = cofactor(row, col);
                m2.data[col][row] = c / det;
            }
        }

        return m2;
    }

    public void setData(List<List<Double>> listdata) {
        if (listdata.size() != dimension) {
            throw new RuntimeException("dimension mismatch");
        }

        for (int row = 0; row < listdata.size(); row++) {
            List<Double> columns = listdata.get(row);
            if (columns.size() != dimension) {
                throw new RuntimeException("dimension mismatch");
            }
            for (int col = 0; col < columns.size(); col++) {
                this.data[row][col] = columns.get(col);
            }
        }
    }

    public boolean equals(Matrix b) {
        if (this.dimension != b.dimension) {
            return false;
        }

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if (Math.abs(this.data[row][col] - b.data[row][col]) > Tuple.EPSILON) {
                    return false;
                }
            }
        }

        //return Arrays.deepEquals(this.data, b.data);
        return true;
    }

    public double get(int row, int col) {
        return this.data[row][col];
    }

    public void set(int row, int col, double value) {
        this.data[row][col] = value;
    }

    public static class MatrixBatcher {
        private Matrix m = Matrix.identity4;

        public MatrixBatcher() {
        }

        public MatrixBatcher transpose() {
            m =  m.transpose();
            return this;
        }

        public MatrixBatcher translation(double x, double y, double z) {
            m = m.multiply(Matrix.translation(x,y,z));
            return this;
        }

        public MatrixBatcher scaling(double x, double y, double z) {
            m = m.multiply(Matrix.scaling(x,y,z));
            return this;
        }

        public MatrixBatcher rotationX(double r) {
            m = m.multiply(Matrix.rotationX(r));
            return this;
        }

        public MatrixBatcher rotationY(double r) {
            m = m.multiply(Matrix.rotationY(r));
            return this;
        }

        public MatrixBatcher rotationZ(double r) {
            m = m.multiply(Matrix.rotationZ(r));
            return this;
        }

        public MatrixBatcher shearing(double xy, double xz, double yx, double yz, double zx, double zy) {
            m = m.multiply(Matrix.shearing(xy,xz,yx,yz,zx,zy));
            return this;
        }

        public Matrix end() {
            return m;
        }
    }

    public static MatrixBatcher start() {
        return new Matrix.MatrixBatcher();
    }
}
