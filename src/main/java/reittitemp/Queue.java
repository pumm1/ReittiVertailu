package main.java.reittitemp;

public class Queue<T> {

    /**
     *@param table jonon taulu
     *@param head jonon pää
     *@param tail jonon häntä
     *@param size jonon max koko
     */
    T[] table;
    int head;
    int tail;
    int size;

    @SuppressWarnings({"unchecked"})
    public Queue(int size) {
        table = (T[]) new Object[size];
        head = 0;
        tail = 0;
        this.size = size;
    }

    /**
     *@param t 
     */
    public void enqueue(T t) {
        table[tail] = t;
        tail++;
        if (tail == size) {
            tail = 0;
        }
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public boolean isEmpty() {
        if (table[head] == null) {
            return true;
        }
        return false;
    }

    public T dequeue() {
        T ret = table[head];
        table[head] = null;
        head++;
        if (head == size) {
            head = 0;
        }
        return ret;
    }

}