package com.davelpz.logan.canvas;

import com.davelpz.logan.color.Color;

import java.io.*;

public class Canvas {

    private final Color[][] buffer;
    private final int width;
    private final int height;

    public Canvas(int width, int height, Color background) {
        this.width = width;
        this.height = height;
        buffer = new Color[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                buffer[x][y] = background;
            }
        }
    }

    public Canvas(int width, int height) {
        this(width, height, new Color(0, 0, 0));
    }

    public Canvas(double width, double height) {
        this((int)width,(int)height);
    }

    public void writePixel(int x, int y, Color pixel) {
        buffer[x][y] = pixel;
    }

    public Color pixelAt(int x, int y) {
        return buffer[x][y];
    }

    public void canvasToPPMFile(String filename) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter(filename));
        this.canvasToPPM(output);
        output.close();
    }

    public String canvasToPPMString() {
        StringWriter output = new StringWriter();
        this.canvasToPPM(output);
        return output.toString();
    }

    public void canvasToPPM(Writer output) {
        try {
            output.write("P3\n" + width + " " + height + "\n255\n");

            for (int j = height - 1; j >= 0; j--) {
                for (int i = 0; i < width; i++) {
                    Color col = pixelAt(i, j);
                    col.mul(255);
                    col.clamp(0.0f, 255.9f);
                    int ir = (int) (col.red());
                    int ig = (int) (col.green());
                    int ib = (int) (col.blue());
                    output.write(ir + " " + ig + " " + ib + "\n");
                }
            }

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Color[][] getBuffer() {
        return buffer;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
