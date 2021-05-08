import java.util.*;

public class demo {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>(100);
        map.put("aa", 10);
        map.put("bb", 11);
        map.put("cc", 12);
        int maxValue = Integer.parseInt(Objects.requireNonNull(findMaxValue(map)).toString());
        String maxKey = findMaxKey(map, maxValue);
        System.out.println(maxKey+"->"+maxValue);
        map.remove(maxKey,maxValue);
        System.out.println("----------------");
        map.forEach((k,v) -> System.out.println(k + "->" + v));
    }

    private static String findMaxKey(HashMap<String, Integer> map, int maxValue) {
        String key = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxValue == entry.getValue()) {
                key = entry.getKey();
            }
        }
        return key;
    }

    private static Object findMaxValue(HashMap<String, Integer> map) {
        if (map.size() == 0) {
            return null;
        }
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return obj[obj.length-1];
    }

    public static void test2() {
        System.out.println("hello world!");
    }
}
