package com.codecool.dynamicArrayDojo.linkedList;

import java.util.Objects;

public class SinglyLinkedNode {
    public int value;
    public SinglyLinkedNode next;

    public SinglyLinkedNode(int value, SinglyLinkedNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedNode that = (SinglyLinkedNode) o;
        return value == that.value &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        if (next != null)
            return value + ". Next: " + next.hashCode();
        return value + ". Next: null";
    }
}
