class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSquareSum = (long) N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        // 🔹 Traverse matrix
        for (int[] row : grid) {
            for (int num : row) {
                actualSum += num;
                actualSquareSum += (long) num * num;
            }
        }

        long diff = expectedSum - actualSum; // x - y
        long squareDiff = expectedSquareSum - actualSquareSum; // x^2 - y^2

        long sumXY = squareDiff / diff; // x + y

        long missing = (diff + sumXY) / 2;
        long repeated = missing - diff;

        return new int[]{(int) repeated, (int) missing};
    }
}