package com.example.demo;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Results {
    private static final List <CheckResult> results = Collections.synchronizedList(new LinkedList<>());

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
        private boolean in;

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

        public boolean getIn() {
            return in;
        }

        public void setIn(boolean in) {
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
