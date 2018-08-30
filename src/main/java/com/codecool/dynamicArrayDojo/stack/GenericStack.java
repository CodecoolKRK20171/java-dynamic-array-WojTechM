package com.codecool.dynamicArrayDojo.stack;

public class GenericStack<E> {

    private Object[] content;
    private int pointer = -1;

    public GenericStack(int size) {
        content = new Object[size];
    }

    public void push(E obj) throws StackOverflowError {
        checkForOverflow();
        pointer++;
        content[pointer] = obj;
    }

    public E pop() {
        checkForUnderflow();
        E toReturn = (E) content[pointer];
        content[pointer] = null;
        pointer--;
        return toReturn;
    }

    public E peek() {
        checkForOverflow();
        checkForUnderflow();
        return (E) content[pointer];
    }

    public int size() {
        return content.length;
    }

    public int freeSpace() {
        return size() - 1 - pointer;
    }

    private void checkForOverflow() {
        if (pointer + 1 > content.length) {
            throw new StackOverflowError("Invalid action.");
        }
    }

    private void checkForUnderflow() {
        if (pointer - 1 > content.length) {
            throw new StackUnderflowError("Invalid action.");
        }
    }
}
