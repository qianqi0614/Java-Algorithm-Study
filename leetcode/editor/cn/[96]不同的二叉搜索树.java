//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 712 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：动态规划
     * @param n
     * @return
     */
//    public int numTrees(int n) {
//        int[] nums = new int[n + 1];
//        nums[0] = 1;
//        nums[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; j <= i; j++ ) {
//                nums[i] += nums[j - 1] * nums[i - j];
//            }
//        }
//        return nums[n];
//    }

    /**
     * 方法二：catalan
     * @param n
     * @return
     */
    public int numTrees(int n) {
        long c = 1;
        for (int i = 1; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
