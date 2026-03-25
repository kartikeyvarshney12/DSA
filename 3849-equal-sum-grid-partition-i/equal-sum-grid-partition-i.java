class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        long total = 0;
        long sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                total+= grid[i][j];
            }
        }
        if(total%2==1) return false;
        long target =  total/2;

        //horizontal
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum += grid[j][i];
            }
            if(sum == target) return true;
        }

        //vertical 
        sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum += grid[i][j];
            }
            if(sum == target) return true;
        }
        return false;
    }
}