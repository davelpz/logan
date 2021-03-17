package com.davelpz.logan.noise;

import com.davelpz.logan.tuple.Tuple;

public class Perlin {

    private final Tuple[] ranTuple = perlin_generate();
    private final int[] perm_x = perlin_generate_perm();
    private final int[] perm_y = perlin_generate_perm();
    private final int[] perm_z = perlin_generate_perm();

    public double noise(final Tuple p) {
        double u = (p.x() - Math.floor(p.x()));
        double v = (p.y() - Math.floor(p.y()));
        double w = (p.z() - Math.floor(p.z()));

        int i = (int) Math.floor(p.x());
        int j = (int) Math.floor(p.y());
        int k = (int) Math.floor(p.z());
        Tuple[][][] c = new Tuple[2][2][2];
        for (int di = 0; di < 2; di++) {
            for (int dj = 0; dj < 2; dj++) {
                for (int dk = 0; dk < 2; dk++) {
                    c[di][dj][dk] = ranTuple[perm_x[(i + di) & 255] ^ perm_y[(j + dj) & 255] ^ perm_z[(k + dk) & 255]];
                }
            }
        }
        return perlin_interp(c, u, v, w);
    }

    private double perlin_interp(Tuple[][][] c, double u, double v, double w) {
        double uu = u * u * (3 - 2 * u);
        double vv = v * v * (3 - 2 * v);
        double ww = w * w * (3 - 2 * w);
        double accum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    Tuple weight_v = Tuple.point(u - i, v - j, w - k);
                    accum += (i * uu + (1 - i) * (1 - uu)) * (j * vv + (1 - j) * (1 - vv))
                            * (k * ww + (1 - k) * (1 - ww)) * c[i][j][k].dot(weight_v);
                }
            }
        }

        return accum;
    }

    private Tuple[] perlin_generate() {
        Tuple[] p = new Tuple[256];
        for (int i = 0; i < 256; i++) {
            p[i] = (Tuple.point(-1 + 2 * Math.random(), -1 + 2 * Math.random(), -1 + 2 * Math.random())).normalize();
        }

        return p;
    }

    private void permute(int[] p, int n) {
        for (int i = n - 1; i > 0; i--) {
            int target = (int) (Math.random() * (i + 1));
            int tmp = p[i];
            p[i] = p[target];
            p[target] = tmp;
        }
    }

    private int[] perlin_generate_perm() {
        int[] p = new int[256];
        for (int i = 0; i < 256; i++) {
            p[i] = i;
        }
        permute(p, 256);
        return p;
    }
}
