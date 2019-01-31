package edu.isu.cs.cs3308.structures.impl;

//Dan Walker
//CS3308
//Campaign01
//NOTE: would not compile/build on my end. I do not know the reason

import edu.isu.cs.cs3308.structures.List;

public class CircularlyLinkedList<E> implements List<E> {

    public class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    public Node<E> head;
    public Node<E> tail;
    public int size = 0;

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }


    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addLast(E element) {
        if (element == null) {
        } else {
            Node<E> newest = new Node<>(element, head);

            if (isEmpty()) {
                head = newest;
                tail = newest;
            } else {
                tail.setNext(newest);
                tail = newest;
                tail.setNext(head);

            }
            size++;
        }
    }

    public void addFirst(E element) {
        if (element == null) {
        } else {
            head = new Node<>(element, head);
            if (size == 0) {
                tail = head;
            }
            size++;
        }
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            int i = 0;
            Node<E> current = head;
            while (current.getNext() != null || i < size - 1) {
                current = current.getNext();
                i++;
            }

            Node<E> toRemove = current.getNext();
            toRemove = null;
            tail = current;
            tail.setNext(head);

            if (current.element == null) return null;

            size--;
            return tail.element;
        }


    }

    public void insert(E element, int index) {
        if (index < 0 || element == null) {

        } else if (index >= size) {
            addLast(element);
        } else {
            Node<E> newNode = new Node<>(element, null);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.next = current.getNext();
            current.next = newNode;
            size++;


        }

    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head;
        for (int i = 0; i < index - 1; i++)
            current = current.getNext();

        Node<E> toRemove = current.getNext();
        current.setNext(toRemove.getNext());
        toRemove.setNext(null);
        size--;
        return toRemove.getElement();
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            return null;
        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();

        return current.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int indexOf(E item) {
        if (item == null) {
            return -1;
        }
        Node<E> current = head;
        for (int x = 0; x < size; x++) {
            if (current.getElement() == item){
                return x;
            }
            else {
                current = current.getNext();

            }
       }
       return -1;
    }

    public void printList() {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

}

