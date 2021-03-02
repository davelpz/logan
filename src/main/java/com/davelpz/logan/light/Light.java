package com.davelpz.logan.light;

import com.davelpz.logan.color.Color;

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
}
