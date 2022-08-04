import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class CustomArrayTest {
    @Test
    public void testAddMethod() {
        CustomArrayList array = new CustomArrayList(3);
        array.add(2);
        array.add(4);
        array.add(8);
        ArrayList<Integer> standartArray = new ArrayList<Integer>();
        standartArray.add(2);
        standartArray.add(4);
        standartArray.add(8);
        int expected, actual;

        for (int i = 0; i < standartArray.size(); i++){
            expected = standartArray.get(i);
            actual = array.get(i);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void testRemoveMethod() {
        CustomArrayList array = new CustomArrayList(5);
        array.add(8);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.remove(3);

        ArrayList<Integer> standartArray = new ArrayList<>();
        standartArray.add(8);
        standartArray.add(1);
        standartArray.add(2);
        standartArray.add(4);
        int expected, actual;

        for (int i = 0; i < standartArray.size(); i++){
            expected = standartArray.get(i);
            actual = array.get(i);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void testToStringMethod() {
        CustomArrayList array = new CustomArrayList(3);
        array.add(2);
        array.add(4);
        array.add(8);
        String expected = "2, 4, 8";
        Assert.assertEquals(expected, array.toString());
    }
}
