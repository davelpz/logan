package com.davelpz.logan.world;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.material.Material;
import com.davelpz.logan.matrix.Matrix;
import com.davelpz.logan.ray.Computation;
import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.shapes.Shape;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;

import java.util.*;

public class World implements Comparator<Intersection>{
    private List<PointLight> lights;
    private List<Shape> objects;

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

    public List<Shape> getObjects() {
        return objects;
    }

    public void setObjects(List<Shape> objects) {
        this.objects = objects;
    }

    public Intersection[] intersect_world(Ray r) {
        ArrayList<Intersection> list = new ArrayList<>();

        for (Shape s: objects) {
            Collections.addAll(list, r.intersect(s));
        }

        list.sort(this);
        return list.toArray(new Intersection[]{});
    }

    public Color shade_hit(Computation comps) {
        boolean shadowed = is_shadowed(comps.over_point);
        return comps.object.material.lighting(this.lights.get(0),comps.point,comps.eyev,comps.normalv,shadowed);
    }

    public Color color_at(Ray ray) {
        Intersection[] xs = this.intersect_world(ray);
        Optional<Intersection> intersectionOptional = Intersection.hit(xs);

        if (intersectionOptional.isEmpty()) {
            return Color.BLACK;
        } else {
            Intersection intersection = intersectionOptional.get();
            Computation comps = intersection.prepare_computations(ray);
            return shade_hit(comps);
        }
    }

    public static Matrix view_transform(Tuple from, Tuple to, Tuple up) {
        Tuple forward = to.subtract(from).normalize();
        Tuple left = forward.cross(up.normalize());
        Tuple true_up = left.cross(forward);
        Matrix orientation = new Matrix(4);
        orientation.set(0,0, left.x());
        orientation.set(0,1, left.y());
        orientation.set(0,2, left.z());
        orientation.set(0,3, 0);
        orientation.set(1,0, true_up.x());
        orientation.set(1,1, true_up.y());
        orientation.set(1,2, true_up.z());
        orientation.set(1,3, 0);
        orientation.set(2,0, -forward.x());
        orientation.set(2,1, -forward.y());
        orientation.set(2,2, -forward.z());
        orientation.set(2,3, 0);
        orientation.set(3,0, 0);
        orientation.set(3,1, 0);
        orientation.set(3,2, 0);
        orientation.set(3,3, 1);

        return orientation.multiply(Matrix.translation(-from.x(),-from.y(),-from.z()));
    }

    public boolean is_shadowed(Tuple point) {
        Tuple v = lights.get(0).getPosition().subtract(point);
        double distance = v.magnitude();
        Tuple direction = v.normalize();
        Ray r = new Ray(point,direction);
        Intersection[] xs = intersect_world(r);
        Optional<Intersection> hit = Intersection.hit(xs);
        return hit.isPresent() && hit.get().t < distance;
    }

    @Override
    public int compare(Intersection o1, Intersection o2) {
        return Double.compare(o1.t, o2.t);
    }
}
