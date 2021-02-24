package com.davelpz.logan.matrix;

import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StepDefinitions {
    Matrix a,b,m;

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
    @Then("M[0,1] = {double}")
    public void m01(Double double1) {
        assertEquals(double1, m.get(0,1), 0.00001);
    }
    @Then("M[0,3] = {double}")
    public void m03(Double double1) {
        assertEquals(double1, m.get(0,3), 0.00001);
    }
    @Then("M[1,0] = {double}")
    public void m10(Double double1) {
        assertEquals(double1, m.get(1,0), 0.00001);
    }
    @Then("M[1,1] = {double}")
    public void m11(Double double1) {
        assertEquals(double1, m.get(1,1), 0.00001);
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

    @Given("the following 2x2 matrix M:")
    public void the_following_2x2_matrix_m(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        m = new Matrix(2);
        m.setData(data);
    }

    @Given("the following 3x3 matrix M:")
    public void the_following_3x3_matrix_m(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        m = new Matrix(3);
        m.setData(data);
    }

    @Given("the following matrix A:")
    public void the_following_matrix_a(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        a = new Matrix(4);
        a.setData(data);
    }

    @Given("the following matrix B:")
    public void the_following_matrix_b(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        b = new Matrix(4);
        b.setData(data);
    }

    @Then("A equals B")
    public void a_equals_b() {
        assertTrue(a.equals(b));
    }

    @Then("A not equals B")
    public void a_not_equals_b() {
        assertFalse(a.equals(b));
    }

    @Then("A mul B is the following 4x4 matrix:")
    public void a_mul_b_is_the_following_4x4_matrix(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        Matrix expectedResult = new Matrix(4);
        expectedResult.setData(data);

        Matrix result = Matrix.multiply(a,b);

        assertTrue(result.equals(expectedResult));
    }

    Tuple tb;

    @Given("tb ← tuple\\({int}, {int}, {int}, {int})")
    public void tb_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        tb = new Tuple(int1,int2,int3,int4);
    }

    @Then("A mul tb = tuple\\({int}, {int}, {int}, {int})")
    public void a_mul_tb_tuple(Integer int1, Integer int2, Integer int3, Integer int4) {
        Tuple t = new Tuple(int1,int2,int3,int4);
        Tuple result = Matrix.multiply(a,tb);
        assertTrue(t.equals(result));
    }

}
