package reittitemp;

public class Queue<T> {

    T[] table;
    int head;
    int tail;
    int n;

    public Queue(int size) {
        table = (T[]) new Object[size];
        head = 0;
        tail = 0;
        n = size;
    }

    public void enqueue(T t) {
        table[tail] = t;
        tail++;
        if (tail == n) {
            tail = 0;
        }
    }

    public T dequeue() {
        T ret = table[head];
        head++;
        if (head == n) {
            head = 0;
        }
        return ret;
    }

}
