
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        boolean i_limit_reached = false;
        for (int i = 0; i < nums.length && !i_limit_reached ; i++) {
            if (nums[i] > 0) i_limit_reached = true;
            boolean j_limit_reached = false;
            int j = i+1, k = nums.length -1;

            while (j < nums.length && !j_limit_reached) {
                if (j >= k) j_limit_reached = true;
                else if (nums[i] + nums[j] + nums[k] == 0) result.add(sortedList(nums[i], nums[j], nums[k]));

                if (Math.abs(nums[i] + nums[j]) < nums[k]) --k;
                else ++j;
            }
        }
        return new LinkedList<>(result);
    }

    static List<Integer> sortedList(int a, int b, int c) {
        int min = Math.min(a, Math.min(b,c));
        int max = Math.max(a, Math.max(b,c));
        int med = a + b + c - min - max;
        return List.of(min, med, max);
    }

}