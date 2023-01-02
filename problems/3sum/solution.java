import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        int size = nums.length;
        if (nums[0] > 0 || nums[size -1] < 0) return new LinkedList<>(result);

        for (int i = 0; i < size - 2 && nums[i] <= 0 ; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = size -1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) ++left;
                    while (left < right && nums[right] == nums[right - 1]) --right;
                    ++left;
                    --right;
                }
                else if (sum > 0) --right;
                else ++left;
            }
        }
        return result;
    }

}