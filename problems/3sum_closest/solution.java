class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int size = nums.length;
        int result = nums[0] + nums[1] + nums[size - 1];
        Arrays.sort(nums);
        for (int i = 0; i < size - 1; i++) {
            int j = i + 1, k = size - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return sum;
                
                if (Math.abs(target - result) > Math.abs(target - sum)) result = sum;
                if (sum > target) --k;
                else ++j;
            }
        }
        return result;
    }
}