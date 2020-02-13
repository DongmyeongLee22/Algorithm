package leetcode;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];

        int ret = max[0];

        for(int i = 1; i < nums.length; i++){
            int option1 = nums[i];
            int option2 = max[i - 1] * nums[i];
            int option3 = min[i - 1] * nums[i];
            max[i] = Math.max(option1, Math.max(option2, option3));
            min[i] = Math.min(option1, Math.min(option2, option3));

            if(ret < max[i]) ret = max[i];
        }

        return ret;
    }
}
