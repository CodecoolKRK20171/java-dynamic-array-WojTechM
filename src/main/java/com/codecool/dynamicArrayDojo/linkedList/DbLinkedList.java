package com.codecool.dynamicArrayDojo.linkedList;

public class DbLinkedList {

    public DoublyLinkedNode head;
    public DoublyLinkedNode last;
    public int length;

    public DbLinkedList() {
        this.head = null;
        this.last = null;
        this.length = 0;
    }

    public DbLinkedList(DoublyLinkedNode head) {
        this.head = head;
        this.last = null;
        this.length = 1;
    }

    public void add(Integer n) {
        if (this.last != null) {
            this.last = insertNewNode(n, this.last, null);
        } else if (this.head == null) {
            this.head = insertNewNode(n, null, null);
        } else {
            this.last = insertNewNode(n, this.head, null);
        }
        this.length++;
    }

    private DoublyLinkedNode insertNewNode(Integer data, DoublyLinkedNode previous, DoublyLinkedNode next) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data, previous, next);
        if (previous != null) {
            previous.next = newNode;
        }
        if (next != null) {
            next.previous = newNode;
        }
        return newNode;
    }

    public void remove(Integer n) {
        DoublyLinkedNode node = this.head;
        while (node != null && node.value != n) {
            node = node.next;
        }
        if (node != null && node.value == n) {
            this.length--;
            if (node == this.last) {
                this.last = node.previous;
                this.last.next = null;
            } else {
                removeNode(node);
            }
        }
    }

    public void removeNode(DoublyLinkedNode node) {
        node.previous.next = node.next.previous;
    }
}
