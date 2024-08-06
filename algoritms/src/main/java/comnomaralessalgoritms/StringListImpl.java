package comnomaralessalgoritms;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] elements;
    private int size = 0;

    public void indexOut(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
    public StringListImpl(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = new String[initialCapacity];
    }

    private void growSize() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, (elements.length + elements.length / 2));
        }
    }

    @Override
    public String add(String e) {
        CustomException.nullException(e);
        growSize();
        elements[size] = e;
        size++;
        return e;
    }

    @Override
    public String add(int index, String e) {
        CustomException.nullException(e);
        indexOut(index);
        growSize();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        size++;
        return e;
    }

    @Override
    public String set(int index, String e) {
        CustomException.nullException(e);
        indexOut(index);
        elements[index] = e;
        return e;
    }

    @Override
    public String remove(String e) {
        CustomException.nullException(e);
        int i = indexOf(e);
        return remove(i);
    }

    @Override
    public String remove(int index) {
        indexOut(index);
        String a = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return a;
    }

    @Override
    public boolean contains(String e) {
        return indexOf(e) >=0;
    }

    @Override
    public int indexOf(String e) {
        for (int i = 0; i < elements.length; i++) {
                if (e.equals(elements[i]))
                    return i;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(String e) {
        for (int i = size-1; i >=0 ; i--) {
            if (e.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        indexOut(index);
            return elements[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        return Arrays.copyOf(elements, size);
    }
}