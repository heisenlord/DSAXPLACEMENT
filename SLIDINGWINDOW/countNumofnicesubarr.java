package SLIDINGWINDOW;
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);

    }

    public int helper(int[] nums, int k) {
        int count = 0, sum = 0, l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r] % 2;
            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }
            count = count + r - l + 1;
            r++;
        }
        return count;

    }
}