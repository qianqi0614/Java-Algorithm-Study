//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 2974 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 法一：把两个数组合并，找出合并数组的中位数，时间复杂度 O(m+n)，空间复杂度 O(m+n)
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        int[] newNums = new int[m + n];
//        if (m == 0) {
//            if (n % 2 == 0) {
//                return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
//            } else {
//                return nums2[n / 2];
//            }
//        }
//        if (n == 0) {
//            if (m % 2 == 0) {
//                return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
//            } else {
//                return nums1[m / 2];
//            }
//        }
//        int count = 0;
//        int i = 0, j = 0;
//        while (count != (m + n)) {
//            if (i == m) {
//                while (j != n) {
//                    newNums[count++] = nums2[j++];
//                }
//                break;
//            }
//            if (j == n) {
//                while (i != m) {
//                    newNums[count++] = nums1[i++];
//                }
//                break;
//            }
//            if (nums1[i] < nums2[j]) {
//                newNums[count++] = nums1[i++];
//            } else {
//                newNums[count++] = nums2[j++];
//            }
//        }
//        if (count % 2 == 0) {
//            return (newNums[count / 2] + newNums[count / 2 - 1]) / 2.0;
//        } else {
//            return newNums[count / 2];
//        }
//    }

    /**
     * 法二：不合并数组，直接找中位数，时间复杂度 O(m+n)，空间复杂度 O(1)
     */
//    public double findMedianSortedArrays(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        int len = m + n;
//        int left = -1, right = -1;
//        int aStart = 0, bStart = 0;
//        for (int i = 0; i <= len / 2; i++) {
//            left = right;
//            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//                right = A[aStart++];
//            } else {
//                right = B[bStart++];
//            }
//        }
//        if ((len & 1) == 0)
//            return (left + right) / 2.0;
//        else
//            return right;
//    }

    /**
     * 法三：不合并数组，利用二分法找中位数，时间复杂度 O(log(m+n))，空间复杂度 O(1)
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//        int left = (n + m + 1) / 2;
//        int right = (n + m + 2) / 2;
//        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
//        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
//    }
//
//    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        int len1 = end1 - start1 + 1;
//        int len2 = end2 - start2 + 1;
//        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
//        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
//        if (len1 == 0) return nums2[start2 + k - 1];
//
//        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
//
//        int i = start1 + Math.min(len1, k / 2) - 1;
//        int j = start2 + Math.min(len2, k / 2) - 1;
//
//        if (nums1[i] > nums2[j]) {
//            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
//        }
//        else {
//            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
//        }
//    }

    /**
     * 法四：不合并数组，利用二分法找中位数，时间复杂度是 O(log(min(m，n)))，空间复杂度是 O(1)
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j - 1] > A[i]) { // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) { // i 需要减小
                iMax = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
