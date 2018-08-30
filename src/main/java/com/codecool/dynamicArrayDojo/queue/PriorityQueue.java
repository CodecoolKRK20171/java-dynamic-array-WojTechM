package com.codecool.dynamicArrayDojo.queue;

public class PriorityQueue {

    private Node head;
    private Node tail;
    private int queueSize = 0;

    public void enqueue(String toAdd) {
        Node newNode = new Node(toAdd);
        enqueue(newNode);
    }

    public void enqueue(String toAdd, int priority) {
        Node newNode = new Node(toAdd, priority);
        enqueue(newNode);
    }

    public void enqueue(Node newNode) {
        if (this.head == null) {
            this.head = newNode;
        } else if (queueSize == 1) {
            if (head.getPriority() >= newNode.getPriority()) {
                this.tail = newNode;
                this.head.setNextNode(this.tail);
            } else {
                this.tail = this.head;
                this.head = newNode;
                this.head.setNextNode(this.tail);
            }
        } else {
            try {
                insertAtValidPosition(newNode);
            } catch (NullPointerException e) {
                this.tail.setNextNode(newNode);
                this.tail = newNode;

            }
        }
        queueSize++;
    }

    private void insertAtValidPosition(Node node) {
        if (node.getPriority() > this.head.getPriority()) {
            node.setNextNode(this.head);
            this.head = node;
        } else {
            Node currentNode = this.head;
            while (node.getPriority() < currentNode.getNextNode().getPriority()) {
                currentNode = currentNode.getNextNode();
            }
            node.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(node);
        }
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
