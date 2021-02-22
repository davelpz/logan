package com.davelpz.logan.canvas;

import com.davelpz.logan.color.Color;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StepDefinitions {
    Canvas c;
    Color co1,co2,co3;
    Color red;
    String ppm;

    @Given("c ← canvas\\({int}, {int})")
    public void c_canvas(Integer int1, Integer int2) {
        c = new Canvas(int1,int2);
    }

    @Then("c.width = {int}")
    public void c_width(Integer int1) {
        assertEquals(int1.intValue(),c.getWidth());
    }

    @Then("c.height = {int}")
    public void c_height(Integer int1) {
        assertEquals(int1.intValue(),c.getHeight());
    }

    @Then("every pixel of c is color\\({int}, {int}, {int})")
    public void every_pixel_of_c_is_color(Integer int1, Integer int2, Integer int3) {
        Color t = new Color(int1,int2,int3);
        for (int x = 0; x < c.getWidth(); x++) {
            for (int y = 0; y < c.getHeight(); y++) {
                Color pixel = c.pixelAt(x,y);
                assertTrue(t.equals(pixel));
            }
        }
    }

    @Given("red ← color\\({int}, {int}, {int})")
    public void red_color(Integer int1, Integer int2, Integer int3) {
        red = new Color(int1,int2,int3);
    }

    @When("write_pixel\\(c, {int}, {int}, red)")
    public void write_pixel_c_red(Integer int1, Integer int2) {
        c.writePixel(red,int1,int2);
    }

    @Then("pixel_at\\(c, {int}, {int}) = red")
    public void pixel_at_c_red(Integer int1, Integer int2) {
        assertTrue(c.pixelAt(int1,int2).equals(red));
    }

    @When("ppm ← canvas_to_ppm\\(c)")
    public void ppm_canvas_to_ppm_c() {
        ppm = c.canvasToPPMString();
    }

    @Then("lines {int}-{int} of ppm are")
    public void lines_of_ppm_are(Integer int1, Integer int2, String docString) {
        String[] lines = ppm.split("\n");
        String[] lines_subset = Arrays.copyOfRange(lines,int1-1,int2);
        String subset = String.join("\n", lines_subset);
        System.out.println("|" + docString + "|");
        System.out.println("|" + subset + "|");
        assertTrue(docString.equals(subset));
    }

    @Given("co1 ← color\\({double}, {double}, {double})")
    public void co1_color(Double double1, Double double2, Double double3) {
        co1 = new Color(double1,double2,double3);
    }

    @Given("co2 ← color\\({double}, {double}, {double})")
    public void co2_color(Double double1, Double double2, Double double3) {
        co2 = new Color(double1,double2,double3);
    }

    @Given("co3 ← color\\({double}, {double}, {double})")
    public void co3_color(Double double1, Double double2, Double double3) {
        co3 = new Color(double1,double2,double3);
    }

    @When("write_pixel\\(c, {int}, {int}, co1)")
    public void write_pixel_c_c1(Integer int1, Integer int2) {
        c.writePixel(co1,int1,int2);
    }

    @When("write_pixel\\(c, {int}, {int}, co2)")
    public void write_pixel_c_c2(Integer int1, Integer int2) {
        c.writePixel(co2,int1,int2);
    }

    @When("write_pixel\\(c, {int}, {int}, co3)")
    public void write_pixel_c_c3(Integer int1, Integer int2) {
        c.writePixel(co3,int1,int2);
    }

    @When("every pixel of c is set to color\\({double}, {double}, {double})")
    public void every_pixel_of_c_is_set_to_color(Double double1, Double double2, Double double3) {
        Color t = new Color(double1,double2,double3);
        c.clear(t);
    }
}
