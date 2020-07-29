public class test {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> lists = threeSum(nums);
//
//        for (List<Integer> list : lists) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
//        int[] height = {1,8,6,2,5,4,8,3,7};
//        System.out.println(maxArea2(height));
//
//        int[] nums = {1,1,1,1};
//        System.out.println(threeSumClosest(nums,4));
//        String s = "{}[]";
//        test t = new test();
//        System.out.println(t.isValid(s));
//        String S = "xywrrmp";
//        String T = "xywrrmu#p";
//        System.out.println(backspaceCompare(S,T));
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        ListNode res = reserveBetween(l1, 2, 4);
//        while (res != null) {
//            System.out.print(res.val + "->");
//            res = res.next;
//        }
//        System.out.print("null");

        int[] nums1 = new int[] {3, 4};
        int[] nums2 = new int[] {1, 2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0 , n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    public static double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

//    public static int lengthOfLongestSubstring(String s) {
//        int ans = 0, n = s.length();
//        int[] index = new int[128];
//        for (int j = 0, i = 0; j < n; j++) {
//            i = Math.max(i, index[s.charAt(j)]);
//            ans = Math.max(ans, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//        return ans;
//    }


//    public static ListNode reserveBetween(ListNode head, int m, int n) {
//        if (head == null) {
//            return null;
//        }
//
//        ListNode curr = head, prev = null;
//        while (m > 1) {
//            prev = curr;
//            curr = curr.next;
//            m--;
//            n--;
//        }
//
//        ListNode con = prev, tail = curr;
//
//        ListNode third = null;
//        while (n > 0) {
//            third = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = third;
//            n--;
//        }
//
//        if (con != null) {
//            con.next = prev;
//        } else {
//            head = prev;
//        }
//
//        tail.next = curr;
//        return head;
//    }

//    public static int maxArea(int[] height) {
//        int l = height.length;
//        int width = 0;
//        int h = 0;
//        int maxArea = 0;
//        for (int i = 0; i < l; i++) {
//            for (int j = i + 1; j < l; j++) {
//                width = j - i;
//                h = Math.min(height[i], height[j]);
//                maxArea = Math.max(maxArea, width * h);
//            }
//        }
//        return maxArea;
//    }
//    public static int maxArea2(int[] height) {
//        int i = 0;
//        int j = height.length - 1;
//        int maxArea = 0;
//        while (i < j) {
//            int width = j - i;
//            int h = Math.min(height[i], height[j]);
//            maxArea = Math.max(maxArea, width * h);
//            if (height[i] > height[j]) {
//                j--;
//            } else {
//                i++;
//            }
//        }
//        return maxArea;
//    }
//
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new LinkedList<>();
//        if (nums == null || nums.length <= 2) {
//            return lists;
//        }
//        Arrays.sort(nums);
//        for (int first = 0; first < nums.length; first++) {
//            if (first > 0 && nums[first] == nums[first - 1]) {
//                continue;
//            }
//            int third = nums.length - 1;
//            int target = -nums[first];
//            for (int second = first + 1; second < nums.length; second++) {
//                if (second > first + 1 && nums[second] == nums[second - 1]) {
//                    continue;
//                }
//                // 需要保证 b 的指针在 c 的指针的左侧
//                while (second < third && nums[second] + nums[third] > target) {
//                    --third;
//                }
//                // 如果指针重合，随着 b 后续的增加
//                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
//                if (second == third) {
//                    break;
//                }
//                if (nums[second] + nums[third] == target) {
//                    List<Integer> list = new LinkedList<>();
//                    list.add(nums[first]);
//                    list.add(nums[second]);
//                    list.add(nums[third]);
//                    lists.add(list);
//                }
//            }
//        }
//        return lists;
//    }
//
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
//
//
//    public static int threeSumClosest(int[] nums, int target) {
//        int best = 1000000000;
//        Arrays.sort(nums);
//        for (int first = 0; first < nums.length - 2; first++) {
//            if (first > 0 && nums[first] == nums[first - 1]) {
//                continue;
//            }
//            int second = first + 1;
//            int third = nums.length - 1;
//            while (second < third) {
//                int sum = nums[first] + nums[second] + nums[third];
//                if (sum == target) {
//                    return target;
//                }
//                if (Math.abs(sum - target) < Math.abs(best - target)) {
//                    best = sum;
//                }
//                if (sum > target) {
//                    int temp = third - 1;
//                    while (second < temp && nums[temp] == nums[third]) {
//                        temp--;
//                    }
//                    third = temp;
//                } else {
//                    int temp = second + 1;
//                    while (third > temp && nums[temp] == nums[second]) {
//                        temp++;
//                    }
//                    second = temp;
//                }
//            }
//        }
//        return best;
//    }
//
//    public static int threeSumClosest2(int[] nums, int target) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        int best = 10000000;
//
//        // 枚举 a
//        for (int i = 0; i < n; ++i) {
//            // 保证和上一次枚举的元素不相等
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            // 使用双指针枚举 b 和 c
//            int j = i + 1, k = n - 1;
//            while (j < k) {
//                int sum = nums[i] + nums[j] + nums[k];
//                // 如果和为 target 直接返回答案
//                if (sum == target) {
//                    return target;
//                }
//                // 根据差值的绝对值来更新答案
//                if (Math.abs(sum - target) < Math.abs(best - target)) {
//                    best = sum;
//                }
//                if (sum > target) {
//                    // 如果和大于 target，移动 c 对应的指针
//                    int k0 = k - 1;
//                    // 移动到下一个不相等的元素
//                    while (j < k0 && nums[k0] == nums[k]) {
//                        --k0;
//                    }
//                    k = k0;
//                } else {
//                    // 如果和小于 target，移动 b 对应的指针
//                    int j0 = j + 1;
//                    // 移动到下一个不相等的元素
//                    while (j0 < k && nums[j0] == nums[j]) {
//                        ++j0;
//                    }
//                    j = j0;
//                }
//            }
//        }
//        return best;
//    }
//
//    public List<List<Integer>> fourSum(int[] nums,int target) {
//        /*定义一个返回值*/
//        List<List<Integer>> result = new ArrayList<>();
//        /*当数组为null或元素小于4个时，直接返回*/
//        if(nums == null || nums.length < 4) {
//            return result;
//        }
//        /*对数组进行从小到大排序*/
//        Arrays.sort(nums);
//        /*数组长度*/
//        int length = nums.length;
//        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
//        for (int k = 0; k < length - 3; k++) {
//            /*当k的值与前面的值相等时忽略*/
//            if (k > 0 && nums[k] == nums[k - 1]) {
//                continue;
//            }
//            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
//            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
//            if(min1 > target){
//                break;
//            }
//            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
//            int max1 = nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
//            if(max1 < target){
//                continue;
//            }
//            /*第二层循环i，初始值指向k+1*/
//            for(int i = k + 1; i < length - 2; i++){
//                /*当i的值与前面的值相等时忽略*/
//                if(i > k + 1 && nums[i] == nums[i - 1]){
//                    continue;
//                }
//                /*定义指针j指向i+1*/
//                int j = i + 1;
//                /*定义指针h指向数组末尾*/
//                int h = length - 1;
//                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
//                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
//                if(min > target){
//                    continue;
//                }
//                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
//                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
//                if(max < target){
//                    continue;
//                }
//                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
//                while (j < h){
//                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
//                    if(curr == target){
//                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
//                        j++;
//                        while(j < h && nums[j] == nums[j - 1]){
//                            j++;
//                        }
//                        h--;
//                        while(j < h && i < h && nums[h] == nums[h + 1]){
//                            h--;
//                        }
//                    }else if(curr > target){
//                        h--;
//                    }else {
//                        j++;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private HashMap<Character,Character> mappings;
//
//    public test() {
//        this.mappings = new HashMap<>();
//        mappings.put('}', '{');
//        mappings.put(']', '[');
//        mappings.put(')', '(');
//    }
//
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (this.mappings.containsKey(c)) {
//                char topElement = stack.empty() ? '#' : stack.pop();
//
//                if (topElement != this.mappings.get(c)) {
//                    return false;
//                }
//            } else {
//                stack.push(c);
//            }
//        }
//        return stack.isEmpty();
//    }
//
//    public static boolean backspaceCompare(String S, String T) {
//        int i = S.length() - 1, j = T.length() - 1;
//        int skipS = 0, skipT = 0;
//
//        while (i >= 0 || j >= 0) {
//            while (i >= 0) {
//                if (S.charAt(i) == '#') {
//                    skipS++;
//                    i--;
//                } else if (skipS > 0) {
//                    skipS--;
//                    i--;
//                } else {
//                    break;
//                }
//            }
//            while (j >= 0) {
//                if (T.charAt(j) == '#') {
//                    skipT++;
//                    j--;
//                } else if (skipT > 0) {
//                    skipT--;
//                    j--;
//                } else {
//                    break;
//                }
//            }
//            if (i >= 0 && j >=0 && S.charAt(i) != T.charAt(j)) {
//                return false;
//            }
//            if ((i >= 0) != (j >= 0)) {
//                return false;
//            }
//            i--;j--;
//        }
//        return true;
//    }
}