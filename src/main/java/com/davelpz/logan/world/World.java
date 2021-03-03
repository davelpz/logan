package com.davelpz.logan.world;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.ray.Computation;
import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;

import java.util.*;

public class World implements Comparator<Intersection>{
    private List<PointLight> lights;
    private List<Sphere> objects;

    public World() {
        this.lights = new ArrayList<>();
        this.objects = new ArrayList<>();
    }

    public static World defaultWorld() {
        World w = new World();
        w.getLights().add(new PointLight(new Color(1, 1, 1), Tuple.point(-10, 10, -10)));
        Sphere s = new Sphere();
        Material m = new Material();
        m.setColor(new Color(0.8, 1.0, 0.6));
        m.setDiffuse(0.7);
        m.setSpecular(0.2);
        s.material = m;

        Sphere s2 = new Sphere();
        s2.setTransform(Matrix.scaling(0.5,0.5,0.5));

        w.getObjects().add(s);
        w.getObjects().add(s2);

        return w;
    }

    public List<PointLight> getLights() {
        return lights;
    }

    public void setLights(List<PointLight> lights) {
        this.lights = lights;
    }

    public List<Sphere> getObjects() {
        return objects;
    }

    public void setObjects(List<Sphere> objects) {
        this.objects = objects;
    }

    public Intersection[] intersect_world(Ray r) {
        ArrayList<Intersection> list = new ArrayList<>();

        for (Sphere s: objects) {
            Collections.addAll(list, r.intersects(s));
        }

        list.sort(this);
        return list.toArray(new Intersection[]{});
    }

    public Color shade_hit(Computation comps) {
        return Material.lighting(comps.object.material,this.lights.get(0),comps.point,comps.eyev,comps.normalv);
    }

    public Color color_at(Ray ray) {
        Intersection[] xs = this.intersect_world(ray);
        Optional<Intersection> intersectionOptional = Intersection.hit(xs);

        if (intersectionOptional.isEmpty()) {
            return new Color(0,0,0);
        } else {
            Intersection intersection = intersectionOptional.get();
            Computation comps = intersection.prepare_computations(ray);
            return shade_hit(comps);
        }
    }

    @Override
    public int compare(Intersection o1, Intersection o2) {
        return Double.compare(o1.t, o2.t);
    }
}
