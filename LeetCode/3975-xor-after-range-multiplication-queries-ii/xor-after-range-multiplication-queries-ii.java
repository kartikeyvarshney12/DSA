import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int sqrtN = (int) Math.sqrt(n);
        
        // Group small-k queries to process them in batches
        Map<Integer, List<int[]>> smallKQueries = new HashMap<>();
        
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k > sqrtN) {
                // Large k: Direct simulation is efficient
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((1L * nums[i] * v) % MOD);
                }
            } else {
                smallKQueries.computeIfAbsent(k, x -> new ArrayList<>()).add(q);
            }
        }

        // Process small k batches
        for (int k : smallKQueries.keySet()) {
            long[] diff = new long[n + k + 1];
            Arrays.fill(diff, 1L);
            
            for (int[] q : smallKQueries.get(k)) {
                int l = q[0], r = q[1], v = q[3];
                // Find the first index after the range that belongs to this k-sequence
                int lastIdx = l + ((r - l) / k) * k;
                int nextIdx = lastIdx + k;
                
                diff[l] = (diff[l] * v) % MOD;
                if (nextIdx < n) {
                    diff[nextIdx] = (diff[nextIdx] * power(v, MOD - 2)) % MOD;
                }
            }
            
            // Propagate the multipliers with stride k
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    diff[i] = (diff[i] * diff[i - k]) % MOD;
                }
                nums[i] = (int) ((1L * nums[i] * diff[i]) % MOD);
            }
        }

        // Final XOR of all elements
        int result = 0;
        for (int x : nums) {
            result ^= x;
        }
        return result;
    }

    // Binary Exponentiation for Modular Inverse
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}