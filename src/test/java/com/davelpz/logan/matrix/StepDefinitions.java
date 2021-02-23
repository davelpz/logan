package com.davelpz.logan.matrix;

import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    Matrix m;

    @Given("the following 4x4 matrix M:")
    public void the_following_4x4_matrix_m(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        m = new Matrix(4);
        m.setData(data);
    }

    @Then("M[0,0] = {double}")
    public void m00(Double double1) {
        assertEquals(double1, m.get(0,0), 0.00001);
    }
    @Then("M[0,3] = {double}")
    public void m03(Double double1) {
        assertEquals(double1, m.get(0,3), 0.00001);
    }
    @Then("M[1,0] = {double}")
    public void m10(Double double1) {
        assertEquals(double1, m.get(1,0), 0.00001);
    }
    @Then("M[1,2] = {double}")
    public void m12(Double double1) {
        assertEquals(double1, m.get(1,2), 0.00001);
    }
    @Then("M[2,2] = {double}")
    public void m22(Double double1) {
        assertEquals(double1, m.get(2,2), 0.00001);
    }
    @Then("M[3,0] = {double}")
    public void m30(Double double1) {
        assertEquals(double1, m.get(3,0), 0.00001);
    }
    @Then("M[3,2] = {double}")
    public void m32(Double double1) {
        assertEquals(double1, m.get(3,2), 0.00001);
    }

}
