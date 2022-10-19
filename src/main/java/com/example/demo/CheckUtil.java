package com.example.demo;

public class CheckUtil {

    public static boolean check(float x, float y, float r){
        return checkTriangle(x, y, r) && checkSquare(x, y, r) && checkQuarterCircle(x, y, r);
    }

    private static boolean checkTriangle(float x, float y, float r){
        return x <= 0 && y >= 0 && y <= x + r / 2; //working fine
    }

    private static boolean checkSquare(float x, float y, float r){
        return x >= 0 && y <= 0 && x <= r && y >= -r; //working fine
    }

    private static boolean checkQuarterCircle(float x, float y, float r){
        return x >= 0 && y >= 0 && x * x + y * y <= r * r / 4; // working fine
    }
}
