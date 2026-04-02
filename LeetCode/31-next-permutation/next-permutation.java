class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        //step1. find the dip
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        //step2. if dip exists, find next greater element
        if(idx!= -1) {
            for(int i = n-1; i >= 0; i--) {
                if(nums[i] > nums[idx]) {
                    swap(nums, i, idx);
                    break;
                }
            }
        }

        //step3. reverse suffix
        reverse(nums, idx+1, n-1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}