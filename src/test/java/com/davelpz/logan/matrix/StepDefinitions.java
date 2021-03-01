package com.davelpz.logan.matrix;

import com.davelpz.logan.ray.Intersection;
import com.davelpz.logan.ray.Ray;
import com.davelpz.logan.shapes.Sphere;
import com.davelpz.logan.tuple.Tuple;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static com.davelpz.logan.tuple.Tuple.point;
import static com.davelpz.logan.tuple.Tuple.vector;

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
        } catch (InverseException ignored) { }
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
        c = a.multiply(b);
    }

    @Then("C mul inverse\\(B) = A")
    public void c_mul_inverse_b_a() {
        Matrix temp = c.multiply(b.inverse());
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

    @Given("A ← rotation_x\\(π \\/ {int})")
    public void a_rotation_x_π(Integer int1) {
        a = Matrix.rotationX(Math.PI / int1);
    }

    @Given("B ← scaling\\({int}, {int}, {int})")
    public void b_scaling(Integer int1, Integer int2, Integer int3) {
        b = Matrix.scaling(int1,int2,int3);
    }

    @Given("C ← translation\\({int}, {int}, {int})")
    public void c_translation(Integer int1, Integer int2, Integer int3) {
        c = Matrix.translation(int1,int2,int3);
    }

    Tuple p2,p3,p4;
    @When("p2 ← A * mp")
    public void p2_a_mp() {
        p2 = Matrix.multiply(a,mp);
        p2 = a.multiply(mp);
    }

    @Then("p2 = point\\({int}, {int}, {int})")
    public void p2_point(Integer int1, Integer int2, Integer int3) {
        assertTrue(p2.equals(Tuple.point(int1,int2,int3)));
    }

    @When("p3 ← B * p2")
    public void p3_b_p2() {
        p3 = b.multiply(p2);
    }

    @Then("p3 = point\\({int}, {int}, {int})")
    public void p3_point(Integer int1, Integer int2, Integer int3) {
        assertTrue(p3.equals(Tuple.point(int1,int2,int3)));
    }

    @When("p4 ← C * p3")
    public void p4_c_p3() {
        p4 = c.multiply(p3);
    }

    @Then("p4 = point\\({int}, {int}, {int})")
    public void p4_point(Integer int1, Integer int2, Integer int3) {
        assertTrue(p4.equals(Tuple.point(int1,int2,int3)));
    }

    Matrix t;
    @When("T ← C * B * A")
    public void t_c_b_a() {
        t = c.multiply(b).multiply(a);
    }

    @Then("T * mp = point\\({int}, {int}, {int})")
    public void t_mp_point(Integer int1, Integer int2, Integer int3) {
        Tuple tp = Tuple.point(int1,int2,int3);
        Tuple tmp = Matrix.multiply(t,mp);
        assertTrue(tmp.equals(tp));
    }

    /*
     *
     * Rays.feature
     *
     */

    Tuple origin, direction;
    Ray r;
    @Given("origin ← point\\({double}, {double}, {double})")
    public void origin_point(Double double1, Double double2, Double double3) {
        origin = point(double1,double2,double3);
    }

    @Given("direction ← vector\\({double}, {double}, {double})")
    public void direction_vector(Double double1, Double double2, Double double3) {
        direction = vector(double1,double2,double3);
    }

    @When("r ← ray\\(origin, direction)")
    public void r_ray_origin_direction() {
        r = new Ray(origin,direction);
    }

    @Then("r.origin = origin")
    public void r_origin_origin() {
        assertTrue(r.origin.equals(origin));
    }

    @Then("r.direction = direction")
    public void r_direction_direction() {
        assertTrue(r.direction.equals(direction));
    }

    @Given("r ← ray\\(point-{int}-{int}-{int}, vector-{int}-{int}-{int})")
    public void r_ray_point_vector(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        r = new Ray(point(int1,int2,int3),vector(int4,int5,int6));
    }

    @Then("position\\(r, {double}) = point\\({double}, {double}, {double})")
    public void position_r_point(Double double1, Double double2, Double double3, Double double4) {
        Tuple t = r.position(double1);
        Tuple p = point(double2,double3,double4);
        assertTrue(t.equals(p));
    }

    @Given("m ← translation\\({int}, {int}, {int})")
    public void m_translation(Integer int1, Integer int2, Integer int3) {
        m = Matrix.translation(int1,int2,int3);
    }

    Ray r2;
    @When("r2 ← transform\\(r, m)")
    public void r2_transform_r_m() {
        r2 = r.transform(m);
    }

    @Then("r2.origin = point\\({int}, {int}, {int})")
    public void r2_origin_point(Integer int1, Integer int2, Integer int3) {
        Tuple t = point(int1,int2,int3);
        assertTrue(r2.origin.equals(t));
    }

    @Then("r2.direction = vector\\({int}, {int}, {int})")
    public void r2_direction_vector(Integer int1, Integer int2, Integer int3) {
        Tuple t = vector(int1,int2,int3);
        assertTrue(r2.direction.equals(t));
    }

    @Given("m ← scaling\\({int}, {int}, {int})")
    public void m_scaling(Integer int1, Integer int2, Integer int3) {
        m = Matrix.scaling(int1,int2,int3);
    }

    Sphere s;
    @Given("s ← sphere")
    public void s_sphere() {
        s = new Sphere();
    }

    Intersection[] xs;
    @When("xs ← intersect\\(s, r)")
    public void xs_intersect_s_r() {
        xs = r.intersects(s);
    }

    @Then("xs.count = {int}")
    public void xs_count(Integer int1) {
        assertTrue(int1 == xs.length);
    }

    @Then("xs[{int}] = {double}")
    public void xs(Integer int1, Double double1) {
        assertTrue(xs[int1].t == double1);
    }

    @Then("xs[{int}].object = s")
    public void xs_object_s(Integer int1) {
        assertTrue(xs[int1].object.equals(s));
    }

    Intersection i;
    @When("i ← intersection\\({double}, s)")
    public void i_intersection_s(Double double1) {
        i = new Intersection(double1,s);
    }

    @Then("i.t = {double}")
    public void i_t(Double double1) {
        assertTrue(i.t == double1);
    }

    @Then("i.object = s")
    public void i_object_s() {
        assertTrue(i.object.equals(s));
    }

    Intersection i1,i2;
    @Given("i1 ← intersection\\({int}, s)")
    public void i1_intersection_s(Integer int1) {
        i1 = new Intersection(int1,s);
    }

    @Given("i2 ← intersection\\({int}, s)")
    public void i2_intersection_s(Integer int1) {
        i2 = new Intersection(int1,s);
    }

    @When("xs ← intersections\\(i1, i2)")
    public void xs_intersections_i1_i2() {
        xs = Intersection.intersections(i1,i2);
    }

    @Then("xs[{int}].t = {int}")
    public void xs_t(Integer int1, Integer int2) {
        assertTrue(xs[int1].t == int2);
    }

    @Given("xs ← intersections\\(i2, i1)")
    public void xs_intersections_i2_i1() {
        xs = Intersection.intersections(i2,i1);
    }

    @When("i ← hit\\(xs)")
    public void i_hit_xs() {
        Optional<Intersection> ti = Intersection.hit(xs);
        if (ti.isPresent()) {
            i = ti.get();
        } else {
            i = null;
        }
    }

    @Then("i = i1")
    public void i_i1() {
        assertTrue(i.equals(i1));
    }

    @Then("i = i2")
    public void i_i2() {
        assertTrue(i.equals(i2));
    }

    @Then("i is nothing")
    public void i_is_nothing() {
        assertNull(i);
    }

    Intersection i3,i4;
    @Given("i3 ← intersection\\({int}, s)")
    public void i3_intersection_s(Integer int1) {
        i3 = new Intersection(int1,s);
    }

    @Given("i4 ← intersection\\({int}, s)")
    public void i4_intersection_s(Integer int1) {
        i4 = new Intersection(int1,s);
    }

    @Given("xs ← intersections\\(i1, i2, i3, i4)")
    public void xs_intersections_i1_i2_i3_i4() {
        xs = Intersection.intersections(i1,i2,i3,i4);
    }

    @Then("i = i4")
    public void i_i4() {
        assertTrue(i.equals(i4));
    }

    @Then("s.transform = identity_matrix")
    public void s_transform_identity_matrix() {
        assertTrue(s.getTransform().equals(Matrix.identity4));
    }

    @Given("t ← translation\\({int}, {int}, {int})")
    public void t_translation(Integer int1, Integer int2, Integer int3) {
        t = Matrix.translation(int1,int2,int3);
    }

    @When("set_transform\\(s, t)")
    public void set_transform_s_t() {
        s.setTransform(t);
    }

    @Then("s.transform = t")
    public void s_transform_t() {
        assertTrue(s.getTransform().equals(t));
    }

}
