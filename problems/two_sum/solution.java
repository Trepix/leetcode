class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> number_and_indexs = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; number_and_indexs.put(nums[i], i++))
            if (number_and_indexs.containsKey(target - nums[i]))
                return new int[] {number_and_indexs.get(target - nums[i]), i};
        return new int[] {0, 0};
    }
}
