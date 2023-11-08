import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class MyTreeSetTest {

    MyTreeSet<Integer> set;

    @Before
    public void init() {
        set = new MyTreeSet<>(Comparator.comparingInt(o -> o));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        set.add(null);
    }

    @Test
    public void testOneElement() {
        set.add(5);
        Assert.assertEquals(1, set.getSize());
    }

    @Test
    public void testTwoEqualsElement() {
        set.add(5);
        set.add(5);
        Assert.assertEquals(1, set.getSize());
    }

    @Test
    public void testTwoElements() {
        set.add(5);
        set.add(6);
        Assert.assertEquals(2, set.getSize());
    }


    @Test
    public void testThreeElements() {
        set.add(5);
        set.add(6);
        set.add(3);
        Assert.assertEquals(3, set.getSize());
    }

    @Test
    public void testSevenElements() {
        set.add(5);
        set.add(10);
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(9);
        set.add(11);
        Assert.assertEquals(7, set.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void notContainsNull() {
        set.contains(null);
    }

    @Test
    public void notContains() {
        Assert.assertFalse(set.contains(5));
    }


    @Test
    public void contains() {
        set.add(5);
        Assert.assertTrue(set.contains(5));
    }

    @Test
    public void testContainsSevenElements() {
        set.add(5);
        set.add(10);
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(9);
        set.add(11);
        Assert.assertTrue(set.contains(5));
        Assert.assertTrue(set.contains(10));
        Assert.assertTrue(set.contains(3));
        Assert.assertTrue(set.contains(1));
        Assert.assertTrue(set.contains(2));
        Assert.assertTrue(set.contains(9));
        Assert.assertTrue(set.contains(11));
        Assert.assertFalse(set.contains(100));
    }

    @Test
    public void testRemoveThreeElements() {
        set.add(5);
        set.add(6);
        set.add(3);

        set.remove(3);
        Assert.assertEquals(2, set.getSize());
    }
}