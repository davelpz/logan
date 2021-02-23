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
        this((int) width, (int) height);
    }

    public void clear(Color pixel) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                buffer[x][y] = new Color(pixel);
            }
        }
    }

    public void writePixel(Color pixel, int x, int y) {
        buffer[x][y] = pixel;
    }
    public void writePixel(Color pixel, double x, double y) {
        writePixel(pixel,(int)x,(int)y);
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

    private int write(Writer output, int length, String content, boolean skipDelim) throws IOException {
        int content_length = content.length();

        if ((length + content_length + 1) > 70) {
            output.write("\n");
            output.write(content);
            return content_length;
        } else {
            if (!skipDelim) {
                output.write(" ");
                content_length++;
            }
            output.write(content);
            return content_length + length;
        }
    }

    public void canvasToPPM(Writer output) {
        try {
            output.write("P3\n" + width + " " + height + "\n255\n");

            for (int j = 0; j < height; j++) {
                int line_width = 0;
                for (int i = 0; i < width; i++) {
                    Color col = pixelAt(i, j);
                    col.mul(255.0);
                    col.clamp(0.0, 255.0);
                    int ir = (int) (col.red() + 0.5);
                    int ig = (int) (col.green() + 0.5);
                    int ib = (int) (col.blue() + 0.5);
                    String str_ir = String.valueOf(ir);
                    String str_ig = String.valueOf(ig);
                    String str_ib = String.valueOf(ib);

                    line_width = write(output,line_width,str_ir,i == 0);
                    line_width = write(output,line_width,str_ig,false);
                    line_width = write(output,line_width,str_ib,false);
                }
                output.write("\n");
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
