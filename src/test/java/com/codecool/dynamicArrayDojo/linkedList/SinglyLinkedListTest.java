package com.codecool.dynamicArrayDojo.linkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void Should_CreateEmptyList_When_CalledDefaultConstructor() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertEquals(null, list.head);
    }

    @Test
    void Should_CreateListOfNodes_When_PassedIntegerListToConstructor() {
        List<Integer> testData = getTestData();

        SinglyLinkedNode node3 = new SinglyLinkedNode(5, null);
        SinglyLinkedNode node2 = new SinglyLinkedNode(3, node3);
        SinglyLinkedNode node1 = new SinglyLinkedNode(1, node2);
        int expectedLength = 3;


        SinglyLinkedList list = new SinglyLinkedList(testData);
        assertAll(
                () -> assertEquals(node1, list.head),
                () -> assertEquals(node3, list.last),
                () -> assertEquals(expectedLength, list.length)
        );
    }

    @Test
    void Should_AppendNewNodeToList_When_PassedIntegerToAddMethod() {
        List<Integer> testData = getTestData();

        SinglyLinkedNode expectedLastNode = new SinglyLinkedNode(4, null);
        int expectedLength = 4;
        SinglyLinkedList list = new SinglyLinkedList(testData);
        list.add(4);
        assertAll(
                () -> assertEquals(expectedLastNode, list.last),
                () -> assertEquals(expectedLength, list.length)
        );
    }

    List<Integer> getTestData() {
        List<Integer> testData = new ArrayList<>();
        testData.add(1);
        testData.add(3);
        testData.add(5);
        return testData;
    }

    @Test
    void Should_RemoveNodeWithGivenValue_When_PassedIntegerToRemoveMethod() {
        SinglyLinkedList list = new SinglyLinkedList(getTestData());
        list.remove(3);

        int expectedLength = 2;
        SinglyLinkedNode expectedNode2 = new SinglyLinkedNode(5, null);
        SinglyLinkedNode expectedNode1 = new SinglyLinkedNode(1, expectedNode2);

        assertAll(
                () -> assertEquals(expectedLength, list.length),
                () -> assertEquals(expectedNode2, list.last),
                () -> assertEquals(expectedNode1, list.head)
        );
    }
}