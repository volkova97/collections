import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomMapTest {

    @Test
    public void testPutMethod() {
        CustomMap<Integer, String> mapOneValue = new CustomMap<>();
        mapOneValue.put(1, "Value1");

        Map<Integer, String> standartMapOneValue = new HashMap<>();
        standartMapOneValue.put(1, "Value1");

        checkMaps(mapOneValue, standartMapOneValue);

        CustomMap<Integer, String> mapTwoValues = new CustomMap<>();
        mapTwoValues.put(1, "Value1");
        mapTwoValues.put(2, "Value2");

        Map<Integer, String> standartMapTwoValues = new HashMap<>();
        standartMapTwoValues.put(1, "Value1");
        standartMapTwoValues.put(2, "Value2");

        checkMaps(mapTwoValues, standartMapTwoValues);

        CustomMap<Integer, String> mapSimilarValues = new CustomMap<>();
        mapSimilarValues.put(1, "Value1");

        try {
            mapSimilarValues.put(1, "Value2");
        } catch (RuntimeException ignored) {
        }
    }

    @Test
    public void testGetMethod() {
        CustomMap<Integer, String> map = new CustomMap<>();
        map.put(1, "Value1");
        Assert.assertEquals(map.get(1), "Value1");
    }

    @Test
    public void testRemoveMethod() {
        CustomMap<Integer, String> map = new CustomMap<>();
        map.put(1, "Value1");
        map.put(2, "Value2");
        map.put(3, "Value3");
        map.remove(1);

        Map<Integer, String> standartMap = new HashMap<>();
        standartMap.put(1, "Value1");
        standartMap.put(2, "Value2");
        standartMap.put(3, "Value3");

        checkMaps(map, standartMap);
    }

    public void checkMaps(CustomMap<Integer, String> map, Map<Integer, String> standartMap) {
        String expected, actual;

        for (Integer key : standartMap.keySet()){
            expected = standartMap.get(key);
            actual = map.get(key);
            Assert.assertEquals(expected, actual);
        }
    }
}
