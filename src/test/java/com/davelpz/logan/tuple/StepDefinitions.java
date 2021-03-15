package com.davelpz.logan.tuple;

import com.davelpz.logan.color.Color;
import com.davelpz.logan.light.PointLight;
import com.davelpz.logan.material.Material;
import com.davelpz.logan.shapes.Sphere;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {
    Tuple a;
    Tuple b;
    Tuple p;
    Tuple p1;
    Tuple p2;
    Tuple v;
    Tuple v1;
    Tuple v2;
    Tuple a1;
    Tuple a2;
    Tuple zero;
    Tuple norm;
    Color c;
    Color c1;
    Color c2;

    @Given("a ← tuple\\({double}, {double}, {double}, {double})")
    public void a_tuple(Double double1, Double double2, Double double3, Double double4) {
        a = new Tuple(double1, double2, double3, double4);
    }

    @Then("a.x = {double}")
    public void a_x(Double double1) {
        assertEquals(double1, a.x(), 0.0);
    }

    @Then("a.y = {double}")
    public void a_y(Double double1) {
        assertEquals(double1, a.y(), 0.0);
    }

    @Then("a.z = {double}")
    public void a_z(Double double1) {
        assertEquals(double1, a.z(), 0.0);
    }

    @Then("a.w = {double}")
    public void a_w(Double double1) {
        assertEquals(double1, a.w(), 0.0);
    }

    @Then("a is a point")
    public void a_is_a_point() {
        assertTrue(a.isPoint());
    }

    @Then("a is not a vector")
    public void a_is_not_a_vector() {
        assertFalse(a.isVector());
    }

    @Then("a is not a point")
    public void a_is_not_a_point() {
        assertFalse(a.isPoint());
    }

    @Then("a is a vector")
    public void a_is_a_vector() {
        assertTrue(a.isVector());
    }

    @Given("p ← point\\({int}, {int}, {int})")
    public void p_point(Integer int1, Integer int2, Integer int3) {
        p = Tuple.point(int1, int2, int3);
    }

    @Then("p = tuple\\({int}, {int}, {int}, {int})")
    public void p_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        assertTrue(p.equals(new Tuple(int1, int2, int3, int4)));
    }

    @Given("v ← vector\\({int}, {int}, {int})")
    public void v_vector(Integer int1, Integer int2, Integer int3) {
        v = Tuple.vector(int1, int2, int3);
    }

    @Then("v = tuple\\({int}, {int}, {int}, {int})")
    public void v_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        assertTrue(v.equals(new Tuple(int1, int2, int3, int4)));
    }

    @Given("a1 ← tuple\\({int}, {int}, {int}, {int})")
    public void a1_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        a1 = new Tuple(int1, int2, int3, int4);
    }

    @Given("a2 ← tuple\\({int}, {int}, {int}, {int})")
    public void a2_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        a2 = new Tuple(int1, int2, int3, int4);
    }

    @Then("a1 plus a2 = tuple\\({int}, {int}, {int}, {int})")
    public void a1_plus_a2_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        assertTrue(a1.add(a2).equals(new Tuple(int1, int2, int3, int4)));
    }

    @Given("p1 ← point\\({int}, {int}, {int})")
    public void p1_point(Integer int1, Integer int2, Integer int3) {
        p1 = Tuple.point(int1, int2, int3);
    }

    @Given("p2 ← point\\({int}, {int}, {int})")
    public void p2_point(Integer int1, Integer int2, Integer int3) {
        p2 = Tuple.point(int1, int2, int3);
    }

    @Then("p1 subtract p2 = vector\\({int}, {int}, {int})")
    public void p1_subtract_p2_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(p1.subtract(p2).equals(Tuple.vector(int1, int2, int3)));
    }

    @Then("p subtract v = point\\({int}, {int}, {int})")
    public void p_subtract_v_point(Integer int1, Integer int2, Integer int3) {
        assertTrue(p.subtract(v).equals(Tuple.point(int1, int2, int3)));
    }

    @Given("v1 ← vector\\({int}, {int}, {int})")
    public void v1_vector(Integer int1, Integer int2, Integer int3) {
        v1 = Tuple.vector(int1, int2, int3);
    }

    @Given("v2 ← vector\\({int}, {int}, {int})")
    public void v2_vector(Integer int1, Integer int2, Integer int3) {
        v2 = Tuple.vector(int1, int2, int3);
    }

    @Then("v1 subtract v2 = vector\\({int}, {int}, {int})")
    public void v1_subtract_v2_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(v1.subtract(v2).equals(Tuple.vector(int1, int2, int3)));
    }

    @Given("zero ← vector\\({int}, {int}, {int})")
    public void zero_vector(Integer int1, Integer int2, Integer int3) {
        zero = Tuple.vector(int1, int2, int3);
    }

    @Then("zero subtract v = vector\\({int}, {int}, {int})")
    public void zero_subtract_v_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(zero.subtract(v).equals(Tuple.vector(int1, int2, int3)));
    }

    @Then("negate a = tuple\\({int}, {int}, {int}, {int})")
    public void negate_a_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        assertTrue(a.negate().equals(new Tuple(int1, int2, int3, int4)));
    }

    @Then("a mul {double} = tuple\\({double}, {double}, {double}, {double})")
    public void a_mul_tuple(Double double1, Double double2, Double double3, Double double4, Double double5) {
        assertTrue(a.mul(double1).equals(new Tuple(double2, double3, double4, double5)));
        assertTrue(Tuple.mul(double1,a).equals(new Tuple(double2, double3, double4, double5)));
    }

    @Then("a div {double} = tuple\\({double}, {double}, {double}, {double})")
    public void a_div_tuple(Double double1, Double double2, Double double3, Double double4, Double double5) {
        assertTrue(a.div(double1).equals(new Tuple(double2, double3, double4, double5)));
    }

    @Then("magnitude\\(v) = {double}")
    public void magnitude_v(Double double1) {
        assertEquals(double1, v.magnitude(), Tuple.EPSILON);
    }

    @Then("magnitude\\(v) = √{int}")
    public void magnitude_v2(Integer int1) {
        assertEquals(Math.sqrt(int1), v.magnitude(), Tuple.EPSILON);
    }

    @Then("normalize\\(v) = vector\\({double}, {double}, {double})")
    public void normalize_v_vector(Double double1, Double double2, Double double3) {
        assertTrue(v.normalize().equals(Tuple.vector(double1,double2, double3)));
    }

    @Then("normalize\\(v) = approximately vector\\({double}, {double}, {double})")
    public void normalize_v_approximately_vector(Double double1, Double double2, Double double3) {
        assertTrue(v.normalize().equals(Tuple.vector(double1,double2, double3)));
    }

    @When("norm ← normalize\\(v)")
    public void norm_normalize_v() {
        norm = v.normalize();
    }

    @Then("magnitude\\(norm) = {double}")
    public void magnitude_norm(Double double1) {
        assertEquals(norm.magnitude(), double1, Tuple.EPSILON);
    }

    @Given("a ← vector\\({int}, {int}, {int})")
    public void a_vector(Integer int1, Integer int2, Integer int3) {
        a = Tuple.vector(int1,int2,int3);
    }

    @Given("b ← vector\\({int}, {int}, {int})")
    public void b_vector(Integer int1, Integer int2, Integer int3) {
        b = Tuple.vector(int1,int2,int3);
    }

    @Then("dot\\(a, b) = {double}")
    public void dot_a_b(Double double1) {
        assertEquals(a.dot(b), double1, Tuple.EPSILON);
    }

    @Then("cross\\(a, b) = vector\\({int}, {int}, {int})")
    public void cross_a_b_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(a.cross(b).equals(Tuple.vector(int1, int2, int3)));
    }

    @Then("cross\\(b, a) = vector\\({int}, {int}, {int})")
    public void cross_b_a_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(b.cross(a).equals(Tuple.vector(int1, int2, int3)));
    }

    @Given("c ← color\\({double}, {double}, {double})")
    public void c_color(Double double1, Double double2, Double double3) {
        c = new Color(double1,double2,double3);
    }

    @Then("c.red = {double}")
    public void c_red(Double double1) {
        assertEquals(c.red(),double1,Color.EPSILON);
    }

    @Then("c.green = {double}")
    public void c_green(Double double1) {
        assertEquals(c.green(),double1,Color.EPSILON);
    }

    @Then("c.blue = {double}")
    public void c_blue(Double double1) {
        assertEquals(c.blue(),double1,Color.EPSILON);
    }

    @Given("c1 ← color\\({double}, {double}, {double})")
    public void c1_color(Double double1, Double double2, Double double3) {
        c1 = new Color(double1,double2,double3);
    }

    @Given("c2 ← color\\({double}, {double}, {double})")
    public void c2_color(Double double1, Double double2, Double double3) {
        c2 = new Color(double1,double2,double3);
    }

    @Then("c1 plus c2 = color\\({double}, {double}, {double})")
    public void c1_plus_c2_color(Double double1, Double double2, Double double3) {
        assertTrue(c1.add(c2).equals(new Color(double1, double2, double3)));
    }

    @Then("c1 subtract c2 = color\\({double}, {double}, {double})")
    public void c1_subtract_c2_color(Double double1, Double double2, Double double3) {
        assertTrue(c1.subtract(c2).equals(new Color(double1, double2, double3)));
    }

    @Then("c mul {double} = color\\({double}, {double}, {double})")
    public void c_mul_color(Double double1, Double double2, Double double3, Double double4) {
        assertTrue(c.mul(double1).equals(new Color(double2, double3, double4)));
    }

    @Then("c1 mul c2 = color\\({double}, {double}, {double})")
    public void c1_mul_c2_color(Double double1, Double double2, Double double3) {
        assertTrue(c1.mul(c2).equals(new Color(double1, double2, double3)));
    }

    Tuple n;
    @Given("n ← vector\\({double}, {double}, {double})")
    public void n_vector(Double int1, Double int2, Double int3) {
        n = Tuple.vector(int1,int2,int3);
    }

    Tuple r;
    @When("r ← reflect\\(v, n)")
    public void r_reflect_v_n() {
        r = v.reflect(n);
    }

    @Then("r = vector\\({int}, {int}, {int})")
    public void r_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(r.equals(Tuple.vector(int1,int2,int3)));
    }

    public void n_vector(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    Color intensity;
    Tuple position;
    @Given("intensity ← color\\({int}, {int}, {int})")
    public void intensity_color(Integer int1, Integer int2, Integer int3) {
        intensity = new Color(int1,int2,int3);
    }

    @Given("position ← point\\({int}, {int}, {int})")
    public void position_point(Integer int1, Integer int2, Integer int3) {
        position = Tuple.point(int1,int2,int3);
    }

    PointLight light;
    @When("light ← point_light\\(position, intensity)")
    public void light_point_light_position_intensity() {
        light = new PointLight(intensity,position);
    }

    @Then("light.position = position")
    public void light_position_position() {
        assertTrue(light.getPosition().equals(position));
    }

    @Then("light.intensity = intensity")
    public void light_intensity_intensity() {
        assertTrue(light.getIntensity().equals(intensity));
    }

    Material m;
    @Given("m ← material")
    public void m_material() {
        m = new Material();
    }

    @Then("m.color = color\\({int}, {int}, {int})")
    public void m_color_color(Integer int1, Integer int2, Integer int3) {
        assertTrue(m.getPattern().equals(new Color(int1,int2,int3)));
    }

    @Then("m.ambient = {double}")
    public void m_ambient(Double double1) {
        assertEquals(m.getAmbient(),double1,0.00001);
    }

    @Then("m.diffuse = {double}")
    public void m_diffuse(Double double1) {
        assertEquals(m.getDiffuse(),double1,0.00001);
    }

    @Then("m.specular = {double}")
    public void m_specular(Double double1) {
        assertEquals(m.getSpecular(),double1,0.00001);
    }

    @Then("m.shininess = {double}")
    public void m_shininess(Double double1) {
        assertEquals(m.getShininess(),double1,0.00001);
    }

    Tuple eyev,normalv;
    @Given("eyev ← vector\\({double}, {double}, {double})")
    public void eyev_vector(Double int1, Double int2, Double int3) {
        eyev = Tuple.vector(int1,int2,int3);
    }

    @Given("normalv ← vector\\({int}, {int}, {int})")
    public void normalv_vector(Integer int1, Integer int2, Integer int3) {
        normalv = Tuple.vector(int1,int2,int3);
    }

    @Given("light ← point_light\\(point-{int}-{int}-{int}, color-{int}-{int}-{int})")
    public void light_point_light_point_color(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        light = new PointLight(new Color(int4,int5,int6), Tuple.point(int1,int2,int3));
    }

    Color result;
    @When("result ← lighting\\(m, light, position, eyev, normalv)")
    public void result_lighting_m_light_position_eyev_normalv() {
        result = m.lighting(new Sphere(),light,position,eyev,normalv);
    }

    @Then("result = color\\({double}, {double}, {double})")
    public void result_color(Double double1, Double double2, Double double3) {
        assertTrue(result.equals(new Color(double1,double2,double3)));
    }

    boolean in_shadow;
    @Given("in_shadow ← true")
    public void in_shadow_true() {
        in_shadow = true;
    }

    @When("result ← lighting\\(m, light, position, eyev, normalv, in_shadow)")
    public void result_lighting_m_light_position_eyev_normalv_in_shadow() {
        result = m.lighting(new Sphere(),light,position,eyev,normalv,in_shadow);
    }

}
