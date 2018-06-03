package com.assignment_2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList<E> implements Iterable<E> {

    private int theSize = 0;
    private int modCount = 0;
    private Node<E> startNode, endNode;

    public MyLinkedList() {
    	
    	  startNode = new Node(null, null, null);
          endNode = new Node(null, startNode, null);
          startNode.next = endNode;
          theSize = 0;
          modCount++;
    }

   

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(E x) {
        return add(size(), x);
    }

    public boolean add(int index, E x) {
        addBefore(getNode(index), x);
        return true;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public E set(int index, E x) {
        Node<E> p = getNode(index);
        E old = p.data;
        p.data = x;
        return old;
    }

    public E remove(int index) {
        return remove(getNode(index));
    }

    

    
  


    
    

    private void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private Node<E> getNode(int index) {
        Node<E> p;
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        if (index < size() / 2) {
            p = startNode.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endNode;
            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        }

        return p;
    }

    private E remove(Node<E> x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        theSize--;
        modCount++;
        return x.data;
    }

    
    
    
    
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private static class Node<E> {
        public E data;
        public Node<E> prev;
        public Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private class MyIterator implements Iterator<E> {
        private Node<E> current = startNode.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current!= endNode;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!okToRemove) {
                throw new NoSuchElementException();
            }
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }

    }

	
}