package com.codecool.dynamicArrayDojo.linkedList;

import java.util.List;

public class SinglyLinkedList {

    public SinglyLinkedNode head = null;
    public SinglyLinkedNode last = null;
    public int length = 0;

    public SinglyLinkedList() {}
    public SinglyLinkedList(SinglyLinkedNode head) {
        this.head = head;
        this.length = 1;

        if (head.next != null) {
            this.last = head.next;
            this.length++;

            while(this.last.next != null) {
                this.last = this.last.next;
                this.length++;
            }
        }
    }

    public SinglyLinkedList(List<Integer> list) {
        this.head = new SinglyLinkedNode(list.get(0), null);
        SinglyLinkedNode node = head;
        for(int i = 1; i < list.size(); i++) {
            node = extendList(node, list.get(i));
        }
        this.last = node;
        length = list.size();
    }

    public void add(Integer n) {
        this.last = extendList(this.last, n);
        this.length++;
    }

    public void remove(Integer n) {
        SinglyLinkedNode node = this.head;
        if (this.head.value == n) {
            this.head = this.head.next;
        } else {
            SinglyLinkedNode previous = node;
            if (previous.next != null) {
                node = previous.next;
            }
            while (node.value != n && node.next != null) {
                previous = node;
                node = node.next;
            }

            if (node.value == n) {
                previous.next = node.next;
            }
        }
        this.length--;
    }

    public SinglyLinkedNode extendList(SinglyLinkedNode previous, Integer data) {
        previous.next = new SinglyLinkedNode(data, null);
        return previous.next;
    }
}
