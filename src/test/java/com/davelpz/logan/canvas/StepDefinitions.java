package com.davelpz.logan.canvas;

import com.davelpz.logan.color.Color;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class StepDefinitions {
    Canvas c;

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
}
