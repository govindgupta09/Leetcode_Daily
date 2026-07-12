class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] Arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(Arr);
        HashMap<Integer, Integer> Rank = new HashMap<>();
        for (int x : Arr)
          Rank.putIfAbsent(x, Rank.size() + 1);
        for (int i = 0; i < arr.length; ++i)
          Arr[i] = Rank.get(arr[i]);
        return Arr;
    }
}