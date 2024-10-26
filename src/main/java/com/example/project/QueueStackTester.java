package com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Write the recursive static method split that splits a queue of n elements into two
        // queues. The elements with odd orders (i.e. 1st, 3rd, 5th ...) should be put in the
        // first queue and elements with even orders (i.e. 2nd, 4th, 6th ...) should be put in
        // the second queue. The original queue should remain unchanged at the end of the
        // method.
        // Example. Given the queue (A, B, C, D, E), split results in oq (A, C, E), and eq(B, D).

        // dumbest solution on the planet:
        if (q.length()==0) {
            return;      
        }
        T tmp1 = q.serve();

        oq.enqueue(tmp1);

        T tmp2 = null;
        boolean even_added = false;
        if (q.length()>0) {
            tmp2 = q.serve();
            eq.enqueue(tmp2);
            even_added = true;
        }

        split(q, oq, eq);

        q.enqueue(tmp1);
        if(even_added){
            q.enqueue(tmp2);
        }

    }
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Write a static method remove that removes every element in the priority queue
        // having priority less than p.
        // Example. Given pq: [A, 10], [D, 8], [B, 5], [E, 3], [C, 2] remove(pq, 5) results in
        // pq: [A, 10], [D, 8], [B, 5].

        LinkedPQ<T> tmp_q = new LinkedPQ<T>();
        PQElement<T> tmp = null;

        while( pq.length()>0) {
            tmp = pq.serve();
            if (tmp.p >= p) {
                //j++;
                tmp_q.enqueue(tmp.data, tmp.p);
            }
        }

        while (tmp_q.length()>0) {
            tmp = tmp_q.serve();
            pq.enqueue(tmp.data, tmp.p);
        }
    }
    public static <T> boolean search(Stack<T> st, T e)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Write the recursive static method search that searches for an element e in a stack st
        // and returns true if it’s found or false otherwise. st should not change at the end of
        // the method. You are not allowed to use any auxiliary data structures.
        // Example. Given the stack st (top-to-bottom): 5, 7, 5, 3, 2. search(st, 3) returns
        // true while search(st, 1) returns false.

        if(st.empty()) {
            return false;
        }

        T tmp = st.pop();

        if (tmp.equals(e)) {
            return true;
        }

        boolean tmp2 = search(st, e);
        st.push(tmp);
        return tmp2;

    }
}