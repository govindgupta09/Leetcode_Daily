class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        // Store all possible XOR values of two different elements
        Set<Integer> pairXors = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXors.add(nums[i] ^ nums[j]);
            }
        }

        // Maximum nums[i] <= 1500, so XOR values are < 2048
        boolean[] seen = new boolean[2048];

        for (int pairXor : pairXors) {
            for (int num : nums) {
                seen[pairXor ^ num] = true;
            }
        }

        int answer = 0;

        for (boolean value : seen) {
            if (value) {
                answer++;
            }
        }

        return answer;
    }
}