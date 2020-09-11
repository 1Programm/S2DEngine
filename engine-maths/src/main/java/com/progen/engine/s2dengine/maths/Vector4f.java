package com.progen.engine.s2dengine.maths;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Vector4f {

    public static float LengthSqrt(Vector4f v){
        return v.lengthSqrt();
    }

    public static float Length(Vector4f v){
        return (float)(Math.sqrt(LengthSqrt(v)));
    }

    public static Vector4f Normalized(Vector4f v){
        return v.clone().normalize();
    }

    public static float Dot(Vector4f v1, Vector4f v2){
        return v1.dot(v2);
    }

    public static Vector4f Add(Vector4f v, float x, float y, float z, float w){
        return v.clone().add(x, y, z, w);
    }

    public static Vector4f Add(Vector4f v1, Vector4f v2){
        return Add(v1, v2.x, v2.y, v2.z, v2.w);
    }

    public static Vector4f Sub(Vector4f v, float x, float y, float z, float w){
        return v.clone().sub(x, y, z, w);
    }

    public static Vector4f Sub(Vector4f v1, Vector4f v2){
        return Sub(v1, v2.x, v2.y, v2.z, v2.w);
    }

    public static Vector4f Mul(Vector4f v, float x, float y, float z, float w){
        return v.clone().mul(x, y, z, w);
    }

    public static Vector4f Mul(Vector4f v, float m){
        return Mul(v, m, m, m, m);
    }

    public static Vector4f Mul(Vector4f v1, Vector4f v2){
        return Mul(v1, v2.x, v2.y, v2.z, v2.w);
    }

    public static Vector4f Div(Vector4f v, float x, float y, float z, float w){
        return v.clone().div(x, y, z, w);
    }

    public static Vector4f Div(Vector4f v, float d){
        return Div(v, d, d, d, d);
    }

    public static Vector4f Div(Vector4f v1, Vector4f v2){
        return Div(v1, v2.x, v2.y, v2.z, v2.w);
    }




    private float x, y, z, w;

    @Override
    public Vector4f clone(){
        return new Vector4f(x, y, z, w);
    }

    public float lengthSqrt(){
        return x * x + y * y + z * z + w * w;
    }

    public float length(){
        return (float)(Math.sqrt(lengthSqrt()));
    }

    public Vector4f normalize(){
        return div(length());
    }

    public float dot(Vector4f v){
        return
                this.x * v.x +
                this.y * v.y +
                this.z * v.z +
                this.w * v.w;
    }

    public Vector4f set(float x, float y, float z, float w){
        setX(x);
        setY(y);
        setZ(z);
        setW(w);

        return this;
    }

    public Vector4f set(Vector4f v){
        return set(v.x, v.y, v.z, v.w);
    }

    public Vector4f add(float x, float y, float z, float w){
        this.x += x;
        this.y += y;
        this.z += z;
        this.w += w;

        return this;
    }

    public Vector4f add(Vector4f v){
        return add(v.x, v.y, v.z, v.w);
    }

    public Vector4f sub(float x, float y, float z, float w){
        this.x -= x;
        this.y -= y;
        this.z -= z;
        this.w -= w;

        return this;
    }

    public Vector4f sub(Vector4f v){
        return sub(v.x, v.y, v.z, v.w);
    }

    public Vector4f mul(float x, float y, float z, float w){
        this.x *= x;
        this.y *= y;
        this.z *= z;
        this.w *= w;

        return this;
    }

    public Vector4f mul(float m){
        return mul(m, m, m, m);
    }

    public Vector4f mul(Vector4f v){
        return mul(v.x, v.y, v.z, v.w);
    }

    public Vector4f div(float x, float y, float z, float w){
        this.x /= x;
        this.y /= y;
        this.z /= z;
        this.w /= w;

        return this;
    }

    public Vector4f div(float d){
        return div(d, d, d, d);
    }

    public Vector4f div(Vector4f v){
        return div(v.x, v.y, v.z, v.w);
    }
    
}
