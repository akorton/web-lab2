package com.example.demo;

import java.util.LinkedList;
import java.util.List;

public class Results {
    private final List<checkResult> results;

    public Results(){
        results = new LinkedList<>();
    }

    public List<checkResult> getResults() {
        return results;
    }

    public void addCheckResult(checkResult result){
        results.add(result);
    }

    public static class checkResult{
        private final float x;
        private final float y;
        private final float r;
        private final String in;

        public checkResult(float x, float y, float r, String in){
            this.x = x;
            this.y = y;
            this.r = r;
            this.in = in;
        }

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
    }
}
