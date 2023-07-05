package test;

import main.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class ArrayListTest {

    @Test
    void testAddItem() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.add(2);
        Assertions.assertEquals(2, testList.size());
    }

    @Test
    void testAddItemByIndex() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.add(2);
        testList.add(0, 1);
        Assertions.assertEquals(3, testList.size());
    }

    @Test
    void get() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.add(2);
        testList.add(0, 1);
        Assertions.assertEquals(1, testList.get(0));
        Assertions.assertEquals(0, testList.get(1));
        Assertions.assertEquals(2, testList.get(2));
    }

    @Test
    void size() {
        ArrayList<Integer> emptyList = new ArrayList<>();
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.add(2);
        testList.add(0, 1);
        Assertions.assertEquals(3, testList.size());
        Assertions.assertEquals(0, emptyList.size());
    }

    @Test
    void isEmpty() {
        ArrayList<Integer> emptyList = new ArrayList<>();
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.remove(0);
        Assertions.assertTrue(emptyList.isEmpty());
        Assertions.assertTrue(testList.isEmpty());
    }

    @Test
    void testRemove() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("0");
        testList.add("2");
        testList.add(0, "1");
        testList.remove("0");
        testList.remove("2");
        testList.remove("1");
        Assertions.assertTrue(testList.isEmpty());
    }

    @Test
    void testRemovByIndex() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.add(2);
        testList.add(0, 1);
        testList.remove(0);
        testList.remove(0);
        testList.remove(0);
        Assertions.assertTrue(testList.isEmpty());
    }

    @Test
    void indexOf() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("0");
        testList.add("2");
        testList.add(0, "1");
        Assertions.assertEquals(0, testList.indexOf("1"));
        Assertions.assertEquals(1, testList.indexOf("0"));
    }

    @Test
    void contains() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("0");
        testList.add("2");
        Assertions.assertTrue(testList.contains("2"));
    }

    @Test
    void testQuickSortForIntegers() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.add(2);
        testList.add(9);
        testList.add(8);
        testList.add(1);
        testList.add(3);
        testList.add(6);
        testList.add(7);
        testList.add(4);
        testList.add(5);
        ArrayList<Integer> sortList = testList.quickSort(Integer::compareTo);
        Assertions.assertEquals(0, sortList.get(0));
        Assertions.assertEquals(5, sortList.get(5));
        Assertions.assertEquals(9, sortList.get(9));
    }
}