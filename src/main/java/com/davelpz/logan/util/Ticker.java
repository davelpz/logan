package com.davelpz.logan.util;

public class Ticker {
    float max_count;
    int count;
    int fiveper;
    long elapsed_start;
    long time_start;

    public Ticker(int max, int ns) {
        max_count = max;
        fiveper = (int) (max_count * 0.05f);
        elapsed_start = System.currentTimeMillis();
        time_start = elapsed_start;
        System.out.format("%s pixels, %.0f light rays", max_count, max_count * ns);
    }

    public void tick() {
        count = count + 1;
        if (count % fiveper == 0) {
            int percent = (int) (((count / max_count) * 10000.0f) / 100.0f);
            long elapsed_total_time = System.currentTimeMillis() - time_start;
            long estimated_total_time = (long) (elapsed_total_time * (100.0f / percent));
            long estimated_time_left = estimated_total_time - elapsed_total_time;
            long elapsed_time = System.currentTimeMillis() - elapsed_start;
            long elapsed_pixel = elapsed_time / fiveper;
            System.out.format("\r%2d%%    %2dms per pixel    %6dms    %6dms", percent, elapsed_pixel, elapsed_total_time,
                    estimated_time_left);
            elapsed_start = System.currentTimeMillis();
        }
    }

    public void reportElapsed() {
        long elapsed = (System.currentTimeMillis() - time_start) / 1000;
        System.out.print("\r" + elapsed + " seconds    ");
    }

    public void end() {
        reportElapsed();
    }
}
