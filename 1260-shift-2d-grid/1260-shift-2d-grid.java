class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m*n];
        int size = arr.length;
        int idx=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[idx++] = grid[i][j];
            }
        }

        List<List<Integer>> ls = new ArrayList<>();
        int ind = 0;
        for(int i=0;i<m;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                int idxx = ((ind++ - k)%size+size)%size;
                int val = arr[idxx];
                list.add(val);
            }
            ls.add(list);
        }
        return ls;
    }
}