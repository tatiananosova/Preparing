package com.interview.preparing.homework1;

public abstract class Shape {
    protected abstract String getShape();
    public void draw() {
        System.out.println(getShape());
    }
}
