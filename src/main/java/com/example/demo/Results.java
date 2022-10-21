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
        private double x;
        private double y;
        private double r;
        private boolean in;

        public CheckResult(){}


        public double getR() {
            return r;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public boolean getIn() {
            return in;
        }

        public void setIn(boolean in) {
            this.in = in;
        }

        public void setR(double r) {
            this.r = r;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }
    }
}
