
package reittitemp;
public class Array<T> {

    private T[] list;
    private int count;
    private int max;
    private T type = null;

    @SuppressWarnings({"unchecked"})
    public Array(int s) {
        list = (T[]) new Object[s];
        count = 0;
        max = s;

    }

    public void add(T t) {
        int temp = 0;
        for (int i = 0; i < max; i++) {
            if (list[i] == t) {
                temp++;
            }
        }
        if (temp == 0) {
            if (count < max) {
                list[count] = t;
                count++;
            }
        }
    }

    public T get(int i) {
        if (i < count && i >= 0) {
            return list[i];
        }
        return null;
    }

    public T[] getList() {
        return list;
    }

    public int getSize() {
        return count;
    }

}