package com.codecool.dynamicArrayDojo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {


    @Test
    void Should_CreateEmptyQueue_When_CalledConstructor() {
        CustomQueue queue = new CustomQueue();
        assertEquals(0, queue.queueSize());
        assertEquals(true, queue.isEmpty());
    }

    @Test
    void Should_AppendNodesToQueue_When_CalledEnqueueMethod() {
        CustomQueue queue = new CustomQueue();
        queue.enqueue("Hello");
        queue.enqueue("World");

        assertEquals(2, queue.queueSize());
        assertEquals(false, queue.isEmpty());
    }

    @Test
    void Should_RemoveAndReturnLastValueFromQueue_When_CalledDequeueMethod() {
        CustomQueue queue = new CustomQueue();
        queue.enqueue("Hello");
        queue.enqueue("World");

        String expected = "Hello";
        String actual = queue.dequeue();

        assertEquals(1, queue.queueSize());
        assertEquals(false, queue.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnNull_When_CalledPeekOrDequeueMethod() {
        CustomQueue queue = new CustomQueue();
        String peekResult = queue.peek();
        String dequeueResult = queue.dequeue();
        assertEquals(null, peekResult);
        assertEquals(null, dequeueResult);
    }

    @Test
    void Should_ReturnLastValueFromQueue_When_CalledPeekMethod() {
        CustomQueue queue = new CustomQueue();
        queue.enqueue("Hello");
        queue.enqueue("World");

        String expected = "Hello";
        String actual = queue.peek();

        assertEquals(2, queue.queueSize());
        assertEquals(false, queue.isEmpty());
        assertEquals(expected, actual);
    }
}