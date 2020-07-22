//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 566 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 递归
     */
//    public List<TreeNode> generateTrees(int n) {
//        if (n == 0) {
//            return new LinkedList<TreeNode>();
//        }
//        return generateTrees(1, n);
//    }
//    public List<TreeNode> generateTrees(int start, int end) {
//        List<TreeNode> allTrees = new LinkedList<TreeNode>();
//        if (start > end) {
//            allTrees.add(null);
//            return allTrees;
//        }
//
//        for (int i = start; i <= end; i++) {
//            List<TreeNode> leftTrees = generateTrees(start, i - 1);
//            List<TreeNode> rightTrees = generateTrees(i + 1, end);
//            for (TreeNode left : leftTrees) {
//                for (TreeNode right : rightTrees) {
//                    TreeNode currTree = new TreeNode(i);
//                    currTree.left = left;
//                    currTree.right = right;
//                    allTrees.add(currTree);
//                }
//            }
//        }
//        return allTrees;
//    }

    /**
     * 解法二：动态规划1
     * @param n
     * @return
     */
//    public List<TreeNode> generateTrees(int n) {
//        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
//        dp[0] = new ArrayList<TreeNode>();
//        if (n == 0) {
//            return dp[0];
//        }
//        dp[0].add(null);
//        //长度为 1 到 n
//        for (int len = 1; len <= n; len++) {
//            dp[len] = new ArrayList<TreeNode>();
//            //将不同的数字作为根节点，只需要考虑到 len
//            for (int root = 1; root <= len; root++) {
//                int left = root - 1;  //左子树的长度
//                int right = len - root; //右子树的长度
//                for (TreeNode leftTree : dp[left]) {
//                    for (TreeNode rightTree : dp[right]) {
//                        TreeNode treeRoot = new TreeNode(root);
//                        treeRoot.left = leftTree;
//                        //克隆右子树并且加上偏差
//                        treeRoot.right = clone(rightTree, root);
//                        dp[len].add(treeRoot);
//                    }
//                }
//            }
//        }
//        return dp[n];
//    }
//
//    private TreeNode clone(TreeNode n, int offset) {
//        if (n == null) {
//            return null;
//        }
//        TreeNode node = new TreeNode(n.val + offset);
//        node.left = clone(n.left, offset);
//        node.right = clone(n.right, offset);
//        return node;
//    }

    /**
     * 解法三：动态规划2
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        //每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            //遍历之前的所有解
            for (TreeNode root : pre) {
                //插入到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                for (int j = 0; j <= n; j++) {
                    TreeNode root_copy = treeCopy(root); //复制当前的树
                    TreeNode right = root_copy; //找到要插入右孩子的位置
                    int k = 0;
                    //遍历 j 次找右孩子
                    for (; k < j; k++) {
                        if (right == null)
                            break;
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null)
                        break;
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert; //右孩子是插入的节点
                    insert.left = rightTree; //插入节点的左孩子更新为插入位置之前的子树
                    //加入结果中
                    cur.add(root_copy);
                }
            }
            pre = cur;

        }
        return pre;
    }


    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
