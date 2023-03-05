class Solution {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int min = -1, max = -1, left = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK)  left = i;
            if (nums[i] == minK) min = i;
            if (nums[i] == maxK) max = i;
            result += Math.max(0, Math.min(max, min) - left);
        }
        return result;
    }
}