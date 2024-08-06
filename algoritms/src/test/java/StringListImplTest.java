import static org.junit.jupiter.api.Assertions.*;

import comnomaralessalgoritms.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StringListImplTest {

    private StringListImpl list;

    @BeforeEach
    public void setUp() {
        list = new StringListImpl(10);
    }

    @Test
    public void add() {
        assertEquals("a", list.add("a"));
        assertEquals("b", list.add("b"));
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
    }

    @Test
    public void addByIndex() {
        list.add("a");
        list.add("b");
        assertEquals("c", list.add(1, "c"));
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
        assertEquals("b", list.get(2));
    }

    @Test
    public void set() {
        list.add("a");
        list.add("b");
        assertEquals("f", list.set(1, "f"));
        assertEquals("a", list.get(0));
        assertEquals("f", list.get(1));
    }

    @Test
    public void removeByValue() {
        list.add("a");
        list.add("v");
        list.add("c");
        assertEquals("v", list.remove("v"));
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
    }

    @Test
    public void removeByIndex() {
        list.add("a");
        list.add("s");
        list.add("d");
        assertEquals("s", list.remove(1));
        assertEquals("a", list.get(0));
        assertEquals("d", list.get(1));
    }

    @Test
    public void contains() {
        list.add("a");
        list.add("s");
        assertTrue(list.contains("a"));
        assertFalse(list.contains("r"));
    }

    @Test
    public void indexOf() {
        list.add("a");
        list.add("s");
        assertEquals(0, list.indexOf("a"));
        assertEquals(1, list.indexOf("s"));
    }

    @Test
    public void lastIndexOf() {
        list.add("a");
        list.add("s");
        list.add("d");
        assertEquals(0, list.lastIndexOf("a"));
        assertEquals(1, list.lastIndexOf("s"));
        assertEquals(2, list.lastIndexOf("d"));
    }

    @Test
    public void get() {
        list.add("a");
        list.add("s");
        assertEquals("a", list.get(0));
        assertEquals("s", list.get(1));
    }

    @Test
    public void equals() {
        StringListImpl otherList = new StringListImpl(10);
        list.add("a");
        list.add("s");
        otherList.add("a");
        otherList.add("s");
        assertTrue(list.equals(otherList));
        otherList.add("j");
        assertFalse(list.equals(otherList));
    }

    @Test
    public void size() {
        list.add("s");
        list.add("d");
        assertEquals(2, list.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(list.isEmpty());
        list.add("a");
        assertFalse(list.isEmpty());
    }

//    @Test
//    public void clear() {
//        list.add("a");
//        list.add("s");
//        list.clear();
//        list.toArray();
//        assertTrue(list.isEmpty());
//    }

    @Test
    public void toArray() {
        list.add("a");
        list.add("a");
        String[] array = list.toArray();
        assertArrayEquals(new String[]{"a", "a"}, array);
    }

    @Test
    public void addNull() {
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    public void addIndexOut() {
        list.add("f");
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, "d"));
    }

    @Test
    public void removeIndexOut() {
        list.add("f");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    public void setIndexOut() {
        list.add("f");
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, "sss"));
    }
}