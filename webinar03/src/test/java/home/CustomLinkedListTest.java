package home;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    CustomLinkedList<String> list;

    @Before
    public void init() {
        list = new CustomLinkedList<>();
    }

    @Test
    public void testAdd() {
        Assert.assertTrue(list.add(null));
        list.add("String");
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testIndexOnEmptyList() {
        Assert.assertEquals(-1, list.indexOf("Str"));
    }

    @Test
    public void testIndexOnNotEmptyListNegative() {
        list.add("Str1");
        list.add("Str2");
        list.add("Str3");
        Assert.assertEquals(-1, list.indexOf("Str4"));
    }

    @Test
    public void testIndexOnNotEmptyListPositive() {
        list.add("Str1");
        list.add("Str2");
        list.add("Str3");
        Assert.assertEquals(2, list.indexOf("Str3"));
    }

}