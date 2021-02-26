package com.davelpz.logan.matrix;

import com.davelpz.logan.tuple.Tuple;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.Assert.*;

public class StepDefinitions {
    Matrix a,b,c,m;

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

    @Then("A mul identity_matrix = A")
    public void a_mul_identity_matrix_a() {
        Matrix result = Matrix.multiply(a,Matrix.identity4);
        assertTrue(result.equals(a));
    }

    @Then("identity_matrix mul tb = tb")
    public void identity_matrix_mul_tb_tb() {
        Tuple result = Matrix.multiply(Matrix.identity4,tb);
        assertTrue(tb.equals(result));
    }

    @Then("transpose\\(A) is the following matrix:")
    public void transpose_a_is_the_following_matrix(io.cucumber.datatable.DataTable dataTable) {
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
        assertTrue(Matrix.transpose(a).equals(expectedResult));
    }

    @Given("A ← transpose\\(identity_matrix)")
    public void a_transpose_identity_matrix() {
        a = Matrix.transpose(Matrix.identity4);
    }

    @Then("A = identity_matrix")
    public void a_identity_matrix() {
        assertTrue(a.equals(Matrix.identity4));
    }

    @Given("the following 2x2 matrix A:")
    public void the_following_2x2_matrix_a(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        a = new Matrix(2);
        a.setData(data);
    }

    @Then("determinant\\(A) = {int}")
    public void determinant_a(Integer int1) {
        assertEquals((double)int1, a.determinant(), 0.00001);
    }

    @Given("the following 3x3 matrix A:")
    public void the_following_3x3_matrix_a(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        a = new Matrix(3);
        a.setData(data);
    }

    @Then("submatrix\\(A, {int}, {int}) is the following 2x2 matrix:")
    public void submatrix_a_is_the_following_2x2_matrix(Integer int1, Integer int2, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        Matrix expected = new Matrix(2);
        expected.setData(data);
        assertTrue(a.submatrix(int1,int2).equals(expected) );
    }

    @Given("the following 4x4 matrix A:")
    public void the_following_4x4_matrix_a(io.cucumber.datatable.DataTable dataTable) {
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

    @Then("submatrix\\(A, {int}, {int}) is the following 3x3 matrix:")
    public void submatrix_a_is_the_following_3x3_matrix(Integer int1, Integer int2, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        Matrix expected = new Matrix(3);
        expected.setData(data);
        assertTrue(a.submatrix(int1,int2).equals(expected) );
    }

    @Given("B ← submatrix\\(A, {int}, {int})")
    public void b_submatrix_a(Integer int1, Integer int2) {
        b = a.submatrix(int1,int2);
    }

    @Then("determinant\\(B) = {int}")
    public void determinant_b(Integer int1) {
        assertEquals(b.determinant(), (double) int1, 0.00001);
    }

    @Then("minor\\(A, {int}, {int}) = {int}")
    public void minor_a(Integer int1, Integer int2, Integer int3) {
        assertEquals(a.minor(int1,int2), (double) int3, 0.00001);
    }

    @Then("cofactor\\(A, {int}, {int}) = {int}")
    public void cofactor_a(Integer int1, Integer int2, Integer int3) {
        assertEquals(a.cofactor(int1,int2), (double) int3, 0.00001);
    }

    @Then("A is invertible")
    public void a_is_invertible() {
        assertTrue(a.isInvertible());
    }

    @Then("A is not invertible")
    public void a_is_not_invertible() {
        try {
            a.inverse();
        } catch (InverseException e) {

        }
        assertFalse(a.isInvertible());
    }

    @Given("B ← inverse\\(A)")
    public void b_inverse_a() {
        b = a.inverse();
    }

    @Then("B[3,2] = {int}\\/{int}")
    public void b32(Integer int1, Integer int2) {
        assertEquals(b.get(3,2), (double)int1/(double)int2, 0.00001);
    }

    @Then("B[2,3] = {int}\\/{int}")
    public void b23(Integer int1, Integer int2) {
        assertEquals(b.get(2,3), (double)int1/(double)int2, 0.00001);
    }

    @Then("B is the following 4x4 matrix:")
    public void b_is_the_following_4x4_matrix(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        Matrix expected = new Matrix(4);
        expected.setData(data);
        assertTrue(b.equals(expected) );
    }

    @Then("inverse\\(A) is the following 4x4 matrix:")
    public void inverse_a_is_the_following_4x4_matrix(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<Double>> data = dataTable.asLists(Double.TYPE);
        Matrix expected = new Matrix(4);
        expected.setData(data);
        assertTrue(a.inverse().equals(expected));
    }

    @Given("the following 4x4 matrix B:")
    public void the_following_4x4_matrix_b(io.cucumber.datatable.DataTable dataTable) {
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

    @Given("C ← A mul B")
    public void c_a_mul_b() {
        c = Matrix.multiply(a,b);
    }

    @Then("C mul inverse\\(B) = A")
    public void c_mul_inverse_b_a() {
        Matrix temp = Matrix.multiply(c,b.inverse());
        assertTrue(temp.equals(a));
    }

    Tuple mp;
    Matrix mtransform;
    @Given("mp ← point\\({int}, {int}, {int})")
    public void mp_point(Integer int1, Integer int2, Integer int3) {
        mp = Tuple.point(int1,int2,int3);
    }

    @Given("mtransform ← translation\\({int}, {int}, {int})")
    public void mtransform_translation(Integer int1, Integer int2, Integer int3) {
        mtransform = Matrix.translation(int1,int2,int3);
    }

    @Then("mtransform * mp = point\\({int}, {int}, {int})")
    public void mtransform_mp_point(Integer int1, Integer int2, Integer int3) {
        Tuple mul = Matrix.multiply(mtransform,mp);
        assertTrue(mul.equals(Tuple.point(int1,int2,int3)));
    }

    Matrix inv;
    @Given("inv ← inverse\\(mtransform)")
    public void inv_inverse_mtransform() {
        inv = mtransform.inverse();
    }

    @Then("inv * mp = point\\({int}, {int}, {int})")
    public void inv_mp_point(Integer int1, Integer int2, Integer int3) {
        assertTrue(Matrix.multiply(inv,mp).equals(Tuple.point(int1,int2,int3)));
    }

    Tuple mv;
    @Given("mv ← vector\\({int}, {int}, {int})")
    public void mv_vector(Integer int1, Integer int2, Integer int3) {
        mv = Tuple.vector(int1,int2,int3);
    }

    @Then("mtransform * mv = mv")
    public void mtransform_mv_mv() {
        assertTrue(Matrix.multiply(mtransform,mv).equals(mv));
    }

    @Given("mtransform ← scaling\\({int}, {int}, {int})")
    public void mtransform_scaling(Integer int1, Integer int2, Integer int3) {
        mtransform = Matrix.scaling(int1,int2,int3);
    }

    @Then("mtransform mul mp = point\\({int}, {int}, {int})")
    public void mtransform_mul_mp_point(Integer int1, Integer int2, Integer int3) {
        assertTrue(Matrix.multiply(mtransform,mp).equals(Tuple.point(int1,int2,int3)));
    }

    @Then("mtransform * mv = vector\\({int}, {int}, {int})")
    public void mtransform_mv_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(Matrix.multiply(mtransform,mv).equals(Tuple.vector(int1,int2,int3)));
    }

    @Then("inv * mv = vector\\({int}, {int}, {int})")
    public void inv_mv_vector(Integer int1, Integer int2, Integer int3) {
        assertTrue(Matrix.multiply(inv,mv).equals(Tuple.vector(int1,int2,int3)));
    }

    Matrix half_quarter;
    @Given("half_quarter ← rotation_x\\(π \\/ {int})")
    public void half_quarter_rotation_x_π(Integer int1) {
        half_quarter = Matrix.rotationX(Math.PI / int1);
    }

    Matrix full_quarter;
    @Given("full_quarter ← rotation_x\\(π \\/ {int})")
    public void full_quarter_rotation_x_π(Integer int1) {
        full_quarter = Matrix.rotationX(Math.PI / int1);
    }

    @Then("half_quarter * mp = point\\({int}, {double}, {double})")
    public void half_quarter_mp_point(Integer int1, Double double1, Double double2) {
        Tuple tp = Tuple.point(int1, double1, double2);
        assertTrue(Matrix.multiply(half_quarter,mp).equals(tp));
    }

    @Given("inv ← inverse\\(half_quarter)")
    public void inv_inverse_half_quarter() {
        inv = half_quarter.inverse();
    }

    @Then("inv mul mp = point\\({double}, {double}, {double})")
    public void inv_mul_mp_point(Double double1, Double double2, Double double3) {
        Tuple tp = Tuple.point(double1, double2, double3);
        Tuple tmp = Matrix.multiply(inv,mp);
        assertTrue(tmp.equals(tp));
    }

    @Given("half_quarter ← rotation_y\\(π \\/ {int})")
    public void half_quarter_rotation_y_π(Integer int1) {
        half_quarter = Matrix.rotationY(Math.PI / int1);
    }

    @Given("full_quarter ← rotation_y\\(π \\/ {int})")
    public void full_quarter_rotation_y_π(Integer int1) {
        full_quarter = Matrix.rotationY(Math.PI / int1);
    }

    @Then("half_quarter mul mp = point\\({double}, {double}, {double})")
    public void half_quarter_mul_mp_point(Double double1, Double double2, Double double3) {
        Tuple tp = Tuple.point(double1, double2, double3);
        Tuple tmp = Matrix.multiply(half_quarter,mp);
        assertTrue(tmp.equals(tp));
    }

    @Then("full_quarter mul mp = point\\({double}, {double}, {double})")
    public void full_quarter_mul_mp_point(Double double1, Double double2, Double double3) {
        Tuple tp = Tuple.point(double1, double2, double3);
        Tuple tmp = Matrix.multiply(full_quarter,mp);
        assertTrue(tmp.equals(tp));
    }

    @Given("half_quarter ← rotation_z\\(π \\/ {int})")
    public void half_quarter_rotation_z_π(Integer int1) {
        half_quarter = Matrix.rotationZ(Math.PI / int1);
    }

    @Given("full_quarter ← rotation_z\\(π \\/ {int})")
    public void full_quarter_rotation_z_π(Integer int1) {
        full_quarter = Matrix.rotationZ(Math.PI / int1);
    }

    @Given("mtransform ← shearing\\({int}, {int}, {int}, {int}, {int}, {int})")
    public void mtransform_shearing(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        mtransform = Matrix.shearing(int1,int2,int3,int4,int5,int6);
    }

}
