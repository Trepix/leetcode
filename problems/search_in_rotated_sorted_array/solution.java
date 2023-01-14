class Solution {
    public int search(int[] nums, int target) {
        return search(0, nums.length - 1, nums, target);
    }

       private int search(int left, int right, int [] nums, int target) {
        if (left > right) return -1;

        int pivot = (right + left) / 2;
        if (nums[pivot] == target) return pivot;

        if (isOrdered(left, pivot, nums)) {
            if (nums[left] <= target && target < nums[pivot]) return search(left, pivot - 1, nums, target);
            else return search(pivot + 1, right, nums, target);
        }
        else {
            if (nums[pivot] < target && target <= nums[right]) return search(pivot + 1, right, nums, target);
            else return search(left, pivot - 1, nums, target);
        }
    }

    private boolean isOrdered(int left, int right, int[] nums) {
        return nums[left] <= nums[right];
    }
}