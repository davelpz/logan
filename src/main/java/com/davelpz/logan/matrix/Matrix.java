package com.davelpz.logan.matrix;

import com.davelpz.logan.tuple.Tuple;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Matrix {
    private int dimension;
    private double[][] data;

    public static Matrix identity2 = new Matrix(2,new double[][]{
            new double[]{1,0},
            new double[]{0,1},
    });

    public static Matrix identity3 = new Matrix(3,new double[][]{
            new double[]{1,0,0},
            new double[]{0,1,0},
            new double[]{0,0,1},
    });

    public static Matrix identity4 = new Matrix(4,new double[][]{
            new double[]{1,0,0,0},
            new double[]{0,1,0,0},
            new double[]{0,0,1,0},
            new double[]{0,0,0,1},
    });

    public Matrix(int dimension) {
        this.dimension = dimension;
        this.data = new double[dimension][dimension];
    }

    public Matrix(int dimension, double[][] data) {
        this.dimension = dimension;
        this.data = data;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
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

    public static Tuple multiply(Matrix a, Tuple b) {
        Tuple t = new Tuple(0,0,0,0);
        double[][] dataA = a.data;

        t.setX(dataA[0][0] * b.x() + dataA[0][1] * b.y() + dataA[0][2] * b.z() + dataA[0][3] * b.w());
        t.setY(dataA[1][0] * b.x() + dataA[1][1] * b.y() + dataA[1][2] * b.z() + dataA[1][3] * b.w());
        t.setZ(dataA[2][0] * b.x() + dataA[2][1] * b.y() + dataA[2][2] * b.z() + dataA[2][3] * b.w());
        t.setW(dataA[3][0] * b.x() + dataA[3][1] * b.y() + dataA[3][2] * b.z() + dataA[3][3] * b.w());

        return t;
    }

    public boolean setData(List<List<Double>> listdata) {
        if (listdata.size() != dimension) {
            return false;
        }

        for (int row = 0; row < listdata.size(); row++) {
            List<Double> columns = listdata.get(row);
            if (columns.size() != dimension) {
                return false;
            }
            for (int col = 0; col < columns.size(); col++) {
                this.data[row][col] = columns.get(col);
            }
        }

        return true;
    }

    public boolean equals(Matrix b) {
        if (this.dimension != b.dimension) {
            return false;
        }

        double[][] aData = this.data;
        double[][] bData = b.data;

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if (Math.abs(aData[row][col] - bData[row][col]) > Tuple.EPSILON ){
                    return false;
                }
            }
        }

        //return Arrays.deepEquals(this.data, b.data);
        return true;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Matrix matrix = (Matrix) o;
        return dimension == matrix.dimension && Arrays.deepEquals(data, matrix.data);
    }

    @Override public int hashCode() {
        int result = Objects.hash(dimension);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    public double get(int row, int col) {
        return this.data[row][col];
    }
}
