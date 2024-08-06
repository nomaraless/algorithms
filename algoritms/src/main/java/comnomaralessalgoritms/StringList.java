package comnomaralessalgoritms;


public interface StringList {
    String add(String elements);

    String add(int index, String elements);

    String set(int index, String elements);

    String remove(String elements);

    String remove(int index);

    boolean contains(String elements);

    int indexOf(String elements);

    int lastIndexOf(String elements);

    String get(int index);

    boolean equals(StringList otherList);

    int size();

    boolean isEmpty();

    void clear();

    String[] toArray();
}
