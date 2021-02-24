import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        Student s1 = new Student("aa",2);
        Student s2 = new Student("aa", 2);
        System.out.println(s1 == s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(s1);
        hashSet.add(s2);
        System.out.println(hashSet.size());
        Integer one = 127;
        Integer two = 127;
        Integer three = 128;
        Integer four = 128;
//        System.out.println(one.equals(two));
//        System.out.println(three.equals(four));
        String s = "123";
        System.out.println(Integer.parseInt(s));
        System.out.println(Integer.valueOf(s));
        Integer[] myArray = {1, 2, 3};
        int[] array = {3, 2, 1};
//        System.out.println(arrayToList(array));
        System.out.println(arrayToList(myArray));
        System.out.println(new ArrayList<>(Arrays.asList(myArray)));
        System.out.println(Arrays.stream(myArray).collect(Collectors.toList()));
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
        String[] animal = new String[]{
          "dog", "pig", "cat"
        };
        String[] animals = {"dogs", "pigs", "cats"};
        List<String> list = new ArrayList<>(Arrays.asList(animal));
        Collections.reverse(list);
        animal = list.toArray(new String[0]);
        System.out.println(Arrays.toString(animal));
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.removeIf(i -> i.equals(2));
//        Iterator<Integer> iterator = list2.iterator();
//        while (iterator.hasNext()) {
//            int temp = iterator.next();
//            if (temp == 2) {
//                iterator.remove();
//            }
//        }
        System.out.println(list2);

    }

    static <T> List<T> arrayToList(final T[] array) {
        final List<T> l = new ArrayList<>(array.length);

        Collections.addAll(l, array);
        return l;
    }

    static <T> List<T> arrayToList2(final T[] array) {
        final List<T> l = new ArrayList<>(array.length);

        Collections.addAll(l, array);
        return l;
    }
}
