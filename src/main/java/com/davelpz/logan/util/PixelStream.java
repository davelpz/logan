package com.davelpz.logan.util;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class PixelStream {
    public int x;
    public int y;

    public PixelStream(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Stream<PixelStream> genStream(final double width, final double height) {
        return genStream(((int) width), ((int) height));
    }

    public static Stream<PixelStream> genStream(final int width, final int height) {

        Predicate<PixelStream> hasNext = p -> (p.x != 0 || p.y != height);

        UnaryOperator<PixelStream> next = p -> {
            int tx = p.x;
            int ty = p.y;

            if (tx < (width-1)) {
                tx++;
            } else {
                tx = 0;
                ty++;
            }

            return new PixelStream(tx, ty);
        };

        Stream<PixelStream> stream = Stream.iterate(new PixelStream(0, 0), hasNext, next);

        return stream;
    }

    public String toString() {
        return "PixelStream(" + x + "," + y + ")";
    }
}
