import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class CustomListTest {

    @Test
    public void testAddMethod() {
        CustomList list = new CustomList();
        list.add(2);
        list.add(4);
        list.add(8);
        List<Integer> standartList = List.of(2, 4, 8);
        int expected, actual;

        for (int i = 0; i < standartList.size(); i++){
            expected = standartList.get(i);
            actual = list.get(i);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void testToStringMethod() {
        CustomList list = new CustomList();
        list.add(2);
        list.add(4);
        list.add(8);
        List<Integer> standartList = List.of(2, 4, 8);

        Assert.assertEquals("["+list+"]", standartList.toString());
    }

    @Test
    public void testRemoveMethod() {
        CustomList list = new CustomList();
        int expected, actual;
        list.add(2);
        list.add(4);
        list.add(8);
        list.remove(1);

        List<Integer> standartList = List.of(2, 8);

        for (int i = 0; i < standartList.size(); i++){
            expected = standartList.get(i);
            actual = list.get(i);
            Assert.assertEquals(expected, actual);
        }
    }
}
