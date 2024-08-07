import static org.junit.jupiter.api.Assertions.*;

import comnomaralessalgoritms.CustomListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CustomListImplTest {

    private CustomListImpl list;

    @BeforeEach
    public void setUp() {
        list = new CustomListImpl(10);
    }

    @Test
    public void add() {
        assertEquals("a", list.add("a"));
        assertEquals("b", list.add("b"));
        assertEquals(1, list.add(1));
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    public void addByIndex() {
        list.add("a");
        list.add("b");
        assertEquals(1, list.add(1, 1));
        assertEquals("a", list.get(0));
        assertEquals(1, list.get(1));
        assertEquals("b", list.get(2));
    }

    @Test
    public void set() {
        list.add("a");
        list.add("b");
        assertEquals(1, list.set(1, 1));
        assertEquals("a", list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void removeByValue() {
        list.add("a");
        list.add("v");
        list.add(1);
        assertEquals("v", list.remove(1));
        assertEquals("a", list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void removeByIndex() {
        list.add("a");
        list.add("s");
        list.add(1);
        assertEquals("s", list.remove(1));
        assertEquals("a", list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void contains() {
        list.add(1);
        list.add("s");
        assertTrue(list.contains(1));
        assertFalse(list.contains("r"));
    }

    @Test
    public void indexOf() {
        list.add("a");
        list.add(1);
        assertEquals(0, list.indexOf("a"));
        assertEquals(1, list.indexOf(1));
    }

    @Test
    public void lastIndexOf() {
        list.add("a");
        list.add(1);
        list.add("d");
        assertEquals(0, list.lastIndexOf("a"));
        assertEquals(1, list.lastIndexOf(1));
        assertEquals(2, list.lastIndexOf("d"));
    }

    @Test
    public void get() {
        list.add("a");
        list.add(1);
        assertEquals("a", list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void equals() {
        CustomListImpl otherList = new CustomListImpl(10);
        list.add("a");
        list.add(1);
        otherList.add("a");
        otherList.add(1);
        assertTrue(list.equals(otherList));
        otherList.add("j");
        assertFalse(list.equals(otherList));
    }

    @Test
    public void size() {
        list.add("s");
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        list.add("1");
        assertFalse(list.isEmpty());
    }

    @Test
    public void clear() {
        list.add("a");
        list.add(1);
        list.clear();
        list.toArray();
        assertTrue(list.isEmpty());
    }

    @Test
    public void toArray() {
        list.add("a");
        list.add(1);
        String[] array = (String[]) list.toArray();
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