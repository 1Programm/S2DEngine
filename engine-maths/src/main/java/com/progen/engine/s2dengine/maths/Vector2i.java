package com.progen.engine.s2dengine.maths;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vector2i {

    public static float LengthSqrt(Vector2i v){
        return v.x * v.x + v.y * v.y;
    }

    public static float Length(Vector2i v){
        return (float)(Math.sqrt(LengthSqrt(v)));
    }

    public static Vector2i Normalized(Vector2i v){
        return v.clone().normalize();
    }

    public static float Dot(Vector2i v1, Vector2i v2){
        return v1.dot(v2);
    }

    public static Vector2i Add(Vector2i v, int x, int y){
        return v.clone().add(x, y);
    }

    public static Vector2i Add(Vector2i v1, Vector2i v2){
        return Add(v1, v2.x, v2.y);
    }

    public static Vector2i Sub(Vector2i v, int x, int y){
        return v.clone().sub(x, y);
    }

    public static Vector2i Sub(Vector2i v1, Vector2i v2){
        return Sub(v1, v2.x, v2.y);
    }

    public static Vector2i Mul(Vector2i v, float x, float y){
        return v.clone().mul(x, y);
    }

    public static Vector2i Mul(Vector2i v, float m){
        return Mul(v, m, m);
    }

    public static Vector2i Mul(Vector2i v1, Vector2i v2){
        return Mul(v1, v2.x, v2.y);
    }

    public static Vector2i Div(Vector2i v, float x, float y){
        return v.clone().div(x, y);
    }

    public static Vector2i Div(Vector2i v, float d){
        return Div(v, d, d);
    }

    public static Vector2i Div(Vector2i v1, Vector2i v2){
        return Div(v1, v2.x, v2.y);
    }




    private int x, y;

    @Override
    public Vector2i clone(){
        return new Vector2i(x, y);
    }

    public int lengthSqrt(){
        return x * x + y * y;
    }

    public float length(){
        return (float)(Math.sqrt(lengthSqrt()));
    }

    public Vector2i normalize(){
        return div(length());
    }

    public int dot(Vector2i v){
        return this.x * v.x + this.y * v.y;
    }

    public Vector2i set(int x, int y){
        setX(x);
        setY(y);

        return this;
    }

    public Vector2i set(Vector2i v){
        return set(v.x, v.y);
    }

    public Vector2i add(int x, int y){
        this.x += x;
        this.y += y;

        return this;
    }

    public Vector2i add(Vector2i v){
        return add(v.x, v.y);
    }

    public Vector2i sub(int x, int y){
        this.x -= x;
        this.y -= y;

        return this;
    }

    public Vector2i sub(Vector2i v){
        return sub(v.x, v.y);
    }

    public Vector2i mul(float x, float y){
        this.x *= x;
        this.y *= y;

        return this;
    }

    public Vector2i mul(float m){
        return mul(m, m);
    }

    public Vector2i mul(Vector2i v){
        return mul(v.x, v.y);
    }

    public Vector2i div(float x, float y){
        this.x /= x;
        this.y /= y;

        return this;
    }

    public Vector2i div(float d){
        return div(d, d);
    }

    public Vector2i div(Vector2i v){
        return div(v.x, v.y);
    }

    @Override
    public String toString() {
        return "Vec2i[" + x + ", " + y + "]";
    }
}
