package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {

    private final int DEFAULT_SIZE = 0;
    private Integer[] content;
    public DynamicIntArray(int size) {
        content = new Integer[size];
    }

    public DynamicIntArray() {
        content = new Integer[DEFAULT_SIZE];
    }

    public void add(int n) {
        insert(content.length, n);
    }

    public void remove(int index) {
        Integer[] contentCopy = new Integer[content.length - 1];
        for(int i = 0; i < index; i++) {
            contentCopy[i] = content[i];
        }
        for(int i = index; i < contentCopy.length; i++) {
            contentCopy[i] = content[i + 1];
        }
        content = contentCopy;
    }

    public void insert(int index, int n) {
        if(index < content.length + 1) {
            insertInMiddle(index, n);
        } else {
            extendArray(index, n);
        }
    }

    private void insertInMiddle(int index, int n) {
        Integer[] contentCopy = new Integer[content.length + 1];
        for(int i = 0; i < index; i++) {
            contentCopy[i] = content[i];
        }
        contentCopy[index] = n;
        for(int i = index + 1; i < contentCopy.length; i++) {
            contentCopy[i] = content[i - 1];
        }
        content = contentCopy;
    }

    private void extendArray(int index, int n) {
        Integer[] contentCopy = new Integer[index + 1];
        for (int i = 0; i < content.length; i++) {
            contentCopy[i] = content[i];
        }
        contentCopy[index] = n;
        content = contentCopy;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Integer n : content) {
            if (n != null) {
                sb.append(" " + n);
            }
        }
        return sb.toString();
    }
}
