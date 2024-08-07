package comnomaralessalgoritms;


public interface CustomList<T> {

    void sort(int[] a, int b, int end);
    T add(T elements);

    T add(int index, T elements);

    T set(int index, T elements);

    T remove(T elements);

    T remove(int index);

    boolean contains(T elements);

    int indexOf(T elements);

    int lastIndexOf(T elements);

    <T> T get(int index);

    boolean equals(CustomList<T> otherList);

    int size();

    boolean isEmpty();

    void clear();

    <T> T[] toArray();
}
