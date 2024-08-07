package comnomaralessalgoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {
    private T[] elements;
    private int size = 0;

    public void indexOut(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public CustomListImpl(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = (T[]) new Comparable[initialCapacity];
    }

    private void growSize() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, (elements.length + elements.length / 2));
            List<String> a = new ArrayList<>();
        }
    }

    private void sort2() {
        Arrays.sort(elements, 0, size);
    }

    public void sort() {
        sort();
    }

    public int binarySearch(T e) {
        int min = 0, max = size - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            T mValue = elements[mid];
            int compare = mValue.compareTo(e);
            if (compare < 0) {
                min = mid + 1;
            } else if (compare > 0) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Override
    public T add(T e) {
        CustomException.nullException(e);
        growSize();
        elements[size] = e;
        size++;
        return (T) e;
    }

    @Override
    public T add(int index, T e) {
        CustomException.nullException(e);
        indexOut(index);
        growSize();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        size++;
        return (T) e;
    }

    @Override
    public T set(int index, T e) {
        CustomException.nullException(e);
        indexOut(index);
        elements[index] = e;
        return (T) e;
    }

    @Override
    public T remove(T e) {
        CustomException.nullException(e);
        int i = indexOf(e);
        return (T) remove(i);
    }

    @Override
    public T remove(int index) {
        indexOut(index);
        T a = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return a;
    }

    @Override
    public boolean contains(T e) {
        return indexOf(e) >= 0;
    }

    @Override
    public int indexOf(T e) {
        for (int i = 0; i < elements.length; i++) {
            if (e.equals(elements[i]))
                return i;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(T e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public T get(int index) {
        indexOut(index);
        return elements[index];
    }

    @Override
    public boolean equals(CustomList<T> otherList) {
        CustomException.nullException(otherList);
        if (this == otherList) {
            return true;
        }
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (get(i).equals(otherList.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(elements, size);
    }
}
