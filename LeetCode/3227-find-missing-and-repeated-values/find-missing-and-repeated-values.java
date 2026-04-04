class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSquareSum = (long) N * (N + 1) * (2*N + 1) / 6;
        long actualSum = 0;
        long actualSquareSum = 0;

        //Traverse the matrix
        for(int[] row : grid) {
            for(int num : row) {
                actualSum += num;
                actualSquareSum += (long) num*num;
            }
        }

        long diff = expectedSum - actualSum; //x-y
        long diffSquare = expectedSquareSum - actualSquareSum; //x2-y2
        long sumXY = diffSquare / diff;
        long missing = (sumXY + diff) / 2;
        long repeated = missing - diff;

        return new int[] {(int) repeated, (int) missing};
    }
}