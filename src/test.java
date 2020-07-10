import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);

        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length <= 2) {
            return lists;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
//    public static int[] twoSum(int[] nums, int sum) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int temp = sum - nums[i];
//            if (map.containsKey(temp)  && map.get(temp) != i) {
//                return new int[] {i, map.get(temp)};
//            }
//        }
//        throw new IllegalArgumentException("Not found!");
//    }
}