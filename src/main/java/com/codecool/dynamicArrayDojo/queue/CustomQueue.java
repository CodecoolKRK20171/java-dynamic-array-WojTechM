package com.codecool.dynamicArrayDojo.queue;

public class CustomQueue {

    private Node head;
    private Node tail;
    private int queueSize = 0;

    public void enqueue(String toAdd) {
        Node newNode = new Node(toAdd);
        if (this.head == null) {
            this.head = newNode;
        } else if (queueSize == 1) {
            this.tail = newNode;
            this.head.setNextNode(this.tail);
        } else {
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
        queueSize++;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }

        queueSize--;
        if (this.head.getNextNode() == null) {
            Node toReturn = this.head;
            this.head = null;
            return toReturn.getValue();
        } else {
            Node toReturn = this.head;
            this.head = toReturn.getNextNode();
            return toReturn.getValue();
        }
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return this.head.getValue();
    }

    public int queueSize() {
        return queueSize;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }
}
