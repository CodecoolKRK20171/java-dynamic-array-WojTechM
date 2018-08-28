package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {

    private int[] content;

    public DynamicIntArray(int size) {
        content = new int[size];
        for (int i = 0; i < size; i++) {
            content[i] = i;
        }
    }
}
