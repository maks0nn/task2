package com.company;

public class MyLinkedList {

    private class Node {
        private Node next;
        private int number;

        public Node(int number) {
            this.number = number;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public int get(int index) throws IndexOutOfBoundsException{
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Node cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.number;
    }


    public int getLast() {
        return tail.number;
    }

    public int getFirst() {
        return head.number;
    }

    private Node getHead() {
        return head;
    }
    private Node getTail() {
        return tail;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int number) {
        Node n = new Node(number);
        if (isEmpty()) {
            head = tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
        size++;
    }


    private Node getNode(int index) throws IndexOutOfBoundsException{// Не используется нигде кроме removeAt
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Node cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public MyLinkedList removeAt(int index) {
        // Нигде не используется, просто для копирования функционала всторенного листа
        if (index == 0) {
            head = head.next;
            size--;
            return this;
        }
        if (index == size-1) {
            tail = getNode(index - 1);
            tail.next = null;
            size--;
            return this;
        }
        getNode(index - 1).next = getNode(index + 1);
        size--;
        return this;
    }

    public int size(){
        return size;
    }

    public static MyLinkedList joinSortedMyLists(MyLinkedList list1, MyLinkedList list2){
        if (list1.size == 0){
            return list2;
        }
        if (list2.size == 0){
            return list1;
        }
        MyLinkedList listRes = new MyLinkedList();
        //list1.head = list1.head.next;
        //list2.head = list2.head.next;
        if (list1.head.number > list2.head.number){
            listRes.head = list2.head;
            listRes.tail = list2.head;
            list2.head = list2.head.next;
        }else{
            listRes.head = list1.head;
            listRes.tail = list1.head;
            list1.head = list1.head.next;
        }
        while (list1.head != null && list2.head != null){
            if (list1.head.number > list2.head.number){
                listRes.tail.next = list2.head;
                listRes.tail = list2.head;
                list2.head = list2.head.next;
            }else{
                listRes.tail.next = list1.head;
                listRes.tail = list1.head;
                list1.head = list1.head.next;
            }
        }
        if (list1.head == null){
            listRes.tail.next = list2.head;
            listRes.tail = list2.head;
        }else {
            listRes.tail.next = list1.head;
            listRes.tail = list1.head;
        }
        listRes.size = list1.size + list2.size;
        //list1 = null;
        //list2 = null;
        return listRes;
    }
    public boolean isSorted(){
        Node curr = head;
        while (curr.next != null){
            if (curr.number > curr.next.number) return false;
            curr = curr.next;
        }
        return true;
    }



}
