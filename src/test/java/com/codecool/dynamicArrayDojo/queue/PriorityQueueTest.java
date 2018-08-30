package com.codecool.dynamicArrayDojo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    void Should_CreateEmptyQueue_When_CalledConstructor() {
        PriorityQueue queue = new PriorityQueue();
        assertEquals(0, queue.queueSize());
        assertEquals(true, queue.isEmpty());
    }

    @Test
    void Should_AppendNodesToQueue_When_CalledEnqueueMethod() {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue("Hello");
        queue.enqueue("World");

        assertEquals(2, queue.queueSize());
        assertEquals(false, queue.isEmpty());
    }

    @Test
    void Should_RemoveAndReturnLastValueFromQueue_When_CalledDequeueMethod() {
        PriorityQueue queue = new PriorityQueue();
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
        PriorityQueue queue = new PriorityQueue();
        String peekResult = queue.peek();
        String dequeueResult = queue.dequeue();
        assertEquals(null, peekResult);
        assertEquals(null, dequeueResult);
    }

    @Test
    void Should_ReturnLastValueFromQueue_When_CalledPeekMethod() {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue("Hello");
        queue.enqueue("World");

        String expected = "Hello";
        String actual = queue.peek();

        assertEquals(2, queue.queueSize());
        assertFalse(queue.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    void Should_InsertNodesAtValidPositions_When_AddedNodesWithPriority() {
        Node node1 = new Node("1", 1);
        Node node2 = new Node("2", 2);
        Node node3 = new Node("3", 3);
        Node node4 = new Node("4", 4);
        Node node5 = new Node("1", 1);
        Node node6 = new Node("2", 2);
        Node node7 = new Node("3", 3);
        Node node8 = new Node("4", 4);

        PriorityQueue queue = new PriorityQueue();
        // 2 nodes of each type in random order
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        queue.enqueue(node4);
        queue.enqueue(node5);
        queue.enqueue(node6);
        queue.enqueue(node7);
        queue.enqueue(node8);

        assertAll(
                () -> assertEquals("4", queue.dequeue()),
                () -> assertEquals("4", queue.dequeue()),
                () -> assertEquals("3", queue.dequeue()),
                () -> assertEquals("3", queue.dequeue()),
                () -> assertEquals("2", queue.dequeue()),
                () -> assertEquals("2", queue.dequeue()),
                () -> assertEquals("1", queue.dequeue()),
                () -> assertEquals("1", queue.dequeue())
        );
    }
}