package com.codecool.dynamicArrayDojo.queue;

public class Node {
    private String value;
    private Node nextNode;
    private int priority;

    public Node(String value){
        this.value = value;
        this.priority = 1;
    }

    public Node(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue(){
        return this.value;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", priority=" + priority +
                '}';
    }
}
