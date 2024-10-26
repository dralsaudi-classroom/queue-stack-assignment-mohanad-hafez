package com.example.project;

public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	
    public LinkedList() {
		head = current = null;
	}
	public boolean empty() {
		return head == null;
	}
	public boolean last() {
		return current.next == null;
	}
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T e) {
        current.data = e;
    }
    public void insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<T>(e);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }
    public T mostFrequentElement() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //         Write the method mostFrequentElement, member of the class LinkedList, that returns
        // the most frequent element in the list. The most frequent element is the element
        // appearing the highest number of times. If one or more element appear the same
        // number of times, the one encountered earlier is returned.
        // Example 1.1. Given the list l : A, B, C, B, C, D, E, mostFrequentElement() returns
        // B.
        int max_frequency = 0;
        Node<T> max_element = null;
        Node<T> element = head;
        Node<T> comparing_element = null;
        int frequency = 0;
        int i = 0;
        // iterate over the list
        while (element != null) {
            //System.out.println("iteration no" + i);
            frequency = 0;
            // for each element iterate again over the least to see how many times it appears
            comparing_element = head;
            while (comparing_element != null) {
                if (element.data.equals(comparing_element.data)) {
                    //System.out.println("found " + element.data + "Imma increase frequency by 1 now to become" + (frequency + 1));
                    frequency++;
                }
                comparing_element = comparing_element.next;
            }
            
            // if the frequency of element is greater than the current max frequency, change max_element to element
            if (frequency > max_frequency) {
                //System.out.println("max is now " + frequency + " and element is " + element.data);
                max_frequency = frequency;
                max_element = element;
            }

            element = element.next;
            i++;
        }

        return max_element.data;
    }
}