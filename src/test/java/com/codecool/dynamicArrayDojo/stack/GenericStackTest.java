package com.codecool.dynamicArrayDojo.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    void Should_CreateStackWithGivenSize_When_CalledConstructor() {
        GenericStack<Integer> stack = new GenericStack<>(10);
        assertEquals(10, stack.size());
    }

    @Test
    void Should_AddNewDataOnTop_When_CalledPushMethod() {
        GenericStack<String> stack = new GenericStack<>(10);
        assertEquals(10, stack.freeSpace());
        stack.push("Hello");
        stack.push("World");
        assertEquals(8, stack.freeSpace());
    }

    @Test
    void Should_RemoveAndReturnTopmostData_When_CalledPopMethod() {
        GenericStack<Float> stack = new GenericStack<>(10);
        stack.push(5f);
        float returnedValue = stack.pop();
        assertEquals(5f, returnedValue);
        assertEquals(10, stack.freeSpace());
    }

    @Test
    void Should_ReturnTopmostDataWithoutRemovingIt_When_CalledPeekMethod() {
        GenericStack<Double> stack = new GenericStack<>(10);
        stack.push(5d);
        double returnedValue = stack.peek();
        assertEquals(5f, returnedValue);
        assertEquals(9, stack.freeSpace());
    }
}