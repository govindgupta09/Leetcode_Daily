class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // Process all windows of size k
        for(int i=0; i+k <= nums.length;i++)
        {
            Set<Integer> seen = new HashSet<>();

            // Collect distinct numbers in the current window
            for(int j=i;j<i+k;j++)
            {
                // Count this window's appearance for each number
                seen.add(nums[j]);
            }
            for(int n:seen)
            {
                count.put(n,count.getOrDefault(n,0)+1);
            }
        }

        int ans = -1;
        for(int x:count.keySet())
        {
            // Find the largest number that appears in exactly one window
            if(count.get(x)==1)
            {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}