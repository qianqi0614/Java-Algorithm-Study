import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> lists = threeSum(nums);
//
//        for (List<Integer> list : lists) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
//        int[] height = {1,8,6,2,5,4,8,3,7};
//        System.out.println(maxArea2(height));

        int[] nums = {1,1,1,1};
        System.out.println(threeSumClosest(nums,4));
    }

    public static int maxArea(int[] height) {
        int l = height.length;
        int width = 0;
        int h = 0;
        int maxArea = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                width = j - i;
                h = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, width * h);
            }
        }
        return maxArea;
    }
    public static int maxArea2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int width = j - i;
            int h = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, width * h);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
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

    public static int[] twoSum(int[] nums, int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = sum - nums[i];
            if (map.containsKey(temp)  && map.get(temp) != i) {
                return new int[] {i, map.get(temp)};
            }
        }
        throw new IllegalArgumentException("Not found!");
    }


    public static int threeSumClosest(int[] nums, int target) {
        int best = 1000000000;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    int temp = third - 1;
                    while (second < temp && nums[temp] == nums[third]) {
                        temp--;
                    }
                    third = temp;
                } else {
                    int temp = second + 1;
                    while (third > temp && nums[temp] == nums[second]) {
                        temp++;
                    }
                    second = temp;
                }
            }
        }
        return best;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}