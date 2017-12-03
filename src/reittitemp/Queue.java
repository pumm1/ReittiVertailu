
package reittitemp;

public class Queue<T> {

    T[] table;
    int head;
    int tail;
    int n;

    @SuppressWarnings({"unchecked"})
    public Queue(int size) {
        table = (T[]) new Object[size];
        head = 0;
        tail = 0;
        n = size;
//        System.out.println("ii");
    }

    public void enqueue(T t) {
        table[tail] = t;
        tail++;
        if (tail == n) {
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
        if (head == n) {
            head = 0;
        }
        return ret;
    }

}