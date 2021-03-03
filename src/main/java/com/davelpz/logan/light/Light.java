package com.davelpz.logan.light;

import com.davelpz.logan.color.Color;

import java.util.Objects;

public abstract class Light {
    private Color intensity;

    public Light(Color intensity) {
        this.intensity = intensity;
    }

    public Color getIntensity() {
        return intensity;
    }

    public void setIntensity(Color intensity) {
        this.intensity = intensity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Light light = (Light) o;
        return intensity.equals(light.intensity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intensity);
    }
}
