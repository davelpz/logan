package com.davelpz.logan.material;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.material.pattern.Pattern;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.tuple.Tuple;

import java.util.Objects;

public class Material {
    private double ambient;
    private double diffuse;
    private double specular;
    private double shininess;
    private Pattern pattern;

    public Material() {
        pattern = new Color(1, 1, 1);
        ambient = 0.1;
        diffuse = 0.9;
        specular = 0.9;
        shininess = 200.0;
    }

    public Color lighting(Shape object, PointLight light, Tuple point,
                          Tuple eyev, Tuple normalv) {
        return Material.lighting(this,object,light,point,eyev,normalv,false);
    }

    public Color lighting(Shape object, PointLight light, Tuple point,
                    Tuple eyev, Tuple normalv, boolean in_shadow) {
        return Material.lighting(this,object,light,point,eyev,normalv,in_shadow);
    }

    private static Color lighting(Material material, Shape object, PointLight light, Tuple point,
                                 Tuple eyev, Tuple normalv) {
        return lighting(material,object,light,point,eyev,normalv,false);
    }

    private static Color lighting(Material material, Shape object, PointLight light, Tuple point,
                                  Tuple eyev, Tuple normalv, boolean in_shadow) {
        Color color = material.pattern.pattern_at_shape(object,point);
        // combine the surface color with the lights color/intensity
        Color effective_color = color.mul(light.getIntensity());
        // find the direction to the light source
        Tuple lightv = light.getPosition().subtract(point).normalize();
        // computer the ambient contribution
        Color ambient = effective_color.mul(material.getAmbient());
        // light_dot_normal represents the cosine of the angle between
        // the light vector and the normal vector. A negative number
        // means the light is on the other side of the surface.
        double light_dot_normal = lightv.dot(normalv);

        Color diffuse;
        Color specular;
        if (light_dot_normal < 0.0) {
            diffuse = new Color(0, 0, 0);
            specular = diffuse;
        } else {
            // computer the diffuse contribution
            diffuse = effective_color.mul(material.diffuse * light_dot_normal);

            // reflect_dot_eye represents the cosine of the angle between
            // the reflection vector and the eye vector. A negative number
            // means the light reflects away from the eye.
            Tuple reflectv = lightv.negate().reflect(normalv);
            double reflect_dot_eye = reflectv.dot(eyev);
            if (reflect_dot_eye <= 0) {
                specular = new Color(0, 0, 0);
            } else {
                // computer the specular contribution
                double factor = Math.pow(reflect_dot_eye, material.shininess);
                specular = light.getIntensity().mul(material.getSpecular() * factor);
            }
        }

        if (in_shadow) {
            return ambient;
        } else {
            // add the three contributions together to get the final shading
            return ambient.add(diffuse).add(specular);
        }
    }

    public Color getColor2() {
        return null;
    }

    public void setColor(Color color) {
        this.pattern = color;
    }

    public double getAmbient() {
        return ambient;
    }

    public void setAmbient(double ambient) {
        this.ambient = ambient;
    }

    public double getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(double diffuse) {
        this.diffuse = diffuse;
    }

    public double getSpecular() {
        return specular;
    }

    public void setSpecular(double specular) {
        this.specular = specular;
    }

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Double.compare(material.ambient, ambient) == 0 && Double.compare(material.diffuse, diffuse) == 0 && Double.compare(material.specular, specular) == 0 && Double.compare(material.shininess, shininess) == 0 && pattern.equals(material.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ambient, diffuse, specular, shininess, pattern);
    }
}
