package com.example.demo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Results {
    private final List<checkResult> results = new LinkedList<>();

    public List<checkResult> getResults() {
        return results;
    }

    public void addCheckResult(checkResult result){
        results.add(result);
    }

    public static class checkResult implements Serializable {
        private float x;
        private float y;
        private float r;
        private String in;

        public checkResult(){};


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
