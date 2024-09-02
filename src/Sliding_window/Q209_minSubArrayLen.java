package Sliding_window;

public class Q209_minSubArrayLen {
    public static void main(String[] args) {
        int target = 4;
        int[] nums = {1,4,4};
        System.out.println(minSubArrayLen(target, nums) );
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        //该行代码的意思是 result==Integer.MAX_VALUE吗？是的话该式子为0否则该式子为result
        return result == Integer.MAX_VALUE ? 0 : result;
        }
}
