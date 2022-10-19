package com.example.demo;

import com.sun.tools.javac.comp.Check;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Results {
    private static final List<CheckResult> results = new LinkedList<>();

    public static List<CheckResult> getResults() {
        return results;
    }

    public static void addCheckResult(CheckResult result){
        results.add(result);
    }

    public static class CheckResult implements Serializable {
        private float x;
        private float y;
        private float r;
        private String in;

        public CheckResult(){}


        public float getR() {
            return r;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public String getIn() {
            return in;
        }

        public void setIn(String in) {
            this.in = in;
        }

        public void setR(float r) {
            this.r = r;
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }
    }
}
