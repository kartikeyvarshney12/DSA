class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        int[] result = new int[n * n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[index++] = grid[i][j];
            }
        }

        Arrays.sort(result);

        int repeated = -1;
        int missing = -1;

        for(int i = 1; i < result.length; i++) {
            if(result[i] == result[i-1]) {
                repeated = result[i];
            } else if(result[i] > result[i-1] + 1) {
                missing = result[i-1] + 1;
            }
        }
        //edge cases
        if(result[0] != 1) missing = 1;
        if(result[result.length - 1] != n*n) missing = n*n;

        return new int[]{repeated, missing};
    }
}