package com.codecool.dynamicArrayDojo.stack;

public class StackUnderflowError extends Error {
    public StackUnderflowError() {
    }

    public StackUnderflowError(String message) {
        super(message);
    }
}
