//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 252 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }
        return getIntersection(set1, set2);

    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() < set2.size()) {
            return getIntersection(set2,set1);
        }
        Set<Integer> intersection = new HashSet<>();
        for (int i : set1) {
            if (set2.contains(i)) {
                intersection.add(i);
            }
        }
        int[] res = new int[intersection.size()];
        int j = 0;
        for (int i : intersection) {
            res[j++] = i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
