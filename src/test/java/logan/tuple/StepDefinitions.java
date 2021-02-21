package logan.tuple;

import com.davelpz.tuple.Tuple;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {
    Tuple a;
    Tuple p;
    Tuple p1;
    Tuple p2;
    Tuple v;
    Tuple v1;
    Tuple v2;
    Tuple a1;
    Tuple a2;
    Tuple zero;

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
        assertTrue(Tuple.add(a1, a2).equals(new Tuple(int1, int2, int3, int4)));
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
        assertTrue(Tuple.subtract(p1, p2).equals(Tuple.vector(int1, int2, int3)));
    }

    @Then("p subtract v = point\\({int}, {int}, {int})")
    public void p_subtract_v_point(Integer int1, Integer int2, Integer int3) {
        assertTrue(Tuple.subtract(p, v).equals(Tuple.point(int1, int2, int3)));
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
        assertTrue(Tuple.subtract(v1, v2).equals(Tuple.vector(int1, int2, int3)));
    }

    @Given("zero ← vector\\({int}, {int}, {int})")
    public void zero_vector(Integer int1, Integer int2, Integer int3) {
        zero = Tuple.vector(int1, int2, int3);
    }

    @Then("zero subtract v = vector\\({int}, {int}, {int})")
    public void zero_subtract_v_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(Tuple.subtract(zero, v).equals(Tuple.vector(int1, int2, int3)));
    }

    @Then("negate a = tuple\\({int}, {int}, {int}, {int})")
    public void negate_a_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        assertTrue(Tuple.negate(a).equals(new Tuple(int1, int2, int3, int4)));
    }

    @Then("a mul {double} = tuple\\({double}, {double}, {double}, {double})")
    public void a_mul_tuple(Double double1, Double double2, Double double3, Double double4, Double double5) {
        assertTrue(Tuple.mul(a, double1).equals(new Tuple(double2, double3, double4, double5)));
    }

    @Then("a div {double} = tuple\\({double}, {double}, {double}, {double})")
    public void a_div_tuple(Double double1, Double double2, Double double3, Double double4, Double double5) {
        assertTrue(Tuple.div(a, double1).equals(new Tuple(double2, double3, double4, double5)));
    }

    @Then("magnitude\\(v) = {double}")
    public void magnitude_v(Double double1) {
        assertEquals(double1, v.magnitude(), 0.00001);
    }

    @Then("magnitude\\(v) = √{int}")
    public void magnitude_v2(Integer int1) {
        assertEquals(Math.sqrt(int1), v.magnitude(), 0.00001);
    }

    @Then("normalize\\(v) = vector\\({int}, {int}, {int})")
    public void normalize_v_vector(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("normalize\\(v) = approximately vector\\({double}, {double}, {double})")
    public void normalize_v_approximately_vector(Double double1, Double double2, Double double3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("norm ← normalize\\(v)")
    public void norm_normalize_v() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("magnitude\\(norm) = {int}")
    public void magnitude_norm(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("a ← vector\\({int}, {int}, {int})")
    public void a_vector(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("b ← vector\\({int}, {int}, {int})")
    public void b_vector(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("dot\\(a, b) = {int}")
    public void dot_a_b(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("cross\\(a, b) = vector\\({int}, {int}, {int})")
    public void cross_a_b_vector(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("cross\\(b, a) = vector\\({int}, {int}, {int})")
    public void cross_b_a_vector(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("c ← color\\({double}, {double}, {double})")
    public void c_color(Double double1, Double double2, Double double3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("c.red = {double}")
    public void c_red(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("c.green = {double}")
    public void c_green(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("c.blue = {double}")
    public void c_blue(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("c1 ← color\\({double}, {double}, {double})")
    public void c1_color(Double double1, Double double2, Double double3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("c2 ← color\\({double}, {double}, {double})")
    public void c2_color(Double double1, Double double2, Double double3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("c1 {double} c2 = color\\({double}, {double}, {double})")
    public void c1_c2_color(Double double1, Double double2, Double double3, Double double4) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("c * {int} = color\\({double}, {double}, {double})")
    public void c_color(Integer int1, Double double1, Double double2, Double double3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("c2 ← color\\({double}, {int}, {double})")
    public void c2_color(Double double1, Integer int1, Double double2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("c1 * c2 = color\\({double}, {double}, {double})")
    public void c1_c2_color(Double double1, Double double2, Double double3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("n ← vector\\({int}, {int}, {int})")
    public void n_vector(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("r ← reflect\\(v, n)")
    public void r_reflect_v_n() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("r = vector\\({int}, {int}, {int})")
    public void r_vector(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    public void n_vector(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
