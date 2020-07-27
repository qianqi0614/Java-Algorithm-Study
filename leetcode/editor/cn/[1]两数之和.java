//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 法一：循环，时间复杂度 o(n), 空间复杂度 o(1)
     */
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            int temp = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == temp) {
//                    return new int[] {i, j};
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution!");
//    }

    /**
     * 法二：利用 HashMap，时间复杂度 o(1), 空间复杂度 o(n)
     */
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer,Integer> map  = new HashMap<>();
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            map.put(nums[i],i);
//        }
//        for (int i = 0; i < len; i++) {
//            int res = target - nums[i];
//            if (map.containsKey(res) && map.get(res) != i) {
//                return new int[] {i, map.get(res)};
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution!");
//    }

    /**
     * 法三：对于 HashMap 的优化，只循环一次
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {i, map.get(temp)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution!");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
