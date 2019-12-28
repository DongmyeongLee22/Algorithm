package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> value = new ArrayList<>();
            permutation(nums, ret, value);

            return ret;
        }

        public void permutation(int[] nums, List<List<Integer>> ret, List<Integer> value) {

            if (value.size() == nums.length) {
                ret.add(new ArrayList<>(value));
                return;
            }

            for (int num : nums) {
                if (value.contains(num)) continue;
                value.add(num);
                permutation(nums, ret, value);
                value.remove(value.size() - 1);
            }

        }

    }
}
