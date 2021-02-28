package com.davelpz.logan.matrix;

import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    public void setHour(Canvas c, double x, double y) {
        y = -y + (550.0 / 2.0);
        x = x + (900.0 / 2.0);
        c.writePixel(new Color(1,1,1), x,y);
        c.writePixel(new Color(1,1,1), x-1,y-1);
        c.writePixel(new Color(1,1,1), x+1,y+1);
        c.writePixel(new Color(1,1,1), x+1,y-1);
        c.writePixel(new Color(1,1,1), x-1,y+1);
        c.writePixel(new Color(1,1,1), x,y+1);
        c.writePixel(new Color(1,1,1), x,y-1);
        c.writePixel(new Color(1,1,1), x+1,y);
        c.writePixel(new Color(1,1,1), x-1,y);
    }

    public void setMinute(Canvas c, double x, double y) {
        y = -y + (550.0 / 2.0);
        x = x + (900.0 / 2.0);
        c.writePixel(new Color(1,1,1), x,y);
    }

    @Test
    public void clock() throws IOException {
        Canvas c = new Canvas(900,550);
        setHour(c,0,0);

        Tuple center;
        Matrix m;
        int size = 250;

        for (int i=0;i<12;i++) {
            center = Tuple.point(0,size,0);
            m = Matrix.start().rotationZ(i * (-Math.PI / 6.0)).end();
            center = m.multiply(center);
            setHour(c, center.x(), center.y());
        }

        for (;size>10;size-=50) {
            for (int i = 0; i < 60; i++) {
                center = Tuple.point(0, size, 0);
                m = Matrix.start().rotationZ(i * (-Math.PI / 30.0)).end();
                center = m.multiply(center);
                setMinute(c, center.x(), center.y());
            }
        }
        c.canvasToPPMFile("output.ppm");
    }
}