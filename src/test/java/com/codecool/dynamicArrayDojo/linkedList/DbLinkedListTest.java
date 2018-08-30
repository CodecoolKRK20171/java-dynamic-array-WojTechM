package com.codecool.dynamicArrayDojo.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DbLinkedListTest {

    @Test
    void Should_CreateEmptyDbList_When_CalledDefaultConstructor() {
        DbLinkedList list = new DbLinkedList();
        assertEquals(0, list.length);
    }

    @Test
    void Should_CreateDbListWithLength1_When_PassedNodeToConstructor() {
        DoublyLinkedNode newNode = new DoublyLinkedNode(0, null, null);
        DbLinkedList list = new DbLinkedList(newNode);
        assertAll(
                () -> assertEquals(1, list.length),
                () -> assertEquals(newNode, list.head)
        );
    }

    @Test
    void Should_AppendListWithNewNode_When_CalledAddMethod() {
        DoublyLinkedNode firstNode = new DoublyLinkedNode(0, null, null);
        DbLinkedList list = new DbLinkedList(firstNode);
        list.add(1);
        int valueOfLast1 = list.last.value;
        assertAll(
                () -> assertEquals(2, list.length),
                () -> assertEquals(firstNode, list.head),
                () -> assertEquals(1, valueOfLast1)
        );
        list.add(2);
        int valueOfLast2 = list.last.value;
        assertAll(
                () -> assertEquals(3, list.length),
                () -> assertEquals(firstNode, list.head),
                () -> assertEquals(2, valueOfLast2)
        );
    }

    @Test
    void Should_RemoveNodeWithGivenValue_When_CalledRemoveMethod() {
        DoublyLinkedNode firstNode = new DoublyLinkedNode(0, null, null);
        DbLinkedList list = new DbLinkedList(firstNode);
        list.add(3);
        list.add(3);
        list.add(4);
        list.remove(3);

        int valueOfLast = list.last.value;
        assertAll(
                () -> assertEquals(3, list.length),
                () -> assertEquals(firstNode, list.head),
                () -> assertEquals(4, valueOfLast)
        );
    }
}