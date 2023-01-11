class Solution { 
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        while (left >= 0 && nums[left + 1] <= nums[left]) {
            --left;
        }
        if (left >= 0) {
            int right = nums.length - 1;
            while (nums[right] <= nums[left]) {
                --right;
            }
            swap(left, right, nums);
        }
        reverse(nums, left + 1);

    }
    private static void swap(int i, int j, int[] nums) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    private static void reverse(int[] nums, int start) {
        for (int i = start, j = nums.length - 1; i < j; i++, j--) {
            swap(i, j, nums);
        }
    }
}