//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2356 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0 - nums[i];
            int[] newNums = new int[nums.length - i - 1];
            System.arraycopy(nums,i+1,newNums,0,newNums.length);
            list = twoSum(newNums, sum);
        }
        return list;
    }
    public List<List<Integer>> twoSum(int[] nums, int sum) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = null;
        for (int i = 0; i < nums.length; i++) {
            int temp = sum - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
