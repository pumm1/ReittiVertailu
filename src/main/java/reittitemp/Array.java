package main.java.reittitemp;

public class Array<T> {
    
    /**
     *@param list tyypin T taulukko
     *@param count taulukon olioiden lukumäärä
     *@param max maksimikoko taululle
     */
    private T[] list;
    private int count;
    private int max;

    /**
     *@param size arrayn koko
     */
    @SuppressWarnings({"unchecked"})
    public Array(int size) {
        list = (T[]) new Object[size];
        count = 0;
        max = size;

    }

    /**
     *@param t tyypin T lisäys arrayhyn
     */
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

    /**
     *@param i taulukon indeksi, mistä haetaan
     */
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