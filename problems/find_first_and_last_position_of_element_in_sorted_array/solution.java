class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = searchRange(0, nums.length - 1, nums, target);
        result[0] = result[0] == Integer.MAX_VALUE ? -1 : result[0];
        result[1] = result[1] == Integer.MIN_VALUE ? -1 : result[1];
        return result;
    }

    public int[] searchRange(int left, int right, int[] nums, int target) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        if (left > right) return new int[]{min, max};

        int pivot = (left + right) / 2;
        if (nums[pivot] == target) {
            min = pivot;
            max = pivot;
        }
        if (target <= nums[pivot]) {
            int[] result = searchRange(left, pivot - 1, nums, target);
            min = Math.min(result[0], min);
            max = Math.max(result[1], max);
        }
        if (target >= nums[pivot]) {
            int[] result = searchRange(pivot + 1, right, nums, target);
            min = Math.min(result[0], min);
            max = Math.max(result[1], max);
        }
        return new int[]{min, max};
    }
}