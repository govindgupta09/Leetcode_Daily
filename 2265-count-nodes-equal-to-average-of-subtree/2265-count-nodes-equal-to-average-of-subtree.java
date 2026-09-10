//Approach-1 (Brute Force)
//T.C : O(n^2) For every root, you visit it's subtree to find average
//S.C : O(1) (excluding recursion stack space)
public class Solution {
    private int result;
    
    private int sum(TreeNode root, int[] count) {
        if (root == null) {
            return 0;
        }
        
        count[0]++;
        
        int leftSum = sum(root.left, count);
        int rightSum = sum(root.right, count);
        
        return leftSum + rightSum + root.val;
    }
    
    private void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        
        int[] count = {0};
        int totalSum = sum(root, count);
        
        if (totalSum / count[0] == root.val) {
            result++;
        }
        
        solve(root.left);
        solve(root.right);
    }
    
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        
        solve(root);
        
        return result;
    }
}

/**
//Approach-2 (Doing postorder traversal)
//T.C : O(n)
//S.C : O(1) (excluding recursion stack space)
public class Solution {
    private int result;
    
    private Pair<Integer, Integer> solve(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }
        
        Pair<Integer, Integer> left = solve(root.left);
        Pair<Integer, Integer> right = solve(root.right);
        
        int leftSum = left.getKey();
        int leftCount = left.getValue();
        
        int rightSum = right.getKey();
        int rightCount = right.getValue();
        
        int SUM = leftSum + rightSum + root.val;
        int COUNT = leftCount + rightCount + 1;
        
        int avg = SUM / COUNT;
        
        if (avg == root.val) {
            result++;
        }
        
        return new Pair<>(SUM, COUNT);
    }
    
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        
        solve(root);
        
        return result;
    }
}

**/