package com.codecool.dynamicArrayDojo.linkedList;

import java.util.Objects;

public class DoublyLinkedNode {
    public Integer value;
    public DoublyLinkedNode previous;
    public DoublyLinkedNode next;

    public DoublyLinkedNode(Integer value, DoublyLinkedNode previous, DoublyLinkedNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedNode that = (DoublyLinkedNode) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(previous, that.previous) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, previous, next);
    }

    @Override
    public String toString() {
        return "DoublyLinkedNode{" +
                "value=" + value +
                ", previous=" + (previous != null) +
                ", next=" + (next != null) +
                '}';
    }
}
