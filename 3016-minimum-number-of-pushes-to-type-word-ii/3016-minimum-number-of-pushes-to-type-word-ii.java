class Solution {
    public int minimumPushes(String word) {
        // Count frequency of each character
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies in ascending order
        Arrays.sort(freq);

        int pushes = 0;

        // Process from highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }

            // Every 8 letters get the same push cost
            int cost = (25 - i) / 8 + 1;

            pushes += freq[i] * cost;
        }

        return pushes;
    }
}