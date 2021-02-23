package com.davelpz.logan.matrix;

import java.util.List;

public class Matrix {
    private int dimension;
    private double[][] data;

    public  Matrix(int dimension) {
        this.dimension = dimension;
        this.data = new double[dimension][dimension];
    }

    public boolean setData(List<List<Double>> listdata) {
        if (listdata.size() != dimension) {
            return false;
        }

        for (int row=0;row<listdata.size();row++) {
            List<Double> columns = listdata.get(row);
            if (columns.size() != dimension) {
                return false;
            }
            for (int col=0;col<columns.size();col++) {
                this.data[row][col] = columns.get(col);
            }
        }

        return true;
    }

    public double get(int row, int col) {
        return this.data[row][col];
    }
}
