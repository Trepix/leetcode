import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        final int k = 4;
        Arrays.sort(nums);
        return ksum(nums, new ArrayList<>(k), 0, target, k);
    }

    public List<List<Integer>> ksum(int[] nums, List<Integer> current_numbers, int start, long target, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (start + k > nums.length || (long) nums[start] * k > target || (long) nums[nums.length - 1] * k < target) return result;
        if (k == 2) {
            int left = start , right = nums.length - 1;
            while (left < right) {
                long sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> solution = new LinkedList<>(current_numbers);
                    solution.add(nums[left]);
                    solution.add(nums[right]);
                    result.add(solution);
                    while (left < right && nums[left + 1] == nums[left]) ++left;
                    while (left < right && nums[right - 1] == nums[right]) --right;
                    ++left;
                    --right;
                } else if (sum > target) --right;
                else ++left;
            }
        }
        else {
            for (int i = start; i < nums.length - 1; i++) {
                if (i > start && nums[i - 1] == nums[i]) continue;
                current_numbers.add(nums[i]);
                result.addAll(ksum(nums, current_numbers, i + 1, target - nums[i], k - 1));
                current_numbers.remove(current_numbers.size() - 1);
            }
        }
        return result;
    }
}
