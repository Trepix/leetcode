class Solution {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int lastMinK = -1, lastMaxK = -1, lastNotValid = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastNotValid = i;
                lastMinK = lastMaxK = -1;
            }
            if (nums[i] == minK) lastMinK = i;
            if (nums[i] == maxK) lastMaxK = i;
            if (lastMaxK != -1 && lastMinK != -1) {
                result += Math.min(lastMaxK, lastMinK) - lastNotValid;
            }
        }
        return result;
    }
}