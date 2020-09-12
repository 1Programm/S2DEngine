package com.progen.engine.s2dengine.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorTests {

    private void assertVectorEquals(Vector2f v1, Vector2f v2, String message){
        assertEquals(v1.getX(), v2.getX(), message);
        assertEquals(v1.getY(), v2.getY(), message);
    }

    private void assertVectorEquals(Vector2i v1, Vector2i v2, String message){
        assertEquals(v1.getX(), v2.getX(), message);
        assertEquals(v1.getY(), v2.getY(), message);
    }

    private void assertVectorEquals(Vector3f v1, Vector3f v2, String message){
        assertEquals(v1.getX(), v2.getX(), message);
        assertEquals(v1.getY(), v2.getY(), message);
        assertEquals(v1.getZ(), v2.getZ(), message);
    }

    private void assertVectorEquals(Vector4f v1, Vector4f v2, String message){
        assertEquals(v1.getX(), v2.getX(), message);
        assertEquals(v1.getY(), v2.getY(), message);
        assertEquals(v1.getZ(), v2.getZ(), message);
        assertEquals(v1.getW(), v2.getW(), message);
    }

    private void assertVectorEquals(Vectorf v1, Vectorf v2, String message){
        assertArrayEquals(v1.getData(), v2.getData(), message);
    }

    @Test
    public void vectorCloningTest(){
        Vector2f v1 = new Vector2f(10.5f, 5.7f);
        Vector2f v2 = v1.clone();

        assertVectorEquals(v1, v2, "Cloning vec2f values");


        Vector2i v3 = new Vector2i(10, 5);
        Vector2i v4 = v3.clone();

        assertVectorEquals(v3, v4, "Cloning vec2i values");


        Vector3f v5 = new Vector3f(10.5f, 5.7f, 4.9f);
        Vector3f v6 = v5.clone();

        assertVectorEquals(v5, v6, "Cloning vec3f values");


        Vector4f v7 = new Vector4f(10.5f, 5.7f, 4.9f, -200.6f);
        Vector4f v8 = v7.clone();

        assertVectorEquals(v7, v8, "Cloning vec4f values");


        Vectorf v9 = new Vectorf(10.5f, 5.7f, 4.9f, -200.6f, 10.3f, -30.9f, 0.0001f, -200321.2f);
        Vectorf v10 = v9.clone();

        assertVectorEquals(v9, v10, "Cloning vecf array data");
    }

    @Test
    public void vectorAddingTest(){
        Vector2f v1 = new Vector2f(0.5f, -2.5f);
        Vector2f v2 = new Vector2f(1.5f, 10);

        assertEquals(v2.getX(), 1.5f);
        assertEquals(v2.getY(), 10);

        v2.add(v1);

        assertEquals(v2.getX(), 2);
        assertEquals(v2.getY(), 7.5f);
    }

    @Test
    public void vectorSubtractingTest(){
        Vector2f v1 = new Vector2f(5, 10);
        Vector2f v2 = new Vector2f(10, 20);

        assertEquals(v2.getX(), 10);
        assertEquals(v2.getY(), 20);

        v2.sub(v1);

        assertEquals(v2.getX(), 5);
        assertEquals(v2.getY(), 10);
    }

}
