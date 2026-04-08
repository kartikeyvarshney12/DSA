class Solution {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        // Step 1: Process each query
        for (int[] query : queries) {
            int li = query[0]; // Start index
            int ri = query[1]; // End index
            int ki = query[2]; // Step size
            int vi = query[3]; // Multiplier

            for (int idx = li; idx <= ri; idx += ki) {
                // Use long to prevent overflow before applying modulo
                long updatedValue = (long) nums[idx] * vi;
                nums[idx] = (int) (updatedValue % MOD);
            }
        }

        // Step 2: Calculate the XOR sum of the final array
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        return xorResult;
    }
}